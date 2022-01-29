package com.zero.hotelmanagement.service;

import com.zero.hotelmanagement.pojo.Reserve;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReserveService {
    //查询客房信息请调用RoomDao接口
    /**
     * 增加预定
     * @param reserve 预定对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int insertReserve(Reserve reserve);

    /**
     * 取消预定，已入住不能删除
     * @param reserveId 预定id
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int deleteReserve(@Param("reserveId")Integer reserveId);

    /**
     * 修改预定，已入住不能修改
     * @param id 预定编号
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int UpdateReserve(@Param("id")Integer id);

    /**
     *通过预定单号查询预定
     * @param reserveId 预定id
     * @return 返回查询到的预定列表
     */
    List<Reserve> selectReserveById(@Param("reserveId")Integer reserveId);

    /**
     *通过客房类型查询预定
     * @param roomType 客房类型
     * @return 返回查询到的预定列表
     */
    List<Reserve> selectReserveByType(@Param("roomType") String roomType);


    /**
     *通过客房楼层查询预定
     * @param  floor 客房楼层
     * @return 返回查询到的预定列表
     */
    List<Reserve> selectReserveByFloor(@Param("floor")String floor);

    /**
     *通过预定状态查询预定
     * @param reserveStatus 预定状态
     * @return 返回查询到的预定列表
     */
    List<Reserve> selectReserveByStatus(@Param("reserveStatus")String reserveStatus);

    /**
     *通过预定人查询预定
     * @param reserveGuestName 预定人姓名
     * @return 返回查询到的预定列表
     */
    List<Reserve> selectReserveByName(@Param("reserveGuestName")String reserveGuestName);

    /**
     * 分页查询所有预定信息
     * @param page 偏移数，一页显示六个
     * @return 分页查询预定列表
     */
    List<Reserve> getReserve(@Param("page") int page);

    /**
     * 计算预定总数
     * @return 预定总数
     */
    int countAllReserves();

    /**
     * 通过房间编号查询预定信息
     * @param roomId 房间编号
     * @return 查询到的预定信息列表
     */
    List<Reserve> selectReserveByRoomId(@Param("roomId") Integer roomId);
}
