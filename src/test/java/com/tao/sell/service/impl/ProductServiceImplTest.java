package com.tao.sell.service.impl;

import com.tao.sell.dataobject.ProductInfo;
import com.tao.sell.enums.ProductStatusEnums;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private  ProductServiceImpl productService;

    @Test  //如果两者一致, 程序继续往下运行
    void findOne() {
        ProductInfo productInfo=productService.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());

    }

    @Test
    void findUpAll() {//void assertNotEquals(long unexpected, long actual) 比较两端的数据类型
        List<ProductInfo> upAll = productService.findUpAll();
        Assert.assertNotEquals(0,upAll.size());
    }

    @Test
    void findAll() { //PageRequest JPA分页
        PageRequest request =PageRequest.of(0,2);//PageRequest.of()新写法
        Page<ProductInfo> productPage=productService.findAll(request);
        System.out.println(productPage.getTotalElements());//getTotalElements记录数
    }

    @Test
    void save() {
        ProductInfo saveinfo = new ProductInfo();
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("屁屁虾");
        productInfo.setProductPrice(new BigDecimal(10.0));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("招牌菜");
        productInfo.setProductIcon("http://jjjjjxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnums.DOWN.getCode());
        productInfo.setCategoryType(3);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result); //assertNotNull断言某个值 不为空


    }
}