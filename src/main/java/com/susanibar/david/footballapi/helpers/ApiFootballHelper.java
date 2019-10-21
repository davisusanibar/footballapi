package com.susanibar.david.footballapi.helpers;

import com.susanibar.david.footballapi.exception.ProcessorException;
import com.susanibar.david.footballapi.network.pojo.Team;
import com.susanibar.david.footballapi.network.pojo.TeamByCompetition;

public interface ApiFootballHelper {
    TeamByCompetition obtainTeamByCompetition(String leagueCode) throws ProcessorException;
    Team obtainTeamById(String idLocal);
}
