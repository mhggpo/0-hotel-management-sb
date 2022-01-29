package com.zero.hotelmanagement.service;

import com.zero.hotelmanagement.dao.FloorDao;
import com.zero.hotelmanagement.pojo.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FloorServiceImpl implements FloorService{
    private final FloorDao floorDao;

    @Autowired(required = false)
    public FloorServiceImpl(FloorDao floorDao){
        this.floorDao=floorDao;
    }

    @Override
    public int insertFloor(Floor floor) {
        return floorDao.insertFloor(floor);
    }

    @Override
    public int deleteFloor(String name) {
        return floorDao.deleteFloor(name);
    }

    @Override
    public int updateFloor(String name,Floor floor) {
        return floorDao.updateFloor(name,floor);
    }

    @Override
    public List<Floor> selectFloor(String name) {
        return floorDao.selectFloor(name);
    }

    @Override
    public List<Floor> getFloor(int page) {
        return floorDao.getFloor(6*(page-1));
    }

    @Override
    public int countAllFloors() {
        return floorDao.countAllFloors();
    }
}
