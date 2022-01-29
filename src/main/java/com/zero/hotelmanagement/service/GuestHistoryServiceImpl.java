package com.zero.hotelmanagement.service;

import com.zero.hotelmanagement.dao.GuestHistoryDao;
import com.zero.hotelmanagement.pojo.GuestHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuestHistoryServiceImpl implements GuestHistoryService{
    private final GuestHistoryDao guestHistoryDao;

    @Autowired(required = false)
    public GuestHistoryServiceImpl(GuestHistoryDao guestHistoryDao)
    {
        this.guestHistoryDao=guestHistoryDao;
    }

    @Override
    public List<GuestHistory> selectGuestHistory(int page) {
        return guestHistoryDao.selectGuestHistory(6*(page-1));
    }

    @Override
    public int insertGuestHistory(GuestHistory guestHistory) {
        return guestHistoryDao.insertGuestHistory(guestHistory);
    }
}
