package com.tao.sell.service.impl;

import com.tao.sell.dataobject.OrderDetail;
import com.tao.sell.dto.CartDTO;
import com.tao.sell.dto.OrderDTO;
import junit.framework.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    private final String  BUYER_OPENID="110112";

    private final String ORDER_ID="1581255026168825292";
    @Test
    void create() {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName("李家涛");
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerPhone("98765432111");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailist = new ArrayList<>();
        OrderDetail o1=new OrderDetail();
        o1.setProductId("12345678");
        o1.setProductQuantity(1);
        orderDetailist.add(o1);

        OrderDetail o2=new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(1);
        orderDetailist.add(o2);

        orderDTO.setOrderDetailList(orderDetailist);
        OrderDTO result = orderService.create(orderDTO);
        log.info("=====创建订单====="+result);
        Assert.assertNotNull(result);
    }

    @Test
    void findOne() {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】"+result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    void findList() {
    }

    @Test
    void canel() {
    }

    @Test
    void finish() {
    }

    @Test
    void paid() {
    }
}