package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.domains.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fxy
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int insert(User pojo){
        return userDao.insert(pojo);
    }

    @Override
    public int insertList(List< User> pojos){
        return userDao.insertList(pojos);
    }

    @Override
    public List<User> select(User pojo){
        return userDao.select(pojo);
    }

    @Override
    public int update(User pojo){
        return userDao.update(pojo);
    }

}
