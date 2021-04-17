package com.fz.dto;

import lombok.Data;

/**
 * @author: FZ
 * @date: 2021/4/17 11:14
 * @description:
 */
@Data
public class CartDTO {
    /* 商品id*/
    private String productId;
    //数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}

