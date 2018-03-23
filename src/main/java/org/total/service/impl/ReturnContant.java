package org.total.service.impl;


import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ReturnContant  implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int status;
    private String msg;
    private Object data;
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}