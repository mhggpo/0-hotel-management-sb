package com.zero.hotelmanagement.service;

import com.zero.hotelmanagement.pojo.Goods;
import com.zero.hotelmanagement.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService{

    private final GoodsDao goodsDao;

    @Autowired(required = false)
    public GoodsServiceImpl(GoodsDao goodsDao){
        this.goodsDao=goodsDao;
    }

    @Override
    public int insertGoods(Goods goods) {
        return goodsDao.insertGoods(goods);
    }

    @Override
    public int deleteGoods(Integer id) {
        return goodsDao.deleteGoods(id);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }

    @Override
    public List<Goods> selectGoodsById(Integer id) {
        return goodsDao.selectGoodsById(id);
    }

    @Override
    public List<Goods> selectGoodsByType(String type) {
        return goodsDao.selectGoodsByType(type);
    }

    @Override
    public List<Goods> getGoods(int page) {
        return goodsDao.getGoods(6*(page-1));
    }


    @Override
    public int countAllGoods() {
        return goodsDao.countAllGoods();
    }
}
