package com.zero.hotelmanagement.controller;
import com.zero.hotelmanagement.pojo.Floor;
import com.zero.hotelmanagement.service.FloorService;
import org.apache.ibatis.annotations.Param;
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
public class FloorController {
    private final FloorService floorService;

    @Autowired
    public FloorController(FloorService floorService){
        this.floorService=floorService;
    }

    @RequestMapping("getFloor")
    @ResponseBody
    public HashMap<String,Object> getFloor(String page)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<Floor> floorList= floorService.getFloor(Integer.parseInt(page));
        int count=floorService.countAllFloors();
        map.put("count",count);
        map.put("List",floorList);
        return map;
    }

    @RequestMapping("delFloor")
    @ResponseBody
    public HashMap<String,Object> delFloor(String name)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryDelFloor:NAME:"+name);
        boolean isSuccess= floorService.deleteFloor(name)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("addFloor")
    @ResponseBody
    public HashMap<String,Object> addFloor(Floor floor)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryAddFloor:"+floor);
        boolean isSuccess=floorService.insertFloor(floor)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("searchFloor")
    @ResponseBody
    public HashMap<String,Object> searchFloor(String name)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<Floor> floorList= floorService.selectFloor(name);
        map.put("List",floorList);
        return map;
    }

    @RequestMapping("editFloor")
    @ResponseBody
    public HashMap<String,Object> editFloor(@Param("target") String target,@Param("floor") Floor floor)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryUpdateFloor:"+target);
        boolean isSuccess=floorService.updateFloor(target,floor)>0;
        map.put("handle",isSuccess);
        return map;
    }
}
