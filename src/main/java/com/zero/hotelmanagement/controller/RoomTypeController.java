package com.zero.hotelmanagement.controller;

import com.zero.hotelmanagement.pojo.RoomType;
import com.zero.hotelmanagement.pojo.User;
import com.zero.hotelmanagement.service.RoomTypeService;
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
public class RoomTypeController {
    private final RoomTypeService roomTypeService;

    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService){
        this.roomTypeService=roomTypeService;
    }

    @RequestMapping("getRoomType")
    @ResponseBody
    public HashMap<String,Object> getRoomType(String page)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<RoomType> roomTypeList= roomTypeService.getRoomType(Integer.parseInt(page));
        int count=roomTypeService.countAllRoomTypes();
        map.put("count",count);
        map.put("List",roomTypeList);
        return map;
    }

    @RequestMapping("delRoomType")
    @ResponseBody
    public HashMap<String,Object> delRoomType(String name)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryDelRoomType:NAME:"+name);
        boolean isSuccess= roomTypeService.deleteRoomType(name)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("addRoomType")
    @ResponseBody
    public HashMap<String,Object> addRoomType(RoomType roomType)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryAddRoomType:"+roomType);
        boolean isSuccess=roomTypeService.insertRoomType(roomType)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("searchRoomType")
    @ResponseBody
    public HashMap<String,Object> searchRoomType(String name)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<RoomType> roomTypeList= roomTypeService.selectRoomType(name);
        map.put("List",roomTypeList);
        return map;
    }

    @RequestMapping("editRoomType")
    @ResponseBody
        public HashMap<String,Object> editRoomType(RoomType roomType)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryUpdateRoomType:"+roomType);
        boolean isSuccess=roomTypeService.updateRoomType(roomType)>0;
        map.put("handle",isSuccess);
        return map;
    }
}
