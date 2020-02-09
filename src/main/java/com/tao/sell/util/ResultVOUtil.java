package com.tao.sell.util;

import com.tao.sell.VO.ResultVO;

/**
 * @BelongsProject: sell
 * @BelongsPackage: com.tao.sell.util
 * @Author: Administrator
 * @CreateTime: 2020-02-07 10:58
 */
public class ResultVOUtil {
    public static ResultVO success(Object obj){
        ResultVO resultVO=new ResultVO();
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        resultVO.setData(obj);

        return  resultVO;
    }

    //无参
    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
         return  resultVO;
    }
}
