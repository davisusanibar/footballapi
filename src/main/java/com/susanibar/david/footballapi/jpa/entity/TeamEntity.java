package com.susanibar.david.footballapi.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "team")
public class TeamEntity {
    @Id
    private String id;
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

    public TeamEntity(String id, String name, String tla, String shortName, String areaName, String email) {
        this.id = id;
        this.name = name;
        this.tla = tla;
        this.shortName = shortName;
        this.areaName = areaName;
        this.email = email;
    }
}
