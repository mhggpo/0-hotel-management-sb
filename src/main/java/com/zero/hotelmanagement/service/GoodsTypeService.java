package com.zero.hotelmanagement.service;

import com.zero.hotelmanagement.pojo.GoodsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsTypeService {
    /**
     * 增加商品类型
     * @param goodsType 商品类型对象
     * @return 0表明增加失败
     */
    int insertGoodsType(GoodsType goodsType);

    /**
     * 删除商品类型
     * @param goodsTypeId 商品类型id
     * @return 0表明删除失败
     */
    int deleteGoodsType(@Param("goodsTypeId") Integer goodsTypeId);

    /**
     * 修改商品类型
     * @param goodsType 商品类型
     * @return 0表明修改失败
     */
    int updateGoodsType(GoodsType goodsType);

    /**
     * 查询所有商品类型
     * @return 一个带有所有商品类型的List
     */
    List<GoodsType> selectAllGoodsType();

    /**
     * 通过商品name查询商品类型
     * @param name 商品类型name
     * @return 返回查询到的商品列表
     */
    List<GoodsType> selectGoodsTypeByName(@Param("name") String name);

    /**
     * 通过商品类型id查询商品类型
     * @param id 商品类型id
     * @return 查询到的商品类型
     */
    List<GoodsType> selectGoodsTypeById(@Param("id") Integer id);

    /**
     * 分页查询商品类型
     * @param page 页数
     * @return 该页商品
     */
    List<GoodsType> getGoodsType(Integer page);

    /**
     * 获取货物类型总数
     * @return 货物类型数量
     */
    int countAllGoodsTypes();
}
