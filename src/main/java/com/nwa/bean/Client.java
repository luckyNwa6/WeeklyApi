package com.nwa.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Client {

    @ApiModelProperty("用户id")
    private int userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("令牌")
    private String token;

    @ApiModelProperty("用户账号")
    private int userAcc;

    @JsonIgnore
    @ApiModelProperty("用户密码")
    private String userPwd;

    @ApiModelProperty("角色Id")
    private int roleId;

    @ApiModelProperty("ip")
    private String requestIp;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("操作系统")
    private String logSys;

    @ApiModelProperty("创建日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;


    @ApiModelProperty("浏览器")
    private String logBrowser;

    @ApiModelProperty("日志提示")
    private String logTip;


    @ApiModelProperty("月份id")
    private int id;
    @ApiModelProperty("月份")
    private String months;
    @ApiModelProperty("第几周")
    private int weekNum;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("星期一")
    private Date monday;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("星期日")
    private Date sunday;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("状态")
    private int state;


}
