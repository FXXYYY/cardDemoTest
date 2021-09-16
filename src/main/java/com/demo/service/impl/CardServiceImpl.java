package com.demo.service.impl;

import com.demo.dao.CardDao;
import com.demo.domains.Card;
import com.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fxy
 */
@Service
@Repository
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDao cardDao;

    @Override
    public int insert(Card pojo){
        return cardDao.insert(pojo);
    }

    @Override
    public int insertList(List< Card> pojos){
        return cardDao.insertList(pojos);
    }

    @Override
    public List<Card> select(Card pojo){
        return cardDao.select(pojo);
    }

    @Override
    public int update(Card pojo){
        return cardDao.update(pojo);
    }

}
