package com.susanibar.david.footballapi.network.pojo;

import lombok.Data;

@Data
public class Team {
    private String id;
    private String name;
    private String tla;
    private String shortName;
    private Area area;
    private String email;
}
