package com.fz.service.impl;

import com.fz.pojo.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author: FZ
 * @date: 2021/4/15 15:36
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
@Autowired
CategoryServiceImpl productCategoryService;
    @Test
    public void findOne() {
        ProductCategory one = productCategoryService.findOne(2);
        System.out.println(one );
    }

    @Test
    public void findAll() {
        List<ProductCategory> all = productCategoryService.findAll( );
        Assert.assertNotEquals(0,all.size());

    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> byCategoryTypeIn = productCategoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4 ));
        Assert.assertNotEquals(0,byCategoryTypeIn.size());


    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory( );
        productCategory.setCategoryName("男生专享");
        productCategory.setCategoryType(6);
        ProductCategory save = productCategoryService.save(productCategory);
        Assert.assertNotNull(save);
    }
}