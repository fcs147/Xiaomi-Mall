package com.fz.web;

import com.fz.VO.ResultVO;
import com.fz.converter.OrderForm2OrderDTOConverter;
import com.fz.dto.OrderDTO;
import com.fz.enums.ResultEnum;
import com.fz.exception.SellException;
import com.fz.form.OrderForm;
import com.fz.service.OrderService;
import com.fz.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: FZ
 * @date: 2021/4/17 20:07
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderWeb {
@Autowired
private OrderService orderService;
    //创建订单
@PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm ,BindingResult bindingResult){
    if(bindingResult.hasErrors()){
        log.error("【创建订单】参数不正确,orderForm={}",orderForm);
        throw new SellException(ResultEnum.PARAM_ERROR.getCode()
                ,bindingResult.getFieldError().getDefaultMessage());
    }
    OrderDTO orderDTO = OrderForm2OrderDTOConverter.converter(orderForm);
    if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
        log.error("【创建订单】购物车不能为空");
        throw new SellException(ResultEnum.CART_EMPTY);
    }
    OrderDTO result = orderService.create(orderDTO);
    Map<String,String> map =new HashMap<String,String>();
    map.put("orderId",result.getOrderId());

    return ResultVOUtil.success( map );
}
    //订单列表

    //订单详情

    //取消订单



}
