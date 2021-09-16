package com.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.demo.domains.Card;
import org.springframework.stereotype.Repository;

/**
 * @author fxy
 */
@Mapper
@Repository
public interface CardDao {

    /**
     * 添加
     * @param pojo 卡
     * @return 影响行数
     */
    int insert(@Param("pojo") Card pojo);

    /**
     * 批量添加
     * @param pojo 卡
     * @return 影响行数
     */
    int insertList(@Param("pojos") List< Card> pojo);

    /**
     * 查询一个
     * @param pojo 卡
     * @return 列表
     */
    List<Card> select(@Param("pojo") Card pojo);

    /**
     * 更新
     * @param pojo 卡
     * @return 影响行数
     */
    int update(@Param("pojo") Card pojo);

}
