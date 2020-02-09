package com.tao.sell.repsonsitory;

import com.tao.sell.dataobject.OrderMaster;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.*;


import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepsonsitoryTest {

    public final String Openid="110110";

    @Autowired
    private  OrderMasterRepsonsitory repsonsitory;

    @Test
    void findByBuyerOpenid() {
        PageRequest request=PageRequest.of(0,1);
        Page<OrderMaster> result = repsonsitory.findByBuyerOpenid(Openid, request);
        //判断总的条数不等于0
        Assert.assertNotSame(0,result.getTotalElements());
        System.out.println(result.getTotalElements());

    }

    @Test
    public void save(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("12313");
        orderMaster.setBuyerName("张家亮");
        orderMaster.setBuyerPhone("12345678911");
        orderMaster.setBuyerAddress("慕课网课程");
        orderMaster.setBuyerOpenid(Openid);
        orderMaster.setOrderAmount(new BigDecimal(5.3));
        OrderMaster result = repsonsitory.save(orderMaster);
        Assert.assertNotNull(result);
    }
}