package com.demo.service;

import com.demo.domains.DebitCard;
import com.demo.domains.User;
import com.demo.util.CommunicationData;

import java.util.List;

/**
 * @author fxy
 */
public interface DebitCardManagerService {


    /**
     * 人员开卡
     * @param user
     * @param cardNo
     * @param tariffPackageId
     * @return
     */
    CommunicationData openCard(User user, Long cardNo, Long tariffPackageId);


    // TODO 更改卡状态、删除卡、更改卡信息


}
