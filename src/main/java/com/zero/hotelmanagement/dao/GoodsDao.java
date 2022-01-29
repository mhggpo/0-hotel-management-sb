package com.zero.hotelmanagement.dao;

import com.zero.hotelmanagement.pojo.Goods;
import com.zero.hotelmanagement.pojo.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    /**
     * 增加商品
     * @param goods 商品对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
     int insertGoods(Goods goods);

    /**
     * 删除商品
     * @param id 商品id
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int deleteGoods(@Param("id") Integer id);

    /**
     * 修改商品
     * @param goods 商品对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int  updateGoods(Goods goods);

    /**
     * 通过商品类别id查询商品
     * @param id 商品类别id
     * @return 返回查询到的商品列表
     */
    List<Goods> selectGoodsById(@Param("id") Integer id);

    /**
     * 根据类别名查询商品
     * @param type 商品类别名
     * @return 返回查询到的商品列表
     */
    List<Goods> selectGoodsByType(@Param("type")String type);

    /**
     * 分页查询所有商品信息
     * @param page 偏移数，一页显示六个
     * @return 分页查询商品列表
     */
    List<Goods> getGoods(@Param("page") int page);

    /**
     * 计算用户总数
     * @return 用户总数
     */
    int countAllGoods();
}
