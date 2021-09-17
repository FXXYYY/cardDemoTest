package com.demo.service.impl;

import com.demo.dao.TariffPackageDao;
import com.demo.domains.DebitCard;
import com.demo.domains.TariffPackage;
import com.demo.service.TariffPackageService;
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
public class TariffPackageServiceImpl implements TariffPackageService {

    @Autowired
    private TariffPackageDao tariffPackageDao;

    @Override
    public int insert(TariffPackage pojo){
        return tariffPackageDao.insert(pojo);
    }

    @Override
    public int insertList(List< TariffPackage> pojos){
        return tariffPackageDao.insertList(pojos);
    }

    @Override
    public List<TariffPackage> select(TariffPackage pojo){
        return tariffPackageDao.select(pojo);
    }

    @Override
    public int update(TariffPackage pojo){
        return tariffPackageDao.update(pojo);
    }

    @Override
    public CommunicationData selectTariffPackage(TariffPackage tariffPackage) {
        try {
            List<TariffPackage> select = tariffPackageDao.select(tariffPackage);
            return CommunicationData.SUCCESS().data(select);
        }catch (Exception e) {
            log.error("TariffPackageServiceImpl#selectTariffPackage error");
        }
        return CommunicationData.FAIL("查询失败");
    }

    @Override
    public CommunicationData addTariffPackage(TariffPackage tariffPackage) {
        // TODO 此处的方法应该在sql执行之后
        tariffPackage.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        tariffPackage.setModifyTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        try {
            int insert = tariffPackageDao.insert(tariffPackage);
            if (insert > 0) {
                return CommunicationData.SUCCESS();
            }
        }catch (Exception e) {
            log.error("TariffPackageServiceImpl#addTariffPackage error");
        }
        return CommunicationData.FAIL("插入失败");
    }

    @Override
    public CommunicationData updateTariffPackage(TariffPackage tariffPackage) {
        // TODO 此处的方法应该在sql执行之后
        tariffPackage.setModifyTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        try {
            TariffPackage temp = new TariffPackage();
            temp.setId(tariffPackage.getId());
            List<TariffPackage> select = tariffPackageDao.select(temp);
            if (select.size() == 1) {
                int update = tariffPackageDao.update(tariffPackage);
                if (update > 0) {
                    return CommunicationData.SUCCESS();
                }
            }
        }catch (Exception e) {
            log.error("TariffPackageServiceImpl#updateTariffPackage error");
        }
        return CommunicationData.FAIL("更新失败");
    }

}
