package com.tao.sell.exception;

import com.tao.sell.enums.ResultEnums;

public class SellException extends  RuntimeException {
    private Integer code;

    public SellException(ResultEnums resultEnums){
        super(resultEnums.getMessage());

        this.code=resultEnums.getCode();
    }
}
