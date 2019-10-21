package com.susanibar.david.footballapi.rest;

import com.susanibar.david.footballapi.pojo.response.ProcessorResponse;
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
    public ProcessorResponse impotLeague(@PathVariable(name="leagueCode") String localLeagueCode){

        processorService.processorImportLeague(localLeagueCode);

        return new ProcessorResponse("Successfully imported");
    }
}
