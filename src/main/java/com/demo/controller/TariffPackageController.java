package com.demo.controller;

import com.demo.domains.TariffPackage;
import com.demo.service.TariffPackageService;
import com.demo.service.TariffPackageService;
import com.demo.util.CommunicationData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/12 14:48
 * @description TODO
 */
@Slf4j
@RestController
@RequestMapping("api/tariffPackage")
public class TariffPackageController {

    @Autowired
    private TariffPackageService tariffPackageService;

    @PostMapping("getTariffPackage")
    public CommunicationData getTariffPackage(@RequestBody TariffPackage pojo) {
        return tariffPackageService.selectTariffPackage(pojo);
    }

    @PutMapping("addTariffPackage")
    public CommunicationData addTariffPackage(@RequestBody TariffPackage debitCard) {
        return tariffPackageService.addTariffPackage(debitCard);
    }


    @PostMapping("updateTariffPackage")
    public CommunicationData updateTariffPackage(@RequestBody TariffPackage debitCard) {
        return tariffPackageService.updateTariffPackage(debitCard);
    }
}