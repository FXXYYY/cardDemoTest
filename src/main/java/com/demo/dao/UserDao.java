package com.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.demo.domains.User;
import org.springframework.stereotype.Repository;

/**
 * @author fxy
 */
@Mapper
@Repository
public interface UserDao {

    /**
     * 新增
     * @param pojo
     * @return
     */
    int insert(@Param("pojo") User pojo);

    /**
     * 新增多个
     * @param pojo
     * @return
     */
    int insertList(@Param("pojos") List< User> pojo);

    /**
     * 查询
     * @param pojo
     * @return
     */
    List<User> select(@Param("pojo") User pojo);

    /**
     * 修改
     * @param pojo
     * @return
     */
    int update(@Param("pojo") User pojo);

}
