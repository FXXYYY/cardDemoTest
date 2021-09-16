package com.demo.service;

import com.demo.domains.DebitCard;
import com.demo.dao.DebitCardDao;
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

}
