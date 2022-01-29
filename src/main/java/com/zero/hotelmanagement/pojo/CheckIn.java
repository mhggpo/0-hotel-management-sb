package com.zero.hotelmanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn {
    private Integer roomRegister;
    private Integer id;
    private Integer user;
    private Date checkInDate;
    private String remarks;
    private Boolean provideBreakfast;
    private Boolean provideClock;
    private Integer preRoomID;
}
