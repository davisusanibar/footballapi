package com.susanibar.david.footballapi.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TEAM")
// FIXME: Add auditing columns
public class TeamEntity {
    @Id
    private Integer id;
    private String name;
    private String tla;
    private String shortName;
    private String areaName;
    private String email;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "competitionId")
    private CompetitionEntity competition;

    @OneToMany(
            mappedBy = "team",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PlayerEntity> players = new HashSet<PlayerEntity>();

    public TeamEntity(Integer id, String name, String tla, String shortName, String areaName, String email) {
        this.id = id;
        this.name = name;
        this.tla = tla;
        this.shortName = shortName;
        this.areaName = areaName;
        this.email = email;
    }

    public void addPlayer(PlayerEntity playerEntity){
        playerEntity.setTeam(this);
        players.add(playerEntity);
    }

    public void removePlayer(PlayerEntity playerEntity){
        playerEntity.setTeam(null);
        players.remove(playerEntity);
    }
}
