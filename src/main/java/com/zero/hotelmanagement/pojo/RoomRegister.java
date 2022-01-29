package com.zero.hotelmanagement.pojo;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRegister {
    private Integer id;
    private Integer room;
    private Double deposit;
    private String guestName;
    private String guestIdType;
    private String guestId;
    private String tel;
    private Timestamp arriveTime;
    private Timestamp leaveTime;
    private Integer guestCount;
    private Integer memberId;
}
