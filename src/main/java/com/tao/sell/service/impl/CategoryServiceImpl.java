package com.tao.sell.service.impl;

import com.tao.sell.dataobject.ProductCategory;
import com.tao.sell.repsonsitory.ProductCategoryRepsonsitory;
import com.tao.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
    类目
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductCategoryRepsonsitory repsonsitory;

    @Override
    public ProductCategory findOne(Integer CategoryId) {
        return repsonsitory.findById(CategoryId).orElse(null);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repsonsitory.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repsonsitory.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repsonsitory.save(productCategory);
    }
}
