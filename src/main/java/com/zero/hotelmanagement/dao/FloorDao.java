package com.zero.hotelmanagement.dao;

import com.zero.hotelmanagement.pojo.Floor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FloorDao {
    /**
     *增加楼层
     * @param floor 楼层对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int insertFloor(Floor floor);

    /**
     *删除楼层
     * @param name 楼层名
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int deleteFloor(@Param("name")String name);

    /**
     *修改楼层
     * @param target 楼层名
     * @param floor 修改之后的楼层信息
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int updateFloor(@Param("target") String target,@Param("floor") Floor floor);

    /**
     * 查寻楼层
     * @param name 楼层名
     * @return 返回查询到的楼层列表
     */
    List<Floor> selectFloor(@Param("name") String name);

    /**
     * 分页查询所有楼层信息
     * @param page 页数，一页显示六个
     * @return 分页查询楼层列表
     */
    List<Floor> getFloor(@Param("page") int page);

    /**
     * 计算楼层总数
     * @return 楼层总数
     */
    int countAllFloors();
}
