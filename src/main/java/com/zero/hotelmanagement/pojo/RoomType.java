package com.zero.hotelmanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomType {
    private String name;
    private Integer capacity;
    private String remarks;
}
