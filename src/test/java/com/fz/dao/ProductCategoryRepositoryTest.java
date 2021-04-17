package com.fz.dao;

import com.fz.pojo.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * @author: FZ
 * @date: 2021/4/15 13:53
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
@Autowired
ProductCategoryDao repository;


@Test
    public void test1(){
    ProductCategory productCategory = repository.findOne(1);
    System.out.println(productCategory.toString() );
}
    @Test
    @Transactional
    public void add(){
        ProductCategory productCategory = new ProductCategory(  );
        productCategory.setCategoryName("fz最爱");
        productCategory.setCategoryType(8);
        ProductCategory save = repository.save(productCategory);
        Assert.assertNotNull(save);

    }
    @Test
    public void findBYCategoryTypeTest(){
        List<Integer> list = Arrays.asList(2,3,4,5);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());


}

}