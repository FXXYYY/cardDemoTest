package com.demo.service.impl;

import com.demo.dao.TariffPackageDao;
import com.demo.domains.TariffPackage;
import com.demo.service.TariffPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fxy
 */
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

}
