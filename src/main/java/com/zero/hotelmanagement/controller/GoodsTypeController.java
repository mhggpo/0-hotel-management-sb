package com.zero.hotelmanagement.controller;

import com.zero.hotelmanagement.pojo.GoodsType;
import com.zero.hotelmanagement.service.GoodsTypeService;
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
public class GoodsTypeController {
    private final GoodsTypeService goodsTypeService;

    @Autowired
    public GoodsTypeController(GoodsTypeService goodsTypeService) {
        this.goodsTypeService = goodsTypeService;
    }

    @RequestMapping("getGoodsType")
    @ResponseBody
    public HashMap<String,Object> getGoodsType(String page)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<GoodsType> GoodsTypeList= goodsTypeService.getGoodsType(Integer.parseInt(page));
        int count=goodsTypeService.countAllGoodsTypes();
        map.put("count",count);
        map.put("List",GoodsTypeList);
        return map;
    }

    @RequestMapping("delGoodsType")
    @ResponseBody
    public HashMap<String,Object> delGoodsType(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryDelGoodsType:ID:"+id);
        boolean isSuccess= goodsTypeService.deleteGoodsType(Integer.parseInt(id))>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("addGoodsType")
    @ResponseBody
    public HashMap<String,Object> addGoodsType(GoodsType goods)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryAddGoodsType:"+goods);
        boolean isSuccess=goodsTypeService.insertGoodsType(goods)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("editGoodsType")
    @ResponseBody
    public HashMap<String,Object> editGoodsType(GoodsType goods)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryUpdateGoodsType:"+goods);
        boolean isSuccess=goodsTypeService.updateGoodsType(goods)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("searchGoodsType")
    @ResponseBody
    public HashMap<String,Object> searchGoodsType(String name)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<GoodsType> GoodsTypeList= goodsTypeService.selectGoodsTypeByName(name);
        map.put("List",GoodsTypeList);
        return map;
    }
}
