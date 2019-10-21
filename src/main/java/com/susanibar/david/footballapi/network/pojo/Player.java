package com.susanibar.david.footballapi.network.pojo;

import lombok.Data;

@Data
public class Player {
    private String id;
    private String name;
    private String position;
    private String dateOfBirth;
    private String countryOfBirth;
    private String nationality;
}
