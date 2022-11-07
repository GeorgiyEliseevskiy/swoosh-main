package com.SWOOSH.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoDTO {

    private int id;
    private int user_id;
    private String promocode;
    private boolean status;
}
