package com.fz.enums;

import lombok.Getter;

/**
 * @author: FZ
 * @date: 2021/4/16 20:48
 * @description:
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"未支付 "),
    SUCCESS(1,"已支付"),
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message=message;
    }
}
