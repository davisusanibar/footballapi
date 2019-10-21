package com.susanibar.david.footballapi.rest;

import com.susanibar.david.footballapi.pojo.response.ProcessorAnalyticResponse;
import com.susanibar.david.footballapi.pojo.response.ProcessorImportResponse;
import com.susanibar.david.footballapi.services.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Processor {

    @Autowired
    ProcessorService processorService;

    @GetMapping("/import-league/{leagueCode}")
    public ProcessorImportResponse importLeague(@PathVariable(name="leagueCode") String localLeagueCode){

        processorService.processorImportLeague(localLeagueCode);

        return new ProcessorImportResponse("Successfully imported");
    }

    @GetMapping("/total-players/{leagueCode}")
    public ProcessorAnalyticResponse totalPlayersByLeague(@PathVariable(name="leagueCode") String localLeagueCode){
        int totalPlayersByLeague = processorService.processorTotalPlayersByLeague(localLeagueCode);

        return new ProcessorAnalyticResponse(totalPlayersByLeague);
    }
}
