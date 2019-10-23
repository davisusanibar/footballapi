package com.susanibar.david.footballapi.exception.handler;

import com.susanibar.david.footballapi.exception.ProcessorException;
import com.susanibar.david.footballapi.helpers.ApiFootballHelper;
import com.susanibar.david.footballapi.helpers.ApiFootballHelperImpl;
import com.susanibar.david.footballapi.jpa.repository.CompetitionDAO;
import com.susanibar.david.footballapi.network.pojo.TeamByCompetition;
import com.susanibar.david.footballapi.services.ProcessorService;
import com.susanibar.david.footballapi.services.ProcessorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ProcessorServiceImpl.class, ApiFootballHelperImpl.class})
public class ProcesorCustomGlobalExceptionHandlerTest {
    @MockBean
    private CompetitionDAO competitionDAO;

    @MockBean
    private ApiFootballHelper apiFootballHelper;

    @SpyBean
    private ProcessorService processorService;

    @Test(expected = ProcessorException.class)
    public void handleApiErrorException() {
        Mockito.when(
                apiFootballHelper.obtainTeamByCompetition(
                        Mockito.anyString()
                )
        ).thenReturn(
                new TeamByCompetition()
        );

        Mockito.when(
                competitionDAO.validateIfLeagueWasImported(Mockito.anyString())
        ).thenReturn(
                1
        );

        processorService.processorImportLeague("CL");
    }
}