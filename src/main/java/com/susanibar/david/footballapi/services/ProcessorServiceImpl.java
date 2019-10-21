package com.susanibar.david.footballapi.services;

import com.susanibar.david.footballapi.helpers.ApiFootballHelper;
import com.susanibar.david.footballapi.jpa.entity.CompetitionEntity;
import com.susanibar.david.footballapi.jpa.entity.PlayerEntity;
import com.susanibar.david.footballapi.jpa.entity.TeamEntity;
import com.susanibar.david.footballapi.jpa.repository.CompetitionDAO;
import com.susanibar.david.footballapi.network.pojo.Squad;
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

    @Override
    public int processorTotalPlayersByLeague(String leagueCode) {

        return competitionDAO.totalPlayersByLeague(leagueCode);
    }


    private CompetitionEntity getCompetitionEntity(TeamByCompetition teamByCompetition) {
        // Competition
        CompetitionEntity competitionEntity = new CompetitionEntity(
                teamByCompetition.getCompetition().getId(),
                teamByCompetition.getCompetition().getName(),
                teamByCompetition.getCompetition().getCode(),
                teamByCompetition.getCompetition().getArea().getName()
        );

        // Teams
        List<Team> listTeam = teamByCompetition.getTeams();
        int contador = 0;
        for (Team team : listTeam) {
            TeamEntity teamEntity = new TeamEntity(
                    team.getId(),
                    team.getName(),
                    team.getTla(),
                    team.getShortName(),
                    team.getArea().getName(),
                    team.getEmail()
            );

            competitionEntity.addTeam(
                    teamEntity
            );

            // Players
            Team teamAndSquad;
            try {
                if (contador < 4) {
                    teamAndSquad = apiFootballHelper.obtainTeamById(team.getId());


                    for (Squad squad : teamAndSquad.getSquad()) {
                        if (squad.getRole().equalsIgnoreCase("PLAYER")) {
                            teamEntity.addPlayer(
                                    new PlayerEntity(
                                            squad.getId(),
                                            squad.getName(),
                                            squad.getPosition(),
                                            squad.getDateOfBirth(),
                                            squad.getCountryOfBirth(),
                                            squad.getNationality()
                                    )
                            );
                        }
                    }
                    contador++;
                }
            } catch (Exception e) {
                System.out.println("teamByCompetition = [" + teamByCompetition + "]");
            }
        }

        return competitionEntity;
    }
}
