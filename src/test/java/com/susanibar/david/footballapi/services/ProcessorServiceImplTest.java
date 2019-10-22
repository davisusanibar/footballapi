package com.susanibar.david.footballapi.services;

import com.susanibar.david.footballapi.helpers.ApiFootballHelper;
import com.susanibar.david.footballapi.jpa.repository.CompetitionDAO;
import com.susanibar.david.footballapi.network.pojo.Area;
import com.susanibar.david.footballapi.network.pojo.Competition;
import com.susanibar.david.footballapi.network.pojo.Team;
import com.susanibar.david.footballapi.network.pojo.TeamByCompetition;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = {ProcessorService.class, ApiFootballHelper.class, CompetitionDAO.class})
class ProcessorServiceImplTest {

    @MockBean
    private ApiFootballHelper apiFootballHelper;

    @Autowired
    private ProcessorService processorService;

    @Autowired
    private CompetitionDAO competitionDAO;

    private TeamByCompetition teamByCompetition;

    @Before
    public void init(){
        Area areaCompetition = new Area("1", "Europe");
        Competition competition = new Competition("1", "UEFA Champions League", "CL", areaCompetition);

        Area areaTeam = new Area("1", "Europe");
        Team team = new Team("1", "Chelsea FC", "CHE", "Chelsea", areaTeam, "info@chelsea.com", null);
        List<Team> teams = Arrays.asList(team);

        teamByCompetition = new TeamByCompetition(competition, teams);
    }


    @Test
    public void processorImportLeague() {
        Mockito.when(
                apiFootballHelper.obtainTeamByCompetition(
                        Mockito.anyString()
                )
        ).thenReturn(
                new TeamByCompetition()
        );

        processorService.processorImportLeague("");
    }

    @Test
    public void processorImportLeague1() {
    }

    @Test
    public void processorTotalPlayersByLeague() {
    }
}