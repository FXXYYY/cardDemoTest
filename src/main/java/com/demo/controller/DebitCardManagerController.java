package com.demo.controller;

import com.demo.domains.User;
import com.demo.service.DebitCardManagerService;
import com.demo.service.DebitCardService;
import com.demo.util.CommunicationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/17 23:30
 * @description TODO
 */
public class DebitCardManagerController {

    @Autowired
    private DebitCardManagerService debitCardManagerService;

    @PostMapping("openCard")
    public CommunicationData openCard(@RequestBody User user, Long cardNo, Long tariffPackageId) {
        return debitCardManagerService.openCard(user, cardNo, tariffPackageId);
    }
}