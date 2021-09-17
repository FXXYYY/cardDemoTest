package com.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.demo.domains.TariffPackage;
import org.springframework.stereotype.Repository;

/**
 * @author fxy
 */
@Mapper
@Repository
public interface TariffPackageDao {

    /**
     * 新增
     * @param pojo
     * @return
     */
    int insert(@Param("pojo") TariffPackage pojo);

    /**
     * 新增多个
     * @param pojo
     * @return
     */
    int insertList(@Param("pojos") List< TariffPackage> pojo);

    /**
     * 查询
     * @param pojo
     * @return
     */
    List<TariffPackage> select(@Param("pojo") TariffPackage pojo);

    /**
     * 查询
     * @param id
     * @return
     */
    TariffPackage selectById(Long id);

    /**
     * 修改
     * @param pojo
     * @return
     */
    int update(@Param("pojo") TariffPackage pojo);

}
