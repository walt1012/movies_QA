package com.walt.result;


public enum ResponseMessage {

    // 成功
    OK(200, "成功"),

    // 错误的请求
    BAD_REQUEST(400, "错误的请求"),
    ;


    private final int status;

    private final String message;

    ResponseMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
