package com.neusoft.springbootsell.exception;

import com.neusoft.springbootsell.enums.ResultEnum;
import lombok.Getter;

@Getter
public class AdminException extends RuntimeException{
    private Integer code;

    public  AdminException  (ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}
