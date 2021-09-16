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
    public CommunicationData getCardMsg(@RequestBody Card pojo) {
        try {
            List<Card> select = cardService.select(pojo);
            return CommunicationData.SUCCESS().data(select);
        }catch (Exception e) {
            log.error("CardController#getCardMsg error");
        }
        return CommunicationData.FAIL("查询失败");
    }

    @PutMapping("addCard")
    public CommunicationData addCard(@RequestBody Card card) {
        // TODO 此处的方法应该在sql执行之后
        card.setVersion(1);
        card.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        card.setModifyTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        try {
            int insert = cardService.insert(card);
            if (insert > 0) {
                return CommunicationData.SUCCESS();
            }
        }catch (Exception e) {
            log.error("CardController#addCard error");
        }
        return CommunicationData.FAIL("插入失败");
    }


    @PostMapping("updateCard")
    public CommunicationData updateCard(@RequestBody Card card) {
        // TODO 此处的方法应该在sql执行之后
        card.setModifyTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        try {
            Card tempCard = new Card();
            tempCard.setId(card.getId());
            List<Card> select = cardService.select(tempCard);
            if (select.size() == 1) {
                card.setVersion(select.get(0).getVersion()+1);
                int update = cardService.update(card);
                if (update > 0) {
                    return CommunicationData.SUCCESS();
                }
            }
        }catch (Exception e) {
            log.error("CardController#updateCard error");
        }
        return CommunicationData.FAIL("更新失败");
    }


}
