package com.susanibar.david.footballapi.rest;

import com.susanibar.david.footballapi.pojo.response.ProcessorAnalyticResponse;
import com.susanibar.david.footballapi.services.ProcessorService;
import com.susanibar.david.footballapi.services.ProcessorServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Processor.class, ProcessorServiceImpl.class})
public class ProcessorTest {
    @Autowired
    private Processor processor;

    @MockBean
    private ProcessorService processorService;

    @Test
    public void totalPlayersByLeague() {
        Mockito.when(
                processorService.processorTotalPlayersByLeague("CL")
        ).thenReturn(
                10
        );
        ProcessorAnalyticResponse processorAnalyticResponse = processor.totalPlayersByLeague("CL");
        Assert.assertEquals(10, processorAnalyticResponse.getTotal());
    }
}