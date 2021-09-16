package com.demo.service.impl;

import com.demo.dao.DebitCardDao;
import com.demo.domains.DebitCard;
import com.demo.service.DebitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fxy
 */
@Service
public class DebitCardServiceImpl implements DebitCardService {

    @Autowired
    private DebitCardDao debitCardDao;

    @Override
    public int insert(DebitCard pojo){
        return debitCardDao.insert(pojo);
    }

    @Override
    public int insertList(List< DebitCard> pojos){
        return debitCardDao.insertList(pojos);
    }

    @Override
    public List<DebitCard> select(DebitCard pojo){
        return debitCardDao.select(pojo);
    }

    @Override
    public int update(DebitCard pojo){
        return debitCardDao.update(pojo);
    }

}
