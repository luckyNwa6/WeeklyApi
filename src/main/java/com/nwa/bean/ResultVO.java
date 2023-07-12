package com.nwa.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResultVO {
    @ApiModelProperty("状态码")
    private int code;
    @ApiModelProperty("提示信息")
    private String msg;
    @ApiModelProperty("对象")
    private Object data;
    @ApiModelProperty("页数")
    private int count;


    public ResultVO(int code, String msg, int count, Object data) {
        this.code = code;
        this.data = data;
        this.count = count;
        this.msg = msg;
    }
    public ResultVO(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
