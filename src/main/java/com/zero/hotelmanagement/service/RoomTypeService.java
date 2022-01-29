package com.zero.hotelmanagement.service;

import com.zero.hotelmanagement.pojo.RoomType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomTypeService {
    /**
     * 增加客房类型
     * @param roomType 客房类型对象
     * @return 0表明增加失败
     */
    int insertRoomType(RoomType roomType);

    /**
     * 删除客房类型
     * @param roomTypeName 客房类型名字
     * @return 0表明删除失败
     */
    int deleteRoomType(@Param("roomTypeName") String roomTypeName);

    /**
     * 修改客房类型
     * @param roomType 客房类型对象
     * @return 0表明修改失败
     */
    int updateRoomType(RoomType roomType);

    /**
     * 查询所有客房类型
     * @return 一个带有所有房间类型的List
     */
    List<RoomType> selectAllRoomType();

    /**
     * 查寻客房类型
     * @param name 客房类型名
     * @return 返回查询到的客房类型列表
     */
    List<RoomType> selectRoomType(@Param("name") String name);

    /**
     * 分页查询所有客房类型信息
     * @param page 偏移数，一页显示六个
     * @return 分页查询客房信息列表
     */
    List<RoomType> getRoomType(@Param("page") int page);

    /**
     * 计算客房类型总数
     * @return 客房类型总数
     */
    int countAllRoomTypes();
}
