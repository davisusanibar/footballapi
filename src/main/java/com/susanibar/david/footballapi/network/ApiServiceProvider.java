package com.susanibar.david.footballapi.network;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class ApiServiceProvider {
    private static final String BASE_URL = "https://api.football-data.org/v2/";

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static OkHttpClient.Builder okHttpClientBuilder =
            new OkHttpClient.Builder().readTimeout(15, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(25, TimeUnit.SECONDS);;

    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC);

    public static <S> S endpointToCall(Class<S> servicio, String xAuthToken){
        //header to handle authorization
        ConnectionPool pool = new ConnectionPool(5, 1, TimeUnit.SECONDS);
        okHttpClientBuilder.connectionPool(pool);

        okHttpClientBuilder.addInterceptor(logging);

        okHttpClientBuilder.addInterceptor(
                chain -> {
                    Request initialRequest = chain.request();

                    Request.Builder myIntermediateRequest = initialRequest
                            .newBuilder().addHeader("X-Auth-Token", xAuthToken);

                    Request finalRequest = myIntermediateRequest.build();

                    return chain.proceed(finalRequest);
                }
        );

        retrofitBuilder.client(okHttpClientBuilder.build());

        return retrofitBuilder.build().create(servicio);
    }
}
