package com.zero.hotelmanagement.controller;
import com.zero.hotelmanagement.pojo.Room;
import com.zero.hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Controller
@RestController
@CrossOrigin
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){
        this.roomService=roomService;
    }

    @RequestMapping("getRoom")
    @ResponseBody
    public HashMap<String,Object> getRoom(String page)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<Room> roomList= roomService.getRoom(Integer.parseInt(page));
        int count=roomService.countAllRooms();
        List<String> rtype=roomService.countRoomTypes();
        List<String> ftype=roomService.countFloorTypes();
        map.put("count",count);
        map.put("OptionType",rtype);
        map.put("OptionFloor",ftype);
        map.put("List",roomList);
        return map;
    }

    @RequestMapping("delRoom")
    @ResponseBody
    public HashMap<String,Object> delRoom(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryDelRoom:ID:"+id);
        boolean isSuccess= roomService.deleteRoom(Integer.parseInt(id))>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("addRoom")
    @ResponseBody
    public HashMap<String,Object> addRoom(Room room)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryAddRoom:"+room);
        boolean isSuccess=roomService.insertRoom(room)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("editRoom")
    @ResponseBody
    public HashMap<String,Object> editRoom(Room room)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryUpdateRoom:"+room);
        boolean isSuccess=roomService.updateRoom(room)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("selectRoom")
    @ResponseBody
    public HashMap<String,Object> selectRoom(Room room)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<Room> roomList= roomService.selectRoom(room);
        map.put("List",roomList);
        return map;
    }
}
