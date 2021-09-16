package com.demo.service;

import com.demo.domains.Card;
import com.demo.dao.CardDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author fxy
 */
public interface CardService {


    /**
     * 插入
     * @param pojo
     * @return
     */
    public int insert(Card pojo);

    /**
     * 插入
     * @param pojos
     * @return
     */
    public int insertList(List< Card> pojos);

    /**
     * 查询
     * @param pojo
     * @return
     */
    public List<Card> select(Card pojo);

    /**
     * 更新
     * @param pojo
     * @return
     */
    public int update(Card pojo);

}
