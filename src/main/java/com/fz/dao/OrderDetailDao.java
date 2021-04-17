package com.fz.dao;

import com.fz.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: FZ
 * @date: 2021/4/16 21:46
 * @description:
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String > {

     List<OrderDetail> findByOrderId(String orderId);



}
