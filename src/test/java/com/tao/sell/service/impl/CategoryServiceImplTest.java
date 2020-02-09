package com.tao.sell.service.impl;

import com.tao.sell.dataobject.ProductCategory;
import com.tao.sell.service.CategoryService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl CategoryService;


    @Test
    void findOne()throws Exception {
        ProductCategory productCategory=CategoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    void findAll() throws Exception{
        List<ProductCategory> list=CategoryService.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    void findByCategoryTypeIn() throws Exception{
        List<ProductCategory> list =CategoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4,5));
        Assert.assertNotEquals(0,list);
    }

    @Test
    void save() throws Exception{
        ProductCategory productCategory=CategoryService.save(new ProductCategory(-1,"男生最爱",10));
        Assert.assertNotNull(productCategory);

    }
}