package com.nwa.controller;

import com.nwa.aop.SysLog;
import com.nwa.bean.Client;
import com.nwa.bean.MyPlus;
import com.nwa.bean.ResultVO;
import com.nwa.service.AdHomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@RequestMapping("/home")
@RestController
@Api(value = "提供了后台主页面的各种接口", tags = "后台主页面接口")
@Slf4j
public class AdHomeController {
    @Resource
    private AdHomeService adHomeService;

    @ApiOperation("修改密码")//这是swagger里功能的描述
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "userAcc", value = "账号", required = true),
            @ApiImplicitParam(dataType = "string", name = "newPassword", value = "新密码", required = true),
            @ApiImplicitParam(dataType = "string", name = "newPassword", value = "老密码", required = true),
    })//这里是swagger里面的属性描述
    @PutMapping("/modifyPwd") //符合RESTFUL接口风格
    @SysLog(operationType = "用户操作", operationName = "修改密码", value = "200")  //基于aop的自定义注解
    public ResultVO modifyPwd(String userAcc, String newPassword, String oldPassword) {
        return adHomeService.modifyPwd(userAcc, newPassword, oldPassword);
    }

    @ApiOperation("日志列表")
    @GetMapping("/getLogList")
    @SysLog(operationType = "用户操作", operationName = "获取日志列表", value = "200")
    public ResultVO getLogList(int userId, int page,
                               int limit) {
        return adHomeService.getLogList(userId, page, limit);
    }

    @ApiOperation("我的周报列表")
    @GetMapping("/getMyWeekList")
    @SysLog(operationType = "用户操作", operationName = "获取周报列表", value = "200")
    public ResultVO getMyWeekList(String months, String id, int page,
                                  int limit) {
        return adHomeService.getMyWeekList(months, id, page, limit);
    }

    @ApiOperation("周报详情")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "monthsId", value = "对应月份表里的主键", required = true)
    })
    @GetMapping("/getMyWeek")
    @SysLog(operationType = "用户操作", operationName = "获取周报详情", value = "200")
    public ResultVO getMyWeek(String monthsId) {
        return adHomeService.getMyWeek(monthsId);
    }

    @ApiOperation("周报保存")
    @PostMapping("/keepMyWeekly")
    @SysLog(operationType = "用户操作", operationName = "周报保存", value = "200")
    public ResultVO keepMyWeekly(MyPlus myPlus) {
        return adHomeService.keepMyWeekly(myPlus);
    }


    //先将月份表那边添加成功再添加周报的
    @ApiOperation("周报月份新增")
    @GetMapping("/addOneMon")
    @SysLog(operationType = "用户操作", operationName = "addOneMon", value = "200")
    public ResultVO addOneMon(String months, String weekNum, String monday, String sunday) throws ParseException {
        Client client = new Client();
        client.setMonths(months);
        client.setWeekNum(Integer.valueOf(weekNum));
        client.setMonday(new SimpleDateFormat("yyyy-MM-dd").parse(monday));
        client.setSunday(new SimpleDateFormat("yyyy-MM-dd").parse(sunday));
        return adHomeService.addOneMon(client);
    }

    @ApiOperation("周报添加")
    @PostMapping("/addOneWeek")
    @SysLog(operationType = "用户操作", operationName = "周报添加", value = "200")
    public ResultVO addOneWeek(MyPlus myPlus) {
        log.info(String.valueOf(myPlus));
        return adHomeService.addOneWeek(myPlus);
    }

    @ApiOperation("周报删除")
    @DeleteMapping("/delMyWeekOne")
    @SysLog(operationType = "用户操作", operationName = "周报删除", value = "200")
    public ResultVO delMyWeekOne(int idOne) {
        return adHomeService.delMyWeekOne(idOne);
    }

    //批量删除,过来的数据1,2,3这种。这个实现了上面个就没用了
    @ApiOperation("周报批量删除")
    @DeleteMapping("/delMyWeekMore")
    @SysLog(operationType = "用户操作", operationName = "周报批量删除", value = "200")
    public ResultVO delMyWeekMore(String[] list) {
        return adHomeService.delMyWeekMore(list);
    }


    @ApiOperation("excel导出")
    @GetMapping("/export")
    @SysLog(operationType = "用户操作", operationName = "excel导出", value = "200")
    public String export(String monthsId, HttpServletResponse response) throws IOException, ParseException {
        return adHomeService.export(monthsId, response);

    }
}
