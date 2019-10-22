package com.susanibar.david.footballapi.rest;

import com.susanibar.david.footballapi.exception.ProcessorException;
import com.susanibar.david.footballapi.pojo.response.ProcessorAnalyticResponse;
import com.susanibar.david.footballapi.pojo.response.ProcessorImportResponse;
import com.susanibar.david.footballapi.services.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Processor {

    @Autowired
    private ProcessorService processorService;

    @GetMapping("/import-league/{leagueCode}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity importLeague(
            @PathVariable(name="leagueCode") String localLeagueCode
    ) throws ProcessorException {

        processorService.processorImportLeague(localLeagueCode);

        return new ResponseEntity(
                new ProcessorImportResponse("Successfully imported"),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/import-league/{leagueCode}/{roundTripeQuantity}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity importLeague(
            @PathVariable(name="leagueCode") String localLeagueCode,
            @PathVariable(name="roundTripeQuantity") int localRoundTripeQuantity
    ) throws ProcessorException {

        processorService.processorImportLeague(localLeagueCode, localRoundTripeQuantity);

        return new ResponseEntity(
                new ProcessorImportResponse("Successfully imported"),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/total-players/{leagueCode}")
    public ProcessorAnalyticResponse totalPlayersByLeague(
            @PathVariable(name="leagueCode") String localLeagueCode
    ){
        int totalPlayersByLeague = processorService.processorTotalPlayersByLeague(localLeagueCode);

        return new ProcessorAnalyticResponse(totalPlayersByLeague);
    }
}
