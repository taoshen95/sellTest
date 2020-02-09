package com.tao.sell.repsonsitory;

import com.tao.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepsonsitory extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);

    //写方法一定要根据Jpa格式来写
    // （报错）原来写法findProductStatus==>findByProductStatus

}


