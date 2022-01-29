package com.zero.hotelmanagement.service;

import com.zero.hotelmanagement.dao.MemberDao;
import com.zero.hotelmanagement.dao.ReserveDao;
import com.zero.hotelmanagement.dao.RoomRegisterDao;
import com.zero.hotelmanagement.pojo.Member;
import com.zero.hotelmanagement.pojo.Reserve;
import com.zero.hotelmanagement.pojo.RoomRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class ReserveServiceImpl implements ReserveService{
    private final ReserveDao reserveDao;
    private final RoomRegisterDao roomRegisterDao;
    private final MemberDao memberDao;

    @Autowired(required = false)
    public ReserveServiceImpl(ReserveDao reserveDao,RoomRegisterDao roomRegisterDao,MemberDao memberDao){
        this.reserveDao=reserveDao;
        this.roomRegisterDao=roomRegisterDao;
        this.memberDao=memberDao;
    }

    @Override
    public int insertReserve(Reserve reserve) {
        RoomRegister tempReg=roomRegisterDao.selectRoomRegisterById(reserve.getRoomRegister()).get(0);
        if(tempReg.getMemberId()!=null)
        {
            Member tempMember=memberDao.selectMemberById(tempReg.getMemberId()).get(0);
            tempMember.setLastRe(new Timestamp(System.currentTimeMillis()));
            memberDao.updateMember(tempMember);
        }
        return reserveDao.insertReserve(reserve);
    }

    @Override
    public int deleteReserve(Integer reserveId) {
        return reserveDao.deleteReserve(reserveId);
    }

    @Override
    public int UpdateReserve(Integer id) {
        return reserveDao.UpdateReserve(id);
    }

    @Override
    public List<Reserve> selectReserveById(Integer reserveId) {
        return reserveDao.selectReserveById(reserveId);
    }

    @Override
    public List<Reserve> selectReserveByType(String roomType) {
        return reserveDao.selectReserveByType(roomType);
    }

    @Override
    public List<Reserve> selectReserveByFloor(String floor) {
        return reserveDao.selectReserveByFloor(floor);
    }

    @Override
    public List<Reserve> selectReserveByStatus(String reserveStatus) {
        return reserveDao.selectReserveByStatus(reserveStatus);
    }

    @Override
    public List<Reserve> selectReserveByName(String reserveGuestName) {
        return reserveDao.selectReserveByName(reserveGuestName);
    }

    @Override
    public List<Reserve> getReserve(int page) {
        return reserveDao.getReserve(6*(page-1));
    }

    @Override
    public int countAllReserves() {
        return reserveDao.countAllReserves();
    }

    @Override
    public List<Reserve> selectReserveByRoomId(Integer roomId) {
        return reserveDao.selectReserveByRoomId(roomId);
    }
}
