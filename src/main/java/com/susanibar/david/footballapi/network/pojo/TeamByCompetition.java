package com.susanibar.david.footballapi.network.pojo;

import lombok.Data;

import java.util.List;

@Data
public class TeamByCompetition {
    private Competition competition;
    private List<Team> teams;
}
