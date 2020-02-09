package com.tao.sell.service.impl;

import com.tao.sell.dataobject.ProductInfo;
import com.tao.sell.dto.CartDTO;
import com.tao.sell.enums.ProductStatusEnums;
import com.tao.sell.enums.ResultEnums;
import com.tao.sell.exception.SellException;
import com.tao.sell.repsonsitory.ProductInfoRepsonsitory;
import com.tao.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

/**
 * @BelongsProject: sell
 * @BelongsPackage: com.tao.sell.service.impl
 * @Author: Administrator
 * @CreateTime: 2020-02-06 16:41
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepsonsitory infoRepsonsitory;

    @Override
    public ProductInfo findOne(String productId) {
        return infoRepsonsitory.findById(productId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return infoRepsonsitory.findByProductStatus(ProductStatusEnums.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(org.springframework.data.domain.Pageable pageable) {
        return infoRepsonsitory.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return infoRepsonsitory.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO :cartDTOList){
            ProductInfo productInfo = infoRepsonsitory.findById(cartDTO.getProductId()).orElse(null);
             if (productInfo==null){
                 throw  new SellException(ResultEnums.PRODUCT_NOT_EXIST);
             }
            int result = productInfo.getProductStock() - cartDTO.getProductQuantity();
             if (result<0){
                 throw new SellException(ResultEnums.PRODUCT_STOCK_ERROR);
             }
             productInfo.setProductStock(result);
            infoRepsonsitory.save(productInfo);
        }
    }
}
