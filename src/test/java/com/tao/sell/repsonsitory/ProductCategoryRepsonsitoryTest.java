package com.tao.sell.repsonsitory;

import com.tao.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepsonsitoryTest {

    @Autowired
    private ProductCategoryRepsonsitory repsonsitory;


    @Test
    public void findOneTest() {
        ProductCategory productCategory = repsonsitory.findById(1).orElse(null);
        System.out.println(productCategory.toString());
    }


    @Test
    public void AddOne(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        repsonsitory.save(productCategory);
    }

    @Test
    public void selcetTest(){
        ProductCategory productCategory = repsonsitory.findById(2).orElse(null);
        productCategory.setCategoryType(3);
        repsonsitory.save(productCategory);
    }

    @Test
    @Transactional
    public void add2(){
        ProductCategory productCategory=new ProductCategory(-1,"男生最爱",3);
        ProductCategory result =repsonsitory.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test   //工具类Arrays.asList()把数组转换成集合
    public void add3(){
        List<Integer> list= Arrays.asList(2,3,4);
        List<ProductCategory> result =repsonsitory.findByCategoryTypeIn(list);
        //assertNotEquals(**，**) 的时候 注意 比较两端数据类型，
        // 只支持float double Object 这三种类型
        Assert.assertNotEquals(0,result.size());

    }
}