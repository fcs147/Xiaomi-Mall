package com.fz.pojo;

import com.fz.enums.OrderStatusEnum;
import com.fz.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: FZ
 * @date: 2021/4/16 20:35
 * @description:
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
//    订单id
    private String  orderId;
//    买家名字
    private  String buyerName;
    //买家手机号
    private String buyerPhone;
//    买家地址
    private String buyerAddress;
    //    买家微信
    private String buyerOpenid;
    //订单金额
    private BigDecimal orderAmount;
//      订单状态
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();
    //支付状态
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
        //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;


}
