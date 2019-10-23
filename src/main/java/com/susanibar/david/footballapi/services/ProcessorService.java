package com.susanibar.david.footballapi.services;

import com.susanibar.david.footballapi.exception.ProcessorException;
import com.susanibar.david.footballapi.jpa.entity.CompetitionEntity;

public interface ProcessorService {
    CompetitionEntity processorImportLeague(String leagueCode) throws ProcessorException;
    void processorImportLeague(String leagueCode, int localRoundTripeQuantity);
    int processorTotalPlayersByLeague(String leagueCode);
}
