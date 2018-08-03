package org.total.exception;
/*
自定义异常信息
 */
public class TotalException extends RuntimeException {

//    private Integer code;
//
//
//
//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//
    public TotalException(String message) {
        super(message);

    }


}
