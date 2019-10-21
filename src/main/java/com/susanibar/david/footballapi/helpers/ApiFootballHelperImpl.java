package com.susanibar.david.footballapi.helpers;

import com.susanibar.david.footballapi.network.ApiServiceProvider;
import com.susanibar.david.footballapi.network.pojo.TeamByCompetition;
import com.susanibar.david.footballapi.network.service.ApiFootballData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Component
public class ApiFootballHelperImpl implements ApiFootballHelper {

    @Value("${football.x.auth.token}")
    private String xAuthToken;

    @Override
    public TeamByCompetition obtainTeamByCompetition(String leagueCode) {
        ApiFootballData apiFootballData = ApiServiceProvider.endpointToCall(ApiFootballData.class, xAuthToken);

        Call<TeamByCompetition> teamByCompetitionCall = apiFootballData.obtainTeamByCompetition(leagueCode);

        try {
            Response<TeamByCompetition> teamByCompetitionResponse = teamByCompetitionCall.execute();

            if (teamByCompetitionResponse.isSuccessful()){
                return teamByCompetitionResponse.body();
            } else {
                //call exception
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
