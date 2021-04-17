package com.fz.service.impl;

import com.fz.dto.OrderDTO;
import com.fz.enums.OrderStatusEnum;
import com.fz.enums.PayStatusEnum;
import com.fz.pojo.OrderDetail;
import com.fz.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author: FZ
 * @date: 2021/4/17 12:15
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
@Autowired
OrderServiceImpl orderService;
@Autowired
ProductService productService;
private final String BUYER_OPENID="1101110";
private final String ORDER_ID="1618641850461841046";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO( );
        orderDTO.setBuyerName("廖师兄");
        orderDTO.setBuyerAddress("白云");
        orderDTO.setBuyerPhone("12345");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        //购物车
        ArrayList<OrderDetail> orderDetailList = new ArrayList<>( );
        OrderDetail o1 = new OrderDetail( );
        o1.setProductId("1");
        o1.setProductQuantity(5);
        orderDetailList.add(o1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("3");
        o2.setProductQuantity(2);
        orderDetailList.add(o2);



        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单]result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】result={}",result );
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0,2 );
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageRequest);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
       OrderDTO orderDTO  = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertNotEquals(OrderStatusEnum.CANCLE.getCode(),result.getOrderStatus());

    }

    @Test
    public void finish() {
        OrderDTO orderDTO  = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());

    }

    @Test
    public void paid() {
        OrderDTO orderDTO  = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());

    }
}