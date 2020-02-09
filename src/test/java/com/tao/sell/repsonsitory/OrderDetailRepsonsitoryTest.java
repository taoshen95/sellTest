package com.tao.sell.repsonsitory;

import com.tao.sell.dataobject.OrderDetail;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.*;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailRepsonsitoryTest {

    @Autowired
    private OrderDetailRepsonsitory repsonsitory;

    @Test
    void findByOrderId() {
        List<OrderDetail> orderId = repsonsitory.findByOrderId("123123");
        Assert.assertNotSame(0,orderId.size());
    }

    @Test
    void saveTest() {
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("123456789");
        orderDetail.setOrderId("123123");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("112112");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(5.2));
        orderDetail.setProductQuantity(2);

        OrderDetail result= repsonsitory.save(orderDetail);
        Assert.assertNotNull(result);
    }
}