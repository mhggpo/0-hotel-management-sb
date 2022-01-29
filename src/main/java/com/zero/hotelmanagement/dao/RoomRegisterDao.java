package com.zero.hotelmanagement.dao;

import com.zero.hotelmanagement.pojo.Reserve;
import com.zero.hotelmanagement.pojo.RoomRegister;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RoomRegisterDao {
    /**
     * 增加RoomRegister
     * @param roomRegister RoomRegister对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int insertRoomRegister(RoomRegister roomRegister);

    /**
     * 删除RoomRegister
     * @param roomRegisterId RoomRegister id
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int deleteRoomRegister(@Param("roomRegisterId")Integer roomRegisterId);

    /**
     * 修改RoomRegister
     * @param roomRegister RoomRegister对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int updateRoomRegister(RoomRegister roomRegister);

    /**
     *通过id查询RoomRegister
     * @param id RoomRegister的id
     * @return 返回查询到的RoomRegister列表
     */
    List<RoomRegister> selectRoomRegisterById(@Param("id")Integer id);

    /**
     *通过guestId查询RoomRegister
     * @param guestId RoomRegister的guestId
     * @return 返回查询到的RoomRegister列表
     */
    List<RoomRegister> selectRoomRegisterByGuestId(@Param("guestId")String guestId);

    /**
     * 获得下一个自增id
     * @return id
     */
    int selectNextAutoId();

}
