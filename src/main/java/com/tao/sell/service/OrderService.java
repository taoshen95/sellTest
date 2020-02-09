package com.tao.sell.service;

import com.tao.sell.dataobject.OrderDetail;
import com.tao.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    /**创建订单**/
    OrderDTO create(OrderDTO orderDTO);

    /**查询单个订单**/
    OrderDTO findOne(String orderid);

    /**查询订单列表**/
    Page<OrderDTO> findList(String buyeropenid, Pageable pageable);

    /**取消订单**/
    OrderDTO canel(OrderDTO orderDTO);

    /**完结订单**/
    OrderDTO finish(OrderDTO orderDTO);

    /**支付订单**/
    OrderDTO paid(OrderDTO orderDTO);
}
