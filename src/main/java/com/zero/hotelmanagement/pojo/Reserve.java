package com.zero.hotelmanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserve {
    private Integer roomRegister;
    private Integer id;
    private String status;
    private Integer user;
    private Date reserveDate;
    private String remarks;
}
