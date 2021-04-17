package com.fz.dao;

import com.fz.pojo.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author: FZ
 * @date: 2021/4/16 21:48
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterDaoTest {
@Autowired
    OrderMasterDao dao;
final String OPENID= "10086";

@Test
public void add(){
    OrderMaster orderMaster = new OrderMaster( );
    orderMaster.setOrderId("123457");
    orderMaster.setBuyerName("师兄");
    orderMaster.setBuyerPhone("15992000490");
    orderMaster.setBuyerAddress("白云");
    orderMaster.setBuyerOpenid("10086");
    orderMaster.setOrderAmount(new BigDecimal(2.5));
    OrderMaster save = dao.save(orderMaster);
    Assert.assertNotNull(save);
}


    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0,1 );
        Page<OrderMaster> byBuyerOpenid = dao.findByBuyerOpenid(OPENID, pageRequest);
    }
}