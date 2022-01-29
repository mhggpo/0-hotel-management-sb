package com.zero.hotelmanagement.info;

import com.zero.hotelmanagement.pojo.CheckIn;
import com.zero.hotelmanagement.pojo.Room;
import com.zero.hotelmanagement.pojo.RoomRegister;
import com.zero.hotelmanagement.service.RoomRegisterService;
import com.zero.hotelmanagement.service.RoomService;
import lombok.Data;

import java.util.List;

@Data
public class CheckInInfo {
    private CheckIn checkIn;
    private List<RoomRegister> roomRegisters;
    private List<Room> rooms;

    public CheckInInfo(CheckIn checkIn, RoomRegisterService roomRegisterService, RoomService roomService)
    {
        this.checkIn=checkIn;
        roomRegisters=roomRegisterService.selectRoomRegisterById(checkIn.getRoomRegister());
        rooms=roomService.selectRoomById(roomRegisters.get(0).getRoom());
    }
}
