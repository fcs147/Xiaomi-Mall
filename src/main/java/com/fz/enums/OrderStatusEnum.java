package com.fz.enums;

import lombok.Getter;

/**
 * @author: FZ
 * @date: 2021/4/16 20:44
 * @description:
 */
@Getter
public enum OrderStatusEnum {
        NEW(0,"新订单"),
        FINISHED(1,"完结"),
        CANCLE(2,"已取消");
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code,String message) {
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }
}
