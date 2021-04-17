package com.fz.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author: FZ
 * @date: 2021/4/17 20:20
 * @description:
 */
@Data
public class OrderForm {
    /**
     * 买家姓名
     */
    @NotEmpty(message="姓名必填")
    private String name;
    /**
     * 买家手机号
     */
    @NotEmpty(message="手机号必填")
    private String phone;
    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;
    /**
     * 买家微信
     */
    @NotEmpty(message = "openid必填")
    private String openid;
    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能空")
    private String items;
}
