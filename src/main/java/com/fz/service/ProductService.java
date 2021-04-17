package com.fz.service;

import com.fz.dto.CartDTO;
import com.fz.pojo.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author: FZ
 * @date: 2021/4/15 17:39
 * @description:
 */
public interface ProductService {

    //查看某一商品
    ProductInfo findOne(String productId);
    //查询在架商品
    List<ProductInfo> findUpAll();
    //
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);
    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
