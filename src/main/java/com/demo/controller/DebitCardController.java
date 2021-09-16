package com.demo.controller;

import com.demo.domains.Card;
import com.demo.domains.DebitCard;
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
@Slf4j
@RestController
@RequestMapping("api/debitCard")
public class DebitCardController {
    @Autowired
    private DebitCardService debitCardService;

    @PostMapping("getDebitCard")
    public CommunicationData getDebitCard(@RequestBody DebitCard pojo) {
        try {
            List<DebitCard> select = debitCardService.select(pojo);
            return CommunicationData.SUCCESS().data(select);
        }catch (Exception e) {
            log.error("DebitCardController#getDebitCard error");
        }
        return CommunicationData.FAIL("查询失败");
    }

    @PutMapping("addDebitCard")
    public CommunicationData addDebitCard(@RequestBody DebitCard debitCard) {
        // TODO 此处的方法应该在sql执行之后
        debitCard.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        debitCard.setModifyTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        try {
            int insert = debitCardService.insert(debitCard);
            if (insert > 0) {
                return CommunicationData.SUCCESS();
            }
        }catch (Exception e) {
            log.error("DebitCardController#addDebitCard error");
        }
        return CommunicationData.FAIL("插入失败");
    }


    @PostMapping("updateDebitCard")
    public CommunicationData updateDebitCard(@RequestBody DebitCard debitCard) {
        // TODO 此处的方法应该在sql执行之后
        debitCard.setModifyTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        try {
            DebitCard temp = new DebitCard();
            temp.setId(debitCard.getId());
            List<DebitCard> select = debitCardService.select(temp);
            if (select.size() == 1) {
                int update = debitCardService.update(debitCard);
                if (update > 0) {
                    return CommunicationData.SUCCESS();
                }
            }
        }catch (Exception e) {
            log.error("DebitCardController#updateDebitCard error");
        }
        return CommunicationData.FAIL("更新失败");
    }

}