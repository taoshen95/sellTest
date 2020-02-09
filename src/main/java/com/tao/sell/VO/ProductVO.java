package com.tao.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品类目
 * @BelongsProject: sell
 * @BelongsPackage: com.tao.sell.VO
 * @Author: Administrator
 * @CreateTime: 2020-02-07 08:53
 */

@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> ProductInfoVOList;
}
