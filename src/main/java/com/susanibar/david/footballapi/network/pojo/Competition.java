package com.susanibar.david.footballapi.network.pojo;

import lombok.Data;

@Data
public class Competition {
    private String id;
    private String name;
    private String code;
    private Area area;
}
