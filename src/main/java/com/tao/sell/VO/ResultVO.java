package com.tao.sell.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @BelongsProject: sell
 * @BelongsPackage: com.tao.sell.VO
 * @Author: Administrator
 * @CreateTime: 2020-02-06 17:23
 */

@Data
public class ResultVO<T> {

    /**错误码**/
    private Integer code;

    /**提示信息**/
    private String msg;

    /**具体信息**/
    private T data;
}
