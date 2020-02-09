package com.tao.sell.dataobject;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

/**
 * @BelongsProject: sell
 * @BelongsPackage: com.tao.sell.dataobject
 * @Author: Administrator
 * @CreateTime: 2020-02-06 11:18
 */

//类目
    @Data
    @Entity
    @DynamicUpdate
    @AllArgsConstructor
    @NoArgsConstructor
    public class ProductCategory {

    /**类目id **/
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //为一个实体生成一个唯一标识的主键
    private Integer categoryId;


    /**类目名字 **/
    private String  categoryName;


    /**类目编号 **/
    private Integer categoryType;

//
//    private Date createTime;
//
//    private Date updateTime;



}
