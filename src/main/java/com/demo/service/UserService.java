package com.demo.service;

import com.demo.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.demo.dao.UserDao;

/**
 * @author fxy
 */
public interface UserService {


    /**
     * 插入
     * @param pojo
     * @return
     */
    public int insert(User pojo);

    /**
     * 插入
     * @param pojos
     * @return
     */
    public int insertList(List< User> pojos);

    /**
     * 查询
     * @param pojo
     * @return
     */
    public List<User> select(User pojo);

    /**
     * 更新
     * @param pojo
     * @return
     */
    public int update(User pojo);

}
