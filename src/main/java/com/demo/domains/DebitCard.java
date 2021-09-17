package com.demo.domains;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/11 15:35
 * 借记信息表
 */
@Data
public class DebitCard {

    /**
     * 表id
     */
    private Long id;

    /**
     * 用户-关联外键
     */
    private Long userId;

    /**
     * 供应商-关联外键
     */
    private Long resId;

    /**
     * 创建时间
     */
    private String createTime;


    /**
     * 修改时间
     */
    private String modifyTime;

    /**
     * 状态 {0:正常、1:冻结、2:销户、3:挂失、4:锁定、5:止付}
     */
    private Integer status;

    /**
     * 0未删除，1删除
     */
    private Integer isDelete;




}