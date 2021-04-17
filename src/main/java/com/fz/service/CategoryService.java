package com.fz.service;

import com.fz.pojo.ProductCategory;

import java.util.List;

/**
 * @author: FZ
 * @date: 2021/4/15 15:21
 * @description:
 */

public interface CategoryService {
        //通过类目编号查询某一个
    ProductCategory findOne(Integer categoryId);
        //查询所有
    List<ProductCategory> findAll();
        //
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
        //
    ProductCategory save(ProductCategory productCategory);


}
