package com.zero.hotelmanagement.info;

import com.zero.hotelmanagement.pojo.Reserve;
import com.zero.hotelmanagement.pojo.RoomRegister;
import com.zero.hotelmanagement.pojo.User;
import com.zero.hotelmanagement.service.RoomRegisterService;
import com.zero.hotelmanagement.service.UserService;
import lombok.Data;

import java.util.List;

@Data
public class ReserveInfo {
    private Reserve reserve;
    private List<RoomRegister> roomRegister;
    private List<User> user;

    public ReserveInfo(Reserve src, RoomRegisterService roomRegisterService, UserService userService)
    {
        reserve=src;
        roomRegister=roomRegisterService.selectRoomRegisterById(reserve.getRoomRegister());
        user=userService.selectUserById(reserve.getUser());
    }
}
