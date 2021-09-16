package com.demo.util;

import com.demo.enums.ResponseCodeEnum;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/14 22:59
 * @description 公共返回类型 TODO
 */
public class CommunicationData {
    public enum  Status {
        SUCCESS, FAIL
    }

    //状态 SUCCESS FAIL
    private Status status;

    //错误编码，000000表示成功
    private String code;

    //错误信息
    private String msg;

    private String token;
    //返回数据
    private Object data;

    public CommunicationData() {
    }

    private CommunicationData(Status status) {
        this.status = status;
    }

    public CommunicationData(Status status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public CommunicationData(Status status, String code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public CommunicationData message(String message) {
        this.msg = message;
        return this;
    }

    public CommunicationData data(Object data) {
        this.data = data;
        return this;
    }

    public static CommunicationData FAIL(String msg) {
        return new CommunicationData(Status.FAIL).message(msg);
    }

    public static CommunicationData SUCCESS() {
        return new CommunicationData(Status.SUCCESS);
    }

    public static CommunicationData create(Status status, ResponseCodeEnum codeEnum) {
        return new CommunicationData(status, codeEnum.getCode(), codeEnum.getMsg());
    }

    public static CommunicationData create() {
        return new CommunicationData();
    }

    public CommunicationData refreshToken(String token) {
        this.token = token;
        return this;
    }

    public Status getStatus() {
        return status;
    }

//	private void setStatus(Status status) {
//		this.status = status;
//	}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommunicationData{" +
                "status='" + status +  '\'' +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}