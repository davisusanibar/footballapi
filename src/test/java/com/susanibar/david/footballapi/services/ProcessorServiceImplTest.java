package com.susanibar.david.footballapi.services;

import com.susanibar.david.footballapi.helpers.ApiFootballHelper;
import com.susanibar.david.footballapi.helpers.ApiFootballHelperImpl;
import com.susanibar.david.footballapi.jpa.entity.CompetitionEntity;
import com.susanibar.david.footballapi.jpa.entity.PlayerEntity;
import com.susanibar.david.footballapi.jpa.entity.TeamEntity;
import com.susanibar.david.footballapi.jpa.repository.CompetitionDAO;
import com.susanibar.david.footballapi.network.pojo.Area;
import com.susanibar.david.footballapi.network.pojo.Competition;
import com.susanibar.david.footballapi.network.pojo.Team;
import com.susanibar.david.footballapi.network.pojo.TeamByCompetition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ProcessorServiceImpl.class, ApiFootballHelperImpl.class})
public class ProcessorServiceImplTest {

    @MockBean
    private ApiFootballHelper apiFootballHelper;

    @MockBean
    private CompetitionDAO competitionDAO;

    @SpyBean
    private ProcessorService processorService;

    // pojo
    private Area areaCompetition;
    private Competition competition;
    private Area areaTeam;
    private Team team;
    private List<Team> teams;
    // entities
    private CompetitionEntity competitionEntity;
    private TeamEntity teamEntity;
    private PlayerEntity playerEntity;
    private TeamByCompetition teamByCompetition;

    @Before
    public void init(){
        // POJO
        areaCompetition = new Area("1", "Europe");
        Competition competition = new Competition("1", "UEFA Champions League", "CL", areaCompetition);

        areaTeam = new Area("1", "Europe");
        team = new Team("1", "Chelsea FC", "CHE", "Chelsea", areaTeam, "info@chelsea.com", null);
        teams = Arrays.asList(team);

        teamByCompetition = new TeamByCompetition(competition, teams);

        // ENTITY
        competitionEntity = new CompetitionEntity(1, "UEFA Champions League", "CL", "Europe");

        teamEntity = new TeamEntity(1, "Chelsea FC", "CHE", "Chelsea", "Europe", "info@chelsea.com");
        competitionEntity.addTeam(teamEntity);

        playerEntity = new PlayerEntity(1, "Cristiano Ronaldo", "Attacker", "1984-12-31", "Portugal", "Portugal");
        teamEntity.addPlayer(playerEntity);
    }


    @Test
    public void processorImportLeague() {
        Mockito.when(
                apiFootballHelper.obtainTeamByCompetition(
                        Mockito.anyString()
                )
        ).thenReturn(
                teamByCompetition
        );

        Mockito.when(
                competitionDAO.validateIfLeagueWasImported(Mockito.anyString())
        ).thenReturn(
                0
        );

        Mockito.when(
                competitionDAO.save(Mockito.any())
        ).thenReturn(
                competitionEntity
        );

        CompetitionEntity competitionEntityExpected =
                processorService.processorImportLeague("CL");

        Assert.assertEquals(
                competitionEntityExpected.getCode(),
                competitionEntity.getCode()
        );
    }

    @Test
    public void processorTotalPlayersByLeague() {
        Mockito.when(
                competitionDAO.totalPlayersByLeague(Mockito.anyString())
        ).thenReturn(
                1
        );

        Assert.assertEquals(
                1,
                processorService.processorTotalPlayersByLeague(Mockito.anyString())
        );
    }
}