package com.nwa.controller;


import com.alibaba.fastjson2.JSONObject;
import com.nwa.aop.SysLog;
import com.nwa.bean.ResultVO;
import com.nwa.service.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("index")
@RestController
@Api(value = "提供了后台登录页面接口", tags = "后台登录页面接口")
public class IndexController {
    @Resource
    private IndexService indexService;

    //接受参数办法1
//    @SysLog(operationType = "admin",operationName = "登录成功",value = "200")
//    @PostMapping("/login")
//    public ResultVO loginHome(Client client) {
//        return indexService.login(String.valueOf(client.getUserAcc()), client.getUserPwd());
//    }
    //接受参数办法2
    @SysLog(operationType = "admin", operationName = "登录成功", value = "200") //自定义注解来获取日志
    @PostMapping("/login")
    @ApiOperation("后台用户登录接口")//文档里接口的说明
    public ResultVO loginHome(@RequestBody JSONObject obj) {
        String userAcc = obj.getString("userAcc");
//        List<String> ids = obj.getList("ids",String.class);
////        Date date = obj.getDate("date");
        String userPwd = obj.getString("userPwd");
        return indexService.login(userAcc, userPwd);
    }

}
