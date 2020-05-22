package com.aliyun.carManager.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class RecognizeStatus {
    private boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RecognizeStatus() {

    }
}
