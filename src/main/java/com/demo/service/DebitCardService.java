package com.demo.service;

import com.demo.domains.DebitCard;
import com.demo.dao.DebitCardDao;
import com.demo.domains.User;
import com.demo.util.CommunicationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author fxy
 */
public interface DebitCardService {


    /**
     * 插入
     * @param pojo
     * @return
     */
    public int insert(DebitCard pojo);

    /**
     * 插入
     * @param pojos
     * @return
     */
    public int insertList(List< DebitCard> pojos);

    /**
     * 查询
     * @param pojo
     * @return
     */
    public List<DebitCard> select(DebitCard pojo);

    /**
     * 更新
     * @param pojo
     * @return
     */
    public int update(DebitCard pojo);

    /**
     * 查询
     * @param pojo
     * @return
     */
    CommunicationData selectDebitCard(DebitCard pojo);

    /**
     * 新增
     * @param debitCard
     * @return
     */
    CommunicationData addDebitCard(DebitCard debitCard);

    /**
     * 修改
     * @param debitCard
     * @return
     */
    CommunicationData updateDebitCard(DebitCard debitCard);


}
