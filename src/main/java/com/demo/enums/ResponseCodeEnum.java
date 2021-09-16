package com.demo.enums;
/**
 * @author fxy
 */
public enum ResponseCodeEnum {
    SUCCESS("000000","成功"),
    SYS_ERROR("001001","系统异常，请稍候重试"),
    SYS_PARAM_NOT_RIGHT("001002","请求参数错误"),
    SYSTEM_BUSY("001099","系统繁忙，请稍候重试"),

    FILE_NOT_FIND("000001", "未找到模板文件"),
    FILE_DOWNLOAD_FAIL("000002", "下载文件失败"),
    FILE_SAVE_FAIL("000003", "文件保存失败"),
    FILE_FORMAT_ERROR("000004", "文件格式不正确"),
    FILE_IMPORT_ERROR("000004", "文件导入异常"),
    PARAM_FORMAT_ERROR("000005", "请求参数格式有误"),
    FILE_EXPORT_ERROR("000006", "导出异常"),
    SAVE_UPDATE_ERROR("000007", "保存或更新异常"),
	
    TIMEOUT("000008", "登录超时，请重新登录"),
	UNAUTHORIZED("000009", "验证失败，请重新登录"),
	MALICIOUSLY_MODIFIED("0000010", "验证失败，令牌恶意修改");
    private final String code;
    private final  String msg;
    ResponseCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}