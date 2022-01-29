package com.zero.hotelmanagement.controller;

import com.zero.hotelmanagement.pojo.RoomRegister;
import com.zero.hotelmanagement.service.RoomRegisterService;
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
public class RoomRegisterController {
    private final RoomRegisterService roomRegisterService;

    @Autowired
    public RoomRegisterController(RoomRegisterService roomRegisterService){
        this.roomRegisterService=roomRegisterService;
    }

    @RequestMapping("delRoomRegister")
    @ResponseBody
    public HashMap<String,Object> delRoomRegister(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryDelRoomRegister:ID:"+id);
        boolean isSuccess= roomRegisterService.deleteRoomRegister(Integer.parseInt(id))>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("addRoomRegister")
    @ResponseBody
    public HashMap<String,Object> addRoomRegister(RoomRegister roomRegister)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryAddRoomRegister:"+roomRegister);
        int nextId= roomRegisterService.selectNextAutoId();
        boolean isSuccess=roomRegisterService.insertRoomRegister(roomRegister)>0;
        map.put("handle",isSuccess);
        map.put("id",nextId);
        return map;
    }

    @RequestMapping("editRoomRegister")
    @ResponseBody
    public HashMap<String,Object> editRoomRegister(RoomRegister roomRegister)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryUpdateRoomRegister:"+roomRegister);
        boolean isSuccess=roomRegisterService.updateRoomRegister(roomRegister)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("searchRoomRegister")
    @ResponseBody
    public HashMap<String,Object> searchRoomRegister(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<RoomRegister> roomRegisterList= roomRegisterService.selectRoomRegisterById(Integer.parseInt(id));
        map.put("List",roomRegisterList);
        return map;
    }

    @RequestMapping("searchRoomRegisterByGuestId")
    @ResponseBody
    public HashMap<String,Object> selectRoomRegisterByGuestId(String guestId) {
        HashMap<String,Object> map=new HashMap<>();
        List<RoomRegister> roomRegisterList= roomRegisterService.selectRoomRegisterByGuestId(guestId);
        map.put("List",roomRegisterList);
        return map;
    }
}
