package com.zero.hotelmanagement.service;

import com.zero.hotelmanagement.pojo.GuestHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuestHistoryService {
    /**
     * 分页查询客人历史
     * @param page 页数
     * @return 查询到的历史
     */
    List<GuestHistory> selectGuestHistory(@Param("page") int page);

    /**
     * 插入客人历史
     * @param guestHistory 插入的客人历史
     * @return 插入影响数据库数据条数
     */
    int insertGuestHistory(@Param("guestHistory") GuestHistory guestHistory);
}
