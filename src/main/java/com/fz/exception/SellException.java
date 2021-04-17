package com.fz.exception;

import com.fz.enums.ResultEnum;

/**
 * @author: FZ
 * @date: 2021/4/17 10:28
 * @description:
 */
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
