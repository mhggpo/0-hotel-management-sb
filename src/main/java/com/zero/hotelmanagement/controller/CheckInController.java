package com.zero.hotelmanagement.controller;

import com.zero.hotelmanagement.info.CheckInInfo;
import com.zero.hotelmanagement.pojo.CheckIn;
import com.zero.hotelmanagement.service.CheckInService;
import com.zero.hotelmanagement.service.RoomRegisterService;
import com.zero.hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RestController
@CrossOrigin
public class CheckInController {
    private final CheckInService checkInService;
    private final RoomRegisterService roomRegisterService;
    private final RoomService roomService;

    @Autowired
    public CheckInController(CheckInService checkInService,RoomRegisterService roomRegisterService,RoomService roomService)
    {
        this.checkInService=checkInService;
        this.roomRegisterService=roomRegisterService;
        this.roomService=roomService;
    }

    @RequestMapping("addCheckIn")
    @ResponseBody
    public HashMap<String,Object> addCheckIn(CheckIn checkInInfo)
    {
        boolean handle=checkInService.insertCheckIn(checkInInfo)>0;
        HashMap<String,Object> map=new HashMap<>();
        map.put("handle",handle);
        return map;
    }

    @RequestMapping("changeRoom")
    @ResponseBody
    public HashMap<String,Object> changeRoom(String checkInId,String roomId)
    {
        HashMap<String,Object> map=new HashMap<>();
        boolean handle=checkInService.changeRoom(Integer.parseInt(checkInId),Integer.parseInt(roomId))>0;
        map.put("handle",handle);
        return map;
    }

//    @RequestMapping("getCheckInByRoomRegister")
//    @ResponseBody
//    public HashMap<String,Object> getCheckInByRoomRegister(String id)
//    {
//        HashMap<String,Object> map=new HashMap<>();
//        List<CheckIn> checkInList=checkInService.selectCheckInByRoomRegister(Integer.parseInt(id));
//        map.put("List",checkInList);
//        return map;
//    }

    @RequestMapping("getCheckIn")
    @ResponseBody
    public HashMap<String,Object> getCheckIn(String page)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<CheckInInfo> checkInInfoList=new ArrayList<>();
        List<CheckIn> checkInList=checkInService.getCheckIn(Integer.parseInt(page));
        for(CheckIn c:checkInList)
            checkInInfoList.add(new CheckInInfo(c,roomRegisterService,roomService));
        map.put("count",checkInService.countAllCheckIn());
        map.put("List",checkInInfoList);
        return map;
    }

    @RequestMapping("delCheckIn")
    @ResponseBody
    public HashMap<String,Object> delCheckIn(String checkInId,String roomId)
    {
        boolean handle=checkInService.delCheckIn(Integer.parseInt(checkInId),Integer.parseInt(roomId))>0;
        HashMap<String,Object> map=new HashMap<>();
        map.put("handle",handle);
        return map;
    }

    @RequestMapping("selectCheckInById")
    @ResponseBody
    public HashMap<String,Object> selectCheckInById(String id)
    {
        if(id==null||id.equals(""))
            return getCheckIn("1");
        else {
            HashMap<String, Object> map = new HashMap<>();
            List<CheckInInfo> checkInInfoList = new ArrayList<>();
            List<CheckIn> checkInList = checkInService.selectCheckInById(Integer.parseInt(id));
            for (CheckIn c : checkInList)
                checkInInfoList.add(new CheckInInfo(c, roomRegisterService, roomService));
            map.put("List", checkInInfoList);
            return map;
        }
    }

    @RequestMapping("selectCheckInByRoomType")
    @ResponseBody
    public HashMap<String,Object> selectCheckInByRoomType(String type)
    {
        if(type==null||type.equals(""))
            return getCheckIn("1");
        else {
            HashMap<String, Object> map = new HashMap<>();
            List<CheckInInfo> checkInInfoList = new ArrayList<>();
            List<CheckIn> checkInList = checkInService.selectCheckInByRoomType(type);
            for (CheckIn c : checkInList)
                checkInInfoList.add(new CheckInInfo(c, roomRegisterService, roomService));
            map.put("List", checkInInfoList);
            return map;
        }
    }

    @RequestMapping("selectCheckInByRoomId")
    @ResponseBody
    public HashMap<String,Object> selectCheckInByRoomId(String id)
    {
        if(id==null||id.equals(""))
            return getCheckIn("1");
        else {
            HashMap<String, Object> map = new HashMap<>();
            List<CheckInInfo> checkInInfoList = new ArrayList<>();
            List<CheckIn> checkInList = checkInService.selectCheckInByRoomId(Integer.parseInt(id));
            for (CheckIn c : checkInList)
                checkInInfoList.add(new CheckInInfo(c, roomRegisterService, roomService));
            map.put("List", checkInInfoList);
            return map;
        }
    }

    @RequestMapping("selectCheckInByGuestId")
    @ResponseBody
    public HashMap<String,Object> selectCheckInByGuestId(String id)
    {
        if(id==null||id.equals(""))
            return getCheckIn("1");
        else {
            HashMap<String, Object> map = new HashMap<>();
            List<CheckInInfo> checkInInfoList = new ArrayList<>();
            List<CheckIn> checkInList = checkInService.selectCheckInByGuestId(Integer.parseInt(id));
            for (CheckIn c : checkInList)
                checkInInfoList.add(new CheckInInfo(c, roomRegisterService, roomService));
            map.put("List", checkInInfoList);
            return map;
        }
    }
}
