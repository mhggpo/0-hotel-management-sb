package com.zero.hotelmanagement.dao;

import com.zero.hotelmanagement.pojo.Cost;
import com.zero.hotelmanagement.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CostDao {
    /**
     * 通过商品id查询商品
     *
     * @param goodsId 商品id
     * @return 返回查询到的商品列表
     */
    List<Goods> selectGoodsById(@Param("goodsId") Integer goodsId);

    /**
     * 根据类别名查询商品
     *
     * @param goodsTypeName 商品类别名
     * @return 返回查询到的商品列表
     */
    List<Goods> selectGoodsByName(@Param("goodsTypeName") String goodsTypeName);

    /**
     * 消费入账
     *
     * @param cost 该笔消费
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int insertCost(Cost cost);

    /**
     * 修改消费信息
     *
     * @param cost 消费对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int updateCost(Cost cost);

    /**
     * 删除消费信息
     *
     * @param costId 消费id
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int deleteCost(@Param("costId") Integer costId);

    /**
     * 通过客房编号查询消费信息
     *
     * @param roomId 客房编号
     * @return 返回查询到的消费信息列表
     */
    List<Cost> selectCostByRoomId(@Param("roomId") Integer roomId);
//
//    /**
//     * 打印消费单
//     *
//     * @param cost 要打印的cost
//     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
//     */
//    int printCost(Cost cost);
}
