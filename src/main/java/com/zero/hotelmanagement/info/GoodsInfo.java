package com.zero.hotelmanagement.info;

import com.zero.hotelmanagement.pojo.Goods;
import com.zero.hotelmanagement.pojo.GoodsType;
import com.zero.hotelmanagement.service.GoodsTypeService;
import lombok.Data;

import java.util.List;

@Data
public class GoodsInfo {
    private Goods goods;
    private List<GoodsType> goodsTypeList;

    public GoodsInfo(Goods goods, GoodsTypeService goodsTypeService)
    {
        this.goods=goods;
        goodsTypeList=goodsTypeService.selectGoodsTypeById(goods.getTypeid());
    }
}
