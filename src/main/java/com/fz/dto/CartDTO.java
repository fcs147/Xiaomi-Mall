package com.fz.dto;

import lombok.Data;

/**
 * @author: FZ
 * @date: 2021/4/17 11:14
 * @description:
 */
@Data
public class CartDTO {
    /* ååid*/
    private String productId;
    //æ°é
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}

