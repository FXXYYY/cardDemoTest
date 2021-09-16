package com.demo.domains;

import com.demo.enums.CarrierType;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/11 15:35
 * 卡⽚信息
 */
@Data
public class Card {


    /**
     * 表id
     */
    private Long id;

    /**
     * 移动用户的ISDN号码
     */
    private String msisdn;

    /**
     * 集成电路卡识别码
     */
    private String iccid;

    /**
     * 国际移动用户识别码
     */
    private String imsi;

    /**
     * 运营商CMCC，CTCC，CUCC
     */
    private String carrierType;

    /**
     * 套餐包-关联外键
     */
    private Long pkgId;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 版本
     */
    private Integer version;

    /**
     * 修改时间
     */
    private String modifyTime;

    /**
     * 备注
     */
    private String remark;




}