package com.zero.hotelmanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckOut {
    private Integer id;
    private CheckIn checkIn;
    private Integer days;
    private Integer cost;
    private Double foodPrice;
    private Double telPrice;
    private  Double shouldPrice;
    private Double shouldDeposit;
    private String wayToPay;
    private Double realRecived;
    private  Double giveChange;
    private  Integer user;
    private  String remarks;
}
