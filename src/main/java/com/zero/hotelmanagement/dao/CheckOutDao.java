package com.zero.hotelmanagement.dao;

import com.zero.hotelmanagement.pojo.CheckIn;
import com.zero.hotelmanagement.pojo.CheckOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckOutDao {
    /**
     * 根据登记入住信息查询结账信息
     * @param checkIn 登记入住信息
     * @return 退房结账信息列表
     */
    List<CheckOut> selectCheckOutByCheckIn(@Param("checkIn") Integer checkIn);

//    /**
//     * 打印账单
//     * @param checkOut 退房结账对象
//     * @return 返回操作条数
//     */
//    int printCheckOut(CheckOut checkOut);
}