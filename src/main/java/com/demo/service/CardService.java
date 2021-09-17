package com.demo.service;

import com.demo.domains.Card;
import com.demo.dao.CardDao;
import com.demo.util.CommunicationData;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fxy
 */
public interface CardService {



    /**
     * 查询
     * @param pojo
     * @return
     */
    public CommunicationData selectCard(Card pojo);

    /**
     * 新增
     * @param card
     * @return
     */
    public CommunicationData insertCard(Card card);

    /**
     * 更新 updateCard
     * @param card
     * @return
     */
    public CommunicationData updateCard(Card card);


}
