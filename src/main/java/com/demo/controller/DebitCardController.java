package com.demo.controller;

import com.demo.domains.Card;
import com.demo.domains.DebitCard;
import com.demo.domains.User;
import com.demo.service.CardService;
import com.demo.service.DebitCardService;
import com.demo.util.CommunicationData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/12 14:47
 * @description TODO
 */
@RestController
@RequestMapping("api/debitCard")
public class DebitCardController {
    @Autowired
    private DebitCardService debitCardService;

    @PostMapping("getDebitCard")
    public CommunicationData getDebitCard(@RequestBody DebitCard pojo) {
        return debitCardService.selectDebitCard(pojo);
    }

    @PutMapping("addDebitCard")
    public CommunicationData addDebitCard(@RequestBody DebitCard debitCard) {
        return debitCardService.addDebitCard(debitCard);
    }


    @PostMapping("updateDebitCard")
    public CommunicationData updateDebitCard(@RequestBody DebitCard debitCard) {
        return debitCardService.updateDebitCard(debitCard);
    }


}