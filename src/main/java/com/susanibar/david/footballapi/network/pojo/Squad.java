package com.susanibar.david.footballapi.network.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Squad extends Player {
    private String role;
}


