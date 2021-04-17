package com.fz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author: FZ
 * @date: 2021/4/15 16:11
 * @description:
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo {
    @Id
    private String productId;
    //商品名字
    private String productName;
    //单价
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //商品描述
    private String productDescription;
    //  图片
    private String productIcon;
    //状态
    private Integer productStatus;
    //类目编号
    private Integer categoryType;

    public String getProductId() {
        return productId;
    }
}
