package com.tao.sell.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    DOWN(1,"完结"),
    CANCLE(2,"已取消"),
            ;
    private Integer code;

    private String message;


}
