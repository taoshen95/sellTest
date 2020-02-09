package com.tao.sell.dataobject;


import com.tao.sell.enums.OrderStatusEnum;
import com.tao.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    /** 订单id**/
    @Id
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
    private  Integer orderStatus=OrderStatusEnum.NEW.getCode() ;

    /** 支付状态，默认为0未支付**/
    private Integer payStatus= PayStatusEnum.WAIT.getCode();

//    /** 创建时间**/
//    private Data createTime;
//
//    /** 更新时间**/
//    private Data updateTime;
}
