package com.tao.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品详情
 * @BelongsProject: sell
 * @BelongsPackage: com.tao.sell.VO
 * @Author: Administrator
 * @CreateTime: 2020-02-07 08:55
 */

@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private  String productId;

    @JsonProperty("name")
    private  String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
