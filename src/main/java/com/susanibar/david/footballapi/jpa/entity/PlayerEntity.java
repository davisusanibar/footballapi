package com.susanibar.david.footballapi.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PLAYER")
// FIXME: Add auditing columns
public class PlayerEntity {
    @Id
    private Integer id;
    private String name;
    private String position;
    private String dateOfBirth;
    private String countryOfBirth;
    private String nationality;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "teamId"
    )
    private TeamEntity team;

    public PlayerEntity(Integer id, String name, String position, String dateOfBirth, String countryOfBirth, String nationality) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.nationality = nationality;
    }
}
