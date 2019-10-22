package com.susanibar.david.footballapi.services;

import com.susanibar.david.footballapi.exception.ProcessorException;

public interface ProcessorService {
    void processorImportLeague(String leagueCode) throws ProcessorException;
    void processorImportLeague(String leagueCode, int localRoundTripeQuantity);
    int processorTotalPlayersByLeague(String leagueCode);
}
