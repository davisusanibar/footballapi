package com.susanibar.david.footballapi.services;

import com.susanibar.david.footballapi.exception.ProcessorException;
import com.susanibar.david.footballapi.helpers.ApiFootballHelper;
import com.susanibar.david.footballapi.jpa.entity.CompetitionEntity;
import com.susanibar.david.footballapi.jpa.entity.PlayerEntity;
import com.susanibar.david.footballapi.jpa.entity.TeamEntity;
import com.susanibar.david.footballapi.jpa.repository.CompetitionDAO;
import com.susanibar.david.footballapi.network.pojo.Squad;
import com.susanibar.david.footballapi.network.pojo.Team;
import com.susanibar.david.footballapi.network.pojo.TeamByCompetition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessorServiceImpl implements ProcessorService {

    @Autowired
    private ApiFootballHelper apiFootballHelper;

    @Autowired
    private CompetitionDAO competitionDAO;


    @Override
    public CompetitionEntity processorImportLeague(String leagueCode) throws ProcessorException {
        try {
            TeamByCompetition teamByCompetition =
                    apiFootballHelper.obtainTeamByCompetition(leagueCode);


            int leagueCodeImported = competitionDAO.validateIfLeagueWasImported(leagueCode);
            if (leagueCodeImported > 0){
                throw new ProcessorException("League already imported", HttpStatus.CONFLICT);
            }

            return competitionDAO.save(
                    getCompetitionEntity(
                            teamByCompetition
                    )
            );
        } catch (ProcessorException e) {
            throw e;
        } catch (Exception e) {
            throw new ProcessorException(e, "Server error", HttpStatus.GATEWAY_TIMEOUT);
        }
    }

    @Override
    public void processorImportLeague(String leagueCode, int localRoundTripeQuantity) {
        try {
            TeamByCompetition teamByCompetition =
                    apiFootballHelper.obtainTeamByCompetition(leagueCode);


            int leagueCodeImported = competitionDAO.validateIfLeagueWasImported(leagueCode);
            if (leagueCodeImported > 0){
                throw new ProcessorException("League already imported", HttpStatus.CONFLICT);
            }

            competitionDAO.save(
                    getCompetitionEntity(
                            teamByCompetition, localRoundTripeQuantity
                    )
            );
        } catch (ProcessorException e) {
            throw e;
        } catch (Exception e) {
            throw new ProcessorException(e, "Server error", HttpStatus.GATEWAY_TIMEOUT);
        }
    }

    private CompetitionEntity getCompetitionEntity(TeamByCompetition teamByCompetition, int localRoundTripeQuantity) {
        // Competition
        CompetitionEntity competitionEntity = new CompetitionEntity(
                Integer.parseInt(teamByCompetition.getCompetition().getId()),
                teamByCompetition.getCompetition().getName(),
                teamByCompetition.getCompetition().getCode(),
                teamByCompetition.getCompetition().getArea().getName()
        );

        // Teams
        List<Team> listTeam = teamByCompetition.getTeams();
        int contador = 0;
        for (Team team : listTeam) {
            TeamEntity teamEntity = new TeamEntity(
                    Integer.parseInt(team.getId()),
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
                if (contador < localRoundTripeQuantity) {
                    teamAndSquad = apiFootballHelper.obtainTeamById(team.getId());


                    for (Squad squad : teamAndSquad.getSquad()) {
                        if (squad.getRole().equalsIgnoreCase("PLAYER")) {
                            teamEntity.addPlayer(
                                    new PlayerEntity(
                                            Integer.parseInt(squad.getId()),
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

    @Override
    public int processorTotalPlayersByLeague(String leagueCode) {

        return competitionDAO.totalPlayersByLeague(leagueCode);
    }

    private CompetitionEntity getCompetitionEntity(TeamByCompetition teamByCompetition) {
        // Competition
        CompetitionEntity competitionEntity = new CompetitionEntity(
                Integer.parseInt(teamByCompetition.getCompetition().getId()),
                teamByCompetition.getCompetition().getName(),
                teamByCompetition.getCompetition().getCode(),
                teamByCompetition.getCompetition().getArea().getName()
        );

        // Teams
        List<Team> listTeam = teamByCompetition.getTeams();
        for (Team team : listTeam) {
            TeamEntity teamEntity = new TeamEntity(
                    Integer.parseInt(team.getId()),
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
                teamAndSquad = apiFootballHelper.obtainTeamById(team.getId());


                for (Squad squad : teamAndSquad.getSquad()) {
                    if (squad.getRole().equalsIgnoreCase("PLAYER")) {
                        teamEntity.addPlayer(
                                new PlayerEntity(
                                        Integer.parseInt(squad.getId()),
                                        squad.getName(),
                                        squad.getPosition(),
                                        squad.getDateOfBirth(),
                                        squad.getCountryOfBirth(),
                                        squad.getNationality()
                                )
                        );
                    }
                }
            } catch (Exception e) {
                System.out.println("teamByCompetition = [" + teamByCompetition + "]");
            }
        }

        return competitionEntity;
    }
}
