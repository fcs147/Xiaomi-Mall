package com.fz.service;

import com.fz.dto.OrderDTO;
import com.fz.pojo.OrderMaster;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: FZ
 * @date: 2021/4/16 22:27
 * @description:
 */

public interface OrderService {
     //创建订单
OrderDTO create(OrderDTO orderDTO);
    //查询单个订单
OrderDTO findOne(String  orderId);
    //查询订单列表
Page<OrderDTO> findList(String buyerOpenid ,Pageable pageable);
    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);
    //完结订单
OrderDTO finish(OrderDTO orderDTO);
    //支付订单
OrderDTO paid(OrderDTO orderDTO);
}
