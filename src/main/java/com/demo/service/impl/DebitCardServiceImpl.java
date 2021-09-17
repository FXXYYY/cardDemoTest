package com.demo.service.impl;

import com.demo.dao.DebitCardDao;
import com.demo.domains.Card;
import com.demo.domains.DebitCard;
import com.demo.domains.User;
import com.demo.service.DebitCardService;
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
public class DebitCardServiceImpl implements DebitCardService {

    @Autowired
    private DebitCardDao debitCardDao;

    @Override
    public int insert(DebitCard pojo){
        return debitCardDao.insert(pojo);
    }

    @Override
    public int insertList(List< DebitCard> pojos){
        return debitCardDao.insertList(pojos);
    }

    @Override
    public List<DebitCard> select(DebitCard pojo){
        return debitCardDao.select(pojo);
    }

    @Override
    public int update(DebitCard pojo){
        return debitCardDao.update(pojo);
    }

    @Override
    public CommunicationData selectDebitCard(DebitCard pojo) {
        try {
            List<DebitCard> select = debitCardDao.select(pojo);
            return CommunicationData.SUCCESS().data(select);
        }catch (Exception e) {
            log.error("DebitCardController#getDebitCard error");
        }
        return CommunicationData.FAIL("查询失败");
    }

    @Override
    public CommunicationData addDebitCard(DebitCard debitCard) {
        // TODO 此处的方法应该在sql执行之后
        debitCard.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        debitCard.setModifyTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        try {
            int insert = debitCardDao.insert(debitCard);
            if (insert > 0) {
                return CommunicationData.SUCCESS();
            }
        }catch (Exception e) {
            log.error("DebitCardController#addDebitCard error");
        }
        return CommunicationData.FAIL("插入失败");
    }

    @Override
    public CommunicationData updateDebitCard(DebitCard debitCard) {
        // TODO 此处的方法应该在sql执行之后
        debitCard.setModifyTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        try {
            DebitCard temp = new DebitCard();
            temp.setId(debitCard.getId());
            List<DebitCard> select = debitCardDao.select(temp);
            if (select.size() == 1) {
                int update = debitCardDao.update(debitCard);
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
