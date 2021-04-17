package com.fz.dao;

import com.fz.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: FZ
 * @date: 2021/4/15 13:24
 * @description:
 */

public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {
    //通过类目编号查询某一个
    ProductCategory findOne(Integer categoryId);
    //查询所有
    List<ProductCategory> findAll();
    //查询类目
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
