package com.tao.sell.repsonsitory;

import com.tao.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @BelongsProject: sell
 * @BelongsPackage: com.tao.sell.repsonsitory
 * @Author: Administrator
 * @CreateTime: 2020-02-06 11:24
 *  JpaRepository<T, Serializable>   T：写的是dao操作对应的实体 ，Serializable：是主键的类型
 */
public interface ProductCategoryRepsonsitory extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
