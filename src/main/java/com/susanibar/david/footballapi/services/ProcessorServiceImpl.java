package com.susanibar.david.footballapi.services;

import com.susanibar.david.footballapi.helpers.ApiFootballHelper;
import com.susanibar.david.footballapi.jpa.entity.CompetitionEntity;
import com.susanibar.david.footballapi.jpa.entity.TeamEntity;
import com.susanibar.david.footballapi.jpa.repository.CompetitionDAO;
import com.susanibar.david.footballapi.network.pojo.Team;
import com.susanibar.david.footballapi.network.pojo.TeamByCompetition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessorServiceImpl implements ProcessorService {

    @Autowired
    ApiFootballHelper apiFootballHelper;

    @Autowired
    CompetitionDAO competitionDAO;


    @Override
    public void processorImportLeague(String leagueCode) {
        TeamByCompetition teamByCompetition =
                apiFootballHelper.obtainTeamByCompetition(leagueCode);

        competitionDAO.save(
                getCompetitionEntity(
                        teamByCompetition
                )
        );
    }


    private CompetitionEntity getCompetitionEntity(TeamByCompetition teamByCompetition) {
        CompetitionEntity competitionEntity = new CompetitionEntity(
                teamByCompetition.getCompetition().getId(),
                teamByCompetition.getCompetition().getName(),
                teamByCompetition.getCompetition().getCode(),
                teamByCompetition.getCompetition().getArea().getName()
        );

        List<Team> listTeam = teamByCompetition.getTeams();
        for (Team team : listTeam) {
            competitionEntity.addTeam(
                    new TeamEntity(
                            team.getId(),
                            team.getName(),
                            team.getTla(),
                            team.getShortName(),
                            team.getArea().getName(),
                            team.getEmail()
                    )
            );
        }

        return competitionEntity;
    }
}
