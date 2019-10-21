package com.susanibar.david.footballapi.network.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Team {
    private String id;
    private String name;
    private String tla;
    private String shortName;
    private Area area;
    private String email;
    private List<Squad> squad;
}
