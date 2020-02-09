package com.tao.sell.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @BelongsProject: sell
 * @BelongsPackage: com.tao.sell.dataobject
 * @Author: Administrator
 * @CreateTime: 2020-02-06 15:42
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;

    /** 名字**/
    private String productName;

    /** 单价**/
    private BigDecimal productPrice;

    /** 库存**/
    private Integer productStock;

    /** 描述**/
    private String productDescription;

    /** 小图**/
    private String productIcon;

    /** 状态   0正常，1下架**/
    private Integer productStatus;

    /** 类目编号**/
    private Integer categoryType;
}
