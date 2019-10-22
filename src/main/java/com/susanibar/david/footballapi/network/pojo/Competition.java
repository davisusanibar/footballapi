package com.susanibar.david.footballapi.network.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competition {
    private String id;
    private String name;
    private String code;
    private Area area;
}
