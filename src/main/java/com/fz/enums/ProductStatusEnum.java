package com.fz.enums;

import lombok.Getter;

/**
 * @author: FZ
 * @date: 2021/4/15 18:10
 * @description:
 * 商品状态
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }
}
