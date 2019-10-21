package com.susanibar.david.footballapi.network.service;

import com.susanibar.david.footballapi.network.pojo.Team;
import com.susanibar.david.footballapi.network.pojo.TeamByCompetition;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiFootballData {
    @GET("/v2/competitions/{id}/teams")
    Call<TeamByCompetition> obtainTeamByCompetition(@Path("id") String idLocal);

    @GET("/v2/teams/{id}")
    Call<Team> obtainTeamById(@Path("id") String idLocal);
}
