package com.demo.service;

import com.demo.domains.TariffPackage;
import com.demo.dao.TariffPackageDao;
import com.demo.util.CommunicationData;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author fxy
 */
public interface TariffPackageService {


    /**
     * 插入
     * @param pojo
     * @return
     */
    public int insert(TariffPackage pojo);

    /**
     * 插入
     * @param pojos
     * @return
     */
    public int insertList(List< TariffPackage> pojos);

    /**
     * 查询
     * @param pojo
     * @return
     */
    public List<TariffPackage> select(TariffPackage pojo);

    /**
     * 更新
     * @param pojo
     * @return
     */
    public int update(TariffPackage pojo);

    /**
     * 查询
     * @param pojo
     * @return
     */
    CommunicationData selectTariffPackage(TariffPackage pojo);

    /**
     * 新增
     * @param debitCard
     * @return
     */
    CommunicationData addTariffPackage(TariffPackage debitCard);

    /**
     * 修改
     * @param debitCard
     * @return
     */
    CommunicationData updateTariffPackage(TariffPackage debitCard);
}
