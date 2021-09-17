package com.demo.enums;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/17 23:45
 */
public enum  DebitCardStatus {
    //正常、冻结、销户、挂失、锁定、止付

    NORMAL("正常"),
    FROZEN("冻结"),
    ACCOUNT_CANCELLATION("销户"),
    REPORT_LOSS("挂失"),
    LOCK("锁定"),
    STOP_PAYMENT("止付");

    private String label;

    DebitCardStatus(String label) {
        this.label = label;
    }
}