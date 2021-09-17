package com.demo.service.impl;

import com.demo.dao.CardDao;
import com.demo.domains.Card;
import com.demo.service.CardService;
import com.demo.util.CommunicationData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
@Repository
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDao cardDao;


    @Override
    public CommunicationData selectCard(Card pojo){
        try {
            List<Card> select = cardDao.select(pojo);
            return CommunicationData.SUCCESS().data(select);
        }catch (Exception e) {
            log.error("CardController#getCardMsg error");
        }
        return CommunicationData.FAIL("查询失败");
    }

    @Override
    public CommunicationData insertCard(Card card) {
        // TODO 此处的方法应该在sql执行之后
        card.setVersion(1);
        card.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        card.setModifyTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        try {
            int insert = cardDao.insert(card);
            if (insert > 0) {
                return CommunicationData.SUCCESS();
            }
        }catch (Exception e) {
            log.error("CardServiceImpl#insertCard error");
        }
        return CommunicationData.FAIL("插入失败");
    }

    @Override
    public CommunicationData updateCard(Card card) {
        // TODO 此处的方法应该在sql执行之后
        card.setModifyTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        try {
            Card tempCard = new Card();
            tempCard.setId(card.getId());
            List<Card> select = cardDao.select(tempCard);
            if (select.size() == 1) {
                card.setVersion(select.get(0).getVersion()+1);
                int update = cardDao.update(card);
                if (update > 0) {
                    return CommunicationData.SUCCESS();
                }
            }
        }catch (Exception e) {
            log.error("CardServiceImpl#updateCard error");
        }
        return CommunicationData.FAIL("更新失败");
    }

}
