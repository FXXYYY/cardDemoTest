package com.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.demo.dao.CardDao;
import com.demo.dao.DebitCardDao;
import com.demo.dao.TariffPackageDao;
import com.demo.dao.UserDao;
import com.demo.domains.Card;
import com.demo.domains.DebitCard;
import com.demo.domains.TariffPackage;
import com.demo.domains.User;
import com.demo.enums.DebitCardStatus;
import com.demo.service.DebitCardManagerService;
import com.demo.service.DebitCardService;
import com.demo.util.CommunicationData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author fxy
 */
@Slf4j
@Service
public class DebitCardManagerServiceImpl implements DebitCardManagerService {

    @Autowired
    private DebitCardDao debitCardDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CardDao cardDao;

    @Autowired
    private TariffPackageDao tariffPackageDao;


    @Override
    public CommunicationData openCard(User user, Long cardNo, Long tariffPackageId) {

        try{
            DebitCard debitCard = new DebitCard();
            debitCard.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            debitCard.setModifyTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            debitCard.setIsDelete(0);
            //debitCard.setResId(tariffPackageId);
            debitCard.setStatus(0);
            //借记卡卡和用户绑定
            debitCard.setUserId(user.getId());
            //卡和套餐套绑定
            Card card = cardDao.selectById(cardNo);
            card.setPkgId(tariffPackageId);
            Long insert = debitCardDao.insertReturnId(debitCard);
            DebitCard debitCard1 = debitCardDao.selectById(insert);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("data", debitCard1);
            jsonObject.put("msg", "开卡成功");
            return CommunicationData.SUCCESS().data(debitCard1);
        }catch (Exception e) {
            e.printStackTrace();
            log.error("DebitCardManagerServiceImpl#openCard error");
        }
        return CommunicationData.FAIL("开卡失败");
    }
}
