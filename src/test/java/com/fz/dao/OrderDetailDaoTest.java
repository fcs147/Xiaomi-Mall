package com.fz.dao;

import com.fz.pojo.OrderDetail;
import com.fz.pojo.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: FZ
 * @date: 2021/4/16 22:09
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailDaoTest {
@Autowired
    OrderDetailDao dao;

@Test
public void saveTest(){
    OrderDetail orderDetail = new OrderDetail( );
    orderDetail.setDetailId("123456788");
    orderDetail.setOrderId("123456");
    orderDetail.setProductIcon("whdasda.jpg");
    orderDetail.setProductId("321321");
    orderDetail.setProductName("香蕉");
    orderDetail.setProductPrice(new BigDecimal(3.9));
    orderDetail.setProductQuantity(5);
    OrderDetail save = dao.save(orderDetail);
    Assert.assertNotNull(save);

}

    @Test
    public void findByOrderId() {
        List<OrderDetail> byOrderId = dao.findByOrderId("123456");
        Assert.assertNotEquals(0,byOrderId.size());
    }
}