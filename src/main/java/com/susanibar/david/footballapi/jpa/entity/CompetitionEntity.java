package com.susanibar.david.footballapi.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "competition")
public class CompetitionEntity {
    @Id
    private String id;
    private String name;
    private String code;
    private String areaName;
    @OneToMany(
            mappedBy = "competition",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private Set<TeamEntity> teams = new HashSet<TeamEntity>();

    public void addTeam(TeamEntity teamEntity){
        teamEntity.setCompetition(this);
        teams.add(teamEntity);
    }

    public void removeTeam(TeamEntity teamEntity){
        teamEntity.setCompetition(null);
        teams.remove(teamEntity);
    }

    public CompetitionEntity(String id, String name, String code, String areaName) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.areaName = areaName;
    }
}