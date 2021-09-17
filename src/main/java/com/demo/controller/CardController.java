package com.demo.controller;

import com.demo.domains.Card;
import com.demo.service.CardService;
import com.alibaba.fastjson.JSONObject;
import com.demo.util.CommunicationData;
import com.sun.xml.internal.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/12 14:48
 * @description TODO
 */
@Slf4j
@RestController
@RequestMapping("api/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("getCardMsg")
    public CommunicationData getCardMsg(@RequestBody Card card) {
        return cardService.selectCard(card);
    }

    @PutMapping("addCard")
    public CommunicationData addCard(@RequestBody Card card) {
        return cardService.insertCard(card);
    }


    @PostMapping("updateCard")
    public CommunicationData updateCard(@RequestBody Card card) {
        return cardService.updateCard(card);
    }


}
