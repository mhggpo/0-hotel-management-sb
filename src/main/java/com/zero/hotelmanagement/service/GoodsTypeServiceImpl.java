package com.zero.hotelmanagement.service;

import com.zero.hotelmanagement.dao.GoodsTypeDao;
import com.zero.hotelmanagement.pojo.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsTypeServiceImpl implements GoodsTypeService{

    private final GoodsTypeDao goodsTypeDao;

    @Autowired(required = false)
    public GoodsTypeServiceImpl(GoodsTypeDao goodsTypeDao) {
        this.goodsTypeDao = goodsTypeDao;
    }

    @Override
    public int insertGoodsType(GoodsType goodsType) {
        return goodsTypeDao.insertGoodsType(goodsType);
    }

    @Override
    public int deleteGoodsType(Integer goodsTypeId) {
        return goodsTypeDao.deleteGoodsType(goodsTypeId);
    }

    @Override
    public int updateGoodsType(GoodsType goodsType) {
        return goodsTypeDao.updateGoodsType(goodsType);
    }

    @Override
    public List<GoodsType> selectGoodsTypeByName(String name) {
        return goodsTypeDao.selectGoodsTypeByName(name);
    }

    @Override
    public List<GoodsType> selectGoodsTypeById(Integer id) {
        return goodsTypeDao.selectGoodsTypeById(id);
    }

    @Override
    public List<GoodsType> selectAllGoodsType() {
        return goodsTypeDao.selectAllGoodsType();
    }

    @Override
    public List<GoodsType> getGoodsType(Integer page) {
        return goodsTypeDao.getGoodsType(6*(page-1));
    }

    @Override
    public int countAllGoodsTypes() {
        return goodsTypeDao.countAllGoodsTypes();
    }
}
