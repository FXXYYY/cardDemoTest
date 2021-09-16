package com.demo.enums;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/11 16:34
 */
public enum CarrierType {

    CMCC("中国移动"),
    CUCC("中国联通"),
    CTCC("中国电信");

    private String label;

    CarrierType(String label) {
        this.label = label;
    }

}
