package com.susanibar.david.footballapi.helpers;

import com.susanibar.david.footballapi.network.pojo.Team;
import com.susanibar.david.footballapi.network.pojo.TeamByCompetition;

public interface ApiFootballHelper {
    TeamByCompetition obtainTeamByCompetition(String leagueCode);
    Team obtainTeamById(String idLocal);
}
