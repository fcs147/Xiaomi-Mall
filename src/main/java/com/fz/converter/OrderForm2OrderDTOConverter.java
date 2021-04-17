package com.fz.converter;

import com.fz.dto.OrderDTO;
import com.fz.enums.ResultEnum;
import com.fz.exception.SellException;
import com.fz.form.OrderForm;
import com.fz.pojo.OrderDetail;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: FZ
 * @date: 2021/4/17 20:43
 * @description:
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
public static OrderDTO converter(OrderForm orderForm){
    Gson gson = new Gson( );
    OrderDTO orderDTO = new OrderDTO( );
    orderDTO.setBuyerName(orderForm.getName());
    orderDTO.setBuyerPhone(orderForm.getPhone());
    orderDTO.setBuyerAddress(orderForm.getAddress());
    orderDTO.setBuyerOpenid(orderForm.getOpenid());

    List<OrderDetail> orderDetailList = new ArrayList<>( );
    try {
        orderDetailList = gson.fromJson(orderForm.getItems(),
                new TypeToken<List<OrderDetail>>(){}.getType());
    } catch (JsonSyntaxException e) {
        log.error("【对象装换】错误,string={}",orderForm.getItems());
        throw new SellException(ResultEnum.PARAM_ERROR);
    }
    orderDTO.setOrderDetailList(orderDetailList);
    return orderDTO;
}
}
