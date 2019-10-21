package com.susanibar.david.footballapi.services;

public interface ProcessorService {
    void processorImportLeague(String leagueCode);
    int processorTotalPlayersByLeague(String leagueCode);
}
