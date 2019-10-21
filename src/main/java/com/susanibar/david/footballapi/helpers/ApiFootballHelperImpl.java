package com.susanibar.david.footballapi.helpers;

import com.susanibar.david.footballapi.network.ApiServiceProvider;
import com.susanibar.david.footballapi.network.pojo.Team;
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
        TeamByCompetition teamByCompetition = new TeamByCompetition();
        ApiFootballData apiFootballData = ApiServiceProvider.endpointToCall(ApiFootballData.class, xAuthToken);

        Call<TeamByCompetition> teamByCompetitionCall = apiFootballData.obtainTeamByCompetition(leagueCode);

        try {
            Response<TeamByCompetition> teamByCompetitionResponse = teamByCompetitionCall.execute();

            if (teamByCompetitionResponse.isSuccessful()){
                teamByCompetition = teamByCompetitionResponse.body();
            } else {
                //call exception
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return teamByCompetition;
    }

    @Override
    public Team obtainTeamById(String idLocal) {
        Team team = new Team();
        ApiFootballData apiFootballData = ApiServiceProvider.endpointToCall(ApiFootballData.class, xAuthToken);

        Call<Team> teamCall = apiFootballData.obtainTeamById(idLocal);

        try {
            Response<Team> teamResponse = teamCall.execute();

            if (teamResponse.isSuccessful()){
                team = teamResponse.body();
            } else {
                //call exception
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return team;
    }
}
