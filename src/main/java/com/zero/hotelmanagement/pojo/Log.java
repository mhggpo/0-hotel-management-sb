package com.zero.hotelmanagement.pojo;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private Integer id;
    private Integer uid;
    private String operation;
    private Timestamp time;
    private String remarks;
}
