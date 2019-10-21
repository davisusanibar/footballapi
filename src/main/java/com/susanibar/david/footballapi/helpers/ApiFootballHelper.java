package com.susanibar.david.footballapi.helpers;

import com.susanibar.david.footballapi.network.pojo.TeamByCompetition;

public interface ApiFootballHelper {
    TeamByCompetition obtainTeamByCompetition(String leagueCode);
}
