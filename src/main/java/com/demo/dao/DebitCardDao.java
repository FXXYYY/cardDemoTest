package com.demo.dao;

import com.demo.domains.Card;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.demo.domains.DebitCard;
import org.springframework.stereotype.Repository;

/**
 * @author fxy
 */
@Mapper
@Repository
public interface DebitCardDao {

    /**新增
     * @param pojo
     * @return
     */
    int insert(@Param("pojo") DebitCard pojo);

    /**
     * 新增多个
     * @param pojo
     * @return
     */
    int insertList(@Param("pojos") List< DebitCard> pojo);

    /**
     * 查询
     * @param pojo
     * @return
     */
    List<DebitCard> select(@Param("pojo") DebitCard pojo);

    /**
     * 修改
     * @param pojo
     * @return
     */
    int update(@Param("pojo") DebitCard pojo);

    /**
     * 查询
     * @param id
     * @return
     */
    DebitCard selectById(Long id);

    /**
     * 添加并返回id
     * @param pojo
     * @return id
     */
    Long insertReturnId(@Param("pojo") DebitCard pojo);


}
