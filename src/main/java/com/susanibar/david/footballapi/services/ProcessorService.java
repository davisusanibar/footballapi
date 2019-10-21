package com.susanibar.david.footballapi.services;

import com.susanibar.david.footballapi.exception.ProcessorException;

public interface ProcessorService {
    void processorImportLeague(String leagueCode) throws ProcessorException;
    int processorTotalPlayersByLeague(String leagueCode);
}
