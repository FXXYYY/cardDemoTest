package com.demo.domains;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/11 15:35
 * 套餐信息表
 */
@Data
public class TariffPackage {


    /**
     * 表id
     */
    private Long id;

    /**
     * 套餐包名称
     */
    private String name;

    /**
     * 供应商外键
     */
    private String supplierPkgId;

    /**
     * 供应生产商外键
     */
    private String supplierProductId;


    /**
     * 关联外键-套餐信息表
     */
    private Long supplierAttrId;

    /**
     * 备注
     */
    private String supplierValue;


    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;






}