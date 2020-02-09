package com.tao.sell.repsonsitory;

import com.tao.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoRepsonsitoryTest {

    @Autowired
    private  ProductInfoRepsonsitory  inforepsonsitory;

    @Test
    public void saveTest(){

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result = inforepsonsitory.save(productInfo);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> status = inforepsonsitory.findByProductStatus(0);
        Assert.assertNotEquals(0,status.size());

    }
}