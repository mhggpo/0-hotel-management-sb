package com.zero.hotelmanagement.controller;

import com.zero.hotelmanagement.pojo.Reserve;
import com.zero.hotelmanagement.service.ReserveService;
import com.zero.hotelmanagement.service.RoomRegisterService;
import com.zero.hotelmanagement.service.UserService;
import com.zero.hotelmanagement.info.ReserveInfo;
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
public class ReserveController {
    private final ReserveService reserveService;
    private final UserService userService;
    private final RoomRegisterService roomRegisterService;

    @Autowired
    public ReserveController(ReserveService reserveService,UserService userService,RoomRegisterService roomRegisterService){
        this.reserveService=reserveService;
        this.userService=userService;
        this.roomRegisterService=roomRegisterService;
    }

    @RequestMapping("addReserve")
    @ResponseBody
    public HashMap<String,Object> addReserve(Reserve reserve)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryAddReserve:"+reserve);
        boolean isSuccess=reserveService.insertReserve(reserve)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("getReserve")
    @ResponseBody
    public HashMap<String,Object> getReserve(String page)
    {
        HashMap<String,Object> map=new HashMap<>();
        map.put("count",reserveService.countAllReserves());
        List<ReserveInfo> list=new ArrayList<>();
        List<Reserve> reserveList=reserveService.getReserve(Integer.parseInt(page));
        for(Reserve r:reserveList){
            list.add(new ReserveInfo(r,roomRegisterService,userService));
        }
        map.put("List",list);
        return map;
    }

    @RequestMapping("delReserve")
    @ResponseBody
    public HashMap<String,Object> delReserve(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryDelReserve:ID:"+id);
        boolean isSuccess= reserveService.deleteReserve(Integer.parseInt(id))>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("getReserveById")
    @ResponseBody
    public HashMap<String,Object> getReserveById(String id)
    {
        if(id==null||id.equals(""))
            return getReserve("1");
        else {
            HashMap<String,Object> map=new HashMap<>();
            List<ReserveInfo> reserveInfoList=new ArrayList<>();
            List<Reserve> reserveList=reserveService.selectReserveById(Integer.parseInt(id));
            for(Reserve r:reserveList) {
                reserveInfoList.add(new ReserveInfo(r, roomRegisterService, userService));
            }
            map.put("List",reserveInfoList);
            return map;
        }
    }

    @RequestMapping("getReserveByRoomId")
    @ResponseBody
    public HashMap<String,Object> getReserveByRoomId(String roomId)
    {
        if(roomId==null||roomId.equals(""))
            return getReserve("1");
        else{
            HashMap<String,Object> map=new HashMap<>();
            List<ReserveInfo> reserveInfoList=new ArrayList<>();
            List<Reserve> reserveList=reserveService.selectReserveByRoomId(Integer.parseInt(roomId));
            for(Reserve r:reserveList) {
                reserveInfoList.add(new ReserveInfo(r, roomRegisterService, userService));
            }
            map.put("List",reserveInfoList);
            return map;
        }
    }

    @RequestMapping("getReserveByPersonName")
    @ResponseBody
    public HashMap<String,Object> getReserveByPersonName(String personName)
    {
        if(personName==null||personName.equals(""))
            return getReserve("1");
        else{
            HashMap<String,Object> map=new HashMap<>();
            List<ReserveInfo> reserveInfoList=new ArrayList<>();
            List<Reserve> reserveList=reserveService.selectReserveByName(personName);
            for(Reserve r:reserveList) {
                reserveInfoList.add(new ReserveInfo(r, roomRegisterService, userService));
            }
            map.put("List",reserveInfoList);
            return map;
        }
    }

    @RequestMapping("getReserveByStatus")
    @ResponseBody
    public HashMap<String,Object> getReserveByStatus(String status)
    {
        if(status==null||status.equals(""))
            return getReserve("1");
        else{
            HashMap<String,Object> map=new HashMap<>();
            List<ReserveInfo> reserveInfoList=new ArrayList<>();
            List<Reserve> reserveList=reserveService.selectReserveByStatus(status);
            for(Reserve r:reserveList) {
                reserveInfoList.add(new ReserveInfo(r, roomRegisterService, userService));
            }
            map.put("List",reserveInfoList);
            return map;
        }
    }
}
