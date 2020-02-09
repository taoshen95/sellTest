package com.tao.sell.service;

import com.tao.sell.dataobject.ProductCategory;
import com.tao.sell.dataobject.ProductInfo;
import com.tao.sell.dto.CartDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

/*
商品
 */
public interface ProductService {
    /**
     * 查询单个商品信息
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();


    /**
     * Pageable 是Spring Data库中定义的一个接口,用于构造翻页查询,
     * 是所有分页相关信息的一个抽象,通过该接口,我们可以得到和分页相关所有信息
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(org.springframework.data.domain.Pageable pageable);


    ProductInfo save(ProductInfo productInfo);

    //加库存
      void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);


}
