package com.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.demo.dao.CardDao;
import com.demo.dao.UserDao;
import com.demo.domains.Card;
import com.demo.domains.User;
import com.demo.domains.User;
import com.demo.service.UserService;
import com.demo.util.CommunicationData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author fxy
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CardDao cardDao;

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

    @Override
    public CommunicationData selectUser(User pojo) {
        try {
            List<User> select = userDao.select(pojo);
            return CommunicationData.SUCCESS().data(select);
        }catch (Exception e) {
            log.error("UserServiceImpl#selectUser error");
        }
        return CommunicationData.FAIL("查询失败");
    }

    @Override
    public CommunicationData addUser(User user) {
        try {
            int insert = userDao.insert(user);
            if (insert > 0) {
                return CommunicationData.SUCCESS();
            }
        }catch (Exception e) {
            log.error("UserServiceImpl#addUser error");
        }
        return CommunicationData.FAIL("插入失败");
    }

    @Override
    public CommunicationData updateUser(User user) {
        try {
            User temp = new User();
            temp.setId(user.getId());
            List<User> select = userDao.select(temp);
            if (select.size() == 1) {
                int update = userDao.update(user);
                if (update > 0) {
                    return CommunicationData.SUCCESS();
                }
            }
        }catch (Exception e) {
            log.error("UserServiceImpl#updateUser error");
        }
        return CommunicationData.FAIL("更新失败");
    }



}
