package com.susanibar.david.footballapi.network.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamByCompetition {
    private Competition competition;
    private List<Team> teams;
}
