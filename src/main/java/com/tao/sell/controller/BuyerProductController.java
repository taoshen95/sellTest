package com.tao.sell.controller;

import com.tao.sell.VO.ProductInfoVO;
import com.tao.sell.VO.ProductVO;
import com.tao.sell.VO.ResultVO;
import com.tao.sell.dataobject.ProductCategory;
import com.tao.sell.dataobject.ProductInfo;
import com.tao.sell.service.CategoryService;
import com.tao.sell.service.ProductService;
import com.tao.sell.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 卖家商品
 * @BelongsProject: sell
 * @BelongsPackage: com.tao.sell.controller
 * @Author: Administrator
 * @CreateTime: 2020-02-06 17:19
 */

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1查询所有上架的商品
        List<ProductInfo> productInfoList =productService.findUpAll();

        //2查询类目（一次性查询）
        List<Integer> categoryTypeList =new ArrayList<>();

        //传统
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3数据拼装
        List<ProductVO> productVOList=new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO=new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    //copyProperties(Object source, Object target) productInfo的值赋给productInfoVO
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }


        return  ResultVOUtil.success(productVOList);




    }


    @GetMapping("/hello")
    public String test(){
        return "你好";
    }


}
