package com.tao.sell.dto;


import com.tao.sell.dataobject.OrderDetail;
import com.tao.sell.enums.OrderStatusEnum;
import com.tao.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {
    /** 订单id**/
    private  String orderId;

    /** 买家名字**/
    private  String buyerName;

    /** 买家电话**/
    private  String buyerPhone;

    /** 买家地址**/
    private  String buyerAddress;

    /** 买家微信openid**/
    private  String buyerOpenid;

    /** 订单总金额**/
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单**/
    private  Integer orderStatus;

    /** 支付状态，默认为0未支付**/
    private Integer payStatus;

    List<OrderDetail> orderDetailList;
}
