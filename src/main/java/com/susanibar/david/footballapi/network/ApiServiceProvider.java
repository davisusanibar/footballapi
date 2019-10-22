package com.susanibar.david.footballapi.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiServiceProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiServiceProvider.class);

    private static final String BASE_URL = "https://api.football-data.org/";

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static OkHttpClient.Builder okHttpClientBuilder =
            new OkHttpClient.Builder();

    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC);

    public static <S> S endpointToCall(Class<S> service, String xAuthToken){
        // testing purpose
        okHttpClientBuilder.addInterceptor(logging);

        // header to handle authorization
        okHttpClientBuilder.addInterceptor(
                chain -> {
                    Request finalRequest = footballApiAddSecurityHeader(xAuthToken, chain);

                    return footballApiHandleCoverageFreePlan(chain, finalRequest);
                }
        );

        // adding header to handle authorization to retrofit
        retrofitBuilder.client(okHttpClientBuilder.build());

        // building retrofit for service needed
        return retrofitBuilder.build().create(service);
    }

    private static Request footballApiAddSecurityHeader(String xAuthToken, Interceptor.Chain chain) throws IOException {
        Request initialRequest = chain.request();

        Request.Builder myIntermediateRequest = initialRequest
                .newBuilder().addHeader("X-Auth-Token", xAuthToken);

        Request finalRequest = myIntermediateRequest.build();

        return finalRequest;
    }

    private static Response footballApiHandleCoverageFreePlan(Interceptor.Chain chain, Request request) {
        Response response = null;
        try {
            response = chain.proceed(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // handle 429 = Too Many Requests
        if(!response.isSuccessful()) {
            String responseBodyMessage = null;
            switch (response.code()) {
                case 429:
                    try {
                        responseBodyMessage = response.body().string();
                        LOGGER.error("Reached your request limit: " + responseBodyMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // be controlled
                    reachedYourRequestLimit(responseBodyMessage);

                    // retry the request
                    response = retryTheRequest(chain, request);

                    break;
                default:
                    break;
            }
        }
        return response;
    }

    private static Response retryTheRequest(Interceptor.Chain chain, Request request) {
        Response response = null;
        try {
            LOGGER.info("Re-processing request: " + request.url());
            response = chain.proceed(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private static void reachedYourRequestLimit(String responseBodyMessage) {
        Pattern p = Pattern.compile("(?<=Wait )\\d+");
        Matcher m = p.matcher(responseBodyMessage);
        if (m.find()) {
            LOGGER.info("Wait For: " + m.group());
            try {
                Thread.sleep(Long.parseLong(m.group())*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
