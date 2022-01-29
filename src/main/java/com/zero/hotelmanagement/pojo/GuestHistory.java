package com.zero.hotelmanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestHistory {
    private Integer id;
    private String name;
    private String guestIdType;
    private String guestId;
    private String tel;
}
