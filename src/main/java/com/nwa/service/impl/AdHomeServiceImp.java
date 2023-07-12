package com.nwa.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwa.bean.Client;
import com.nwa.bean.MyPlus;
import com.nwa.bean.ResultVO;
import com.nwa.mapper.AdHomeMapper;
import com.nwa.mapper.IndexMapper;
import com.nwa.mapper.MyPlusMapper;
import com.nwa.service.AdHomeService;
import com.nwa.until.Excel;
import com.nwa.until.ResStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Service
@Slf4j
public class AdHomeServiceImp implements AdHomeService {
    @Resource
    private AdHomeMapper adHomeMapper;
    @Resource
    private IndexMapper indexMapper;
    @Resource
    private MyPlusMapper myPlusMapper;
    public ResultVO resultVO;

    /**
     * 修改密码
     * @param userAcc
     * @param newPassword
     * @param oldPassword
     * @return
     */
    @Transactional
    @Override
    public ResultVO modifyPwd(String userAcc, String newPassword, String oldPassword) {
        Client login = indexMapper.login(userAcc, oldPassword);
        if (login != null) {
            int a = adHomeMapper.modifyPwd(userAcc, newPassword);
            if (a > 0) {
                resultVO = new ResultVO(ResStatus.OK, "密码修改成功!", null);
            } else {
                resultVO = new ResultVO(ResStatus.FAIL, "密码修改失败", null);
            }
        } else {
            resultVO = new ResultVO(ResStatus.FAIL, "密码修改失败", null);
        }
        return resultVO;
    }

    /**
     * 获取日志列表
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    @Override
    public ResultVO getLogList(int userId, int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Client> logs = adHomeMapper.getLogList(userId);
        if (logs != null) {
            PageInfo<Client> goodsTbPageInfo = new PageInfo<>(logs, 3);
            int count = (int) goodsTbPageInfo.getTotal();
            resultVO = new ResultVO(ResStatus.OK, "列表信息返回成功!", count, logs);
        }
        return resultVO;
    }

    /**
     * 获取周报列表
     * @param months
     * @param id
     * @param page
     * @param limit
     * @return
     */
    @Override
    public ResultVO getMyWeekList(String months, String id, int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Client> clientS = adHomeMapper.getMyWeekList(months, id);
        if (clientS != null) {
            PageInfo<Client> goodsTbPageInfo = new PageInfo<>(clientS, 3);
            int count = (int) goodsTbPageInfo.getTotal();
            resultVO = new ResultVO(ResStatus.OK, "列表信息返回成功!", count, clientS);
        }
        return resultVO;
    }

    /**
     * 获取详情周报
     * @param monthsId
     * @return
     */
    @Override
    public ResultVO getMyWeek(String monthsId) {

        QueryWrapper<MyPlus> wrapper = new QueryWrapper<>();
        //查询条件
        wrapper.eq("months_id", monthsId);
        // 查询的数据超过一条时，会抛出异常
        MyPlus user = myPlusMapper.selectOne(wrapper);
//        System.out.println(user);
//        Client client = adHomeMapper.getMyWeek(months);
        if (user != null) {
            resultVO = new ResultVO(ResStatus.OK, "列表信息返回成功!", user);
        }
        return resultVO;
    }

    /**
     * 保存周报
     * @param myPlus
     * @return
     */
    @Override
    public ResultVO keepMyWeekly(MyPlus myPlus) {
//        int a = adHomeMapper.keepMyWeekly(client);
        QueryWrapper<MyPlus> wrapper = new QueryWrapper<>();
        wrapper.eq("months_id", myPlus.getMonthsId()); //执行更新操作
        int result = myPlusMapper.update(myPlus, wrapper);
        System.out.println("result = " + result);
        if (result > 0) {
            resultVO = new ResultVO(ResStatus.OK, "修改成功!", null);
        }
        return resultVO;
    }

    /**
     * 普通删除
     * @param idOne
     * @return
     */
    @Override
    public ResultVO delMyWeekOne(int idOne) {
        int result = adHomeMapper.delMyWeekOne(idOne);
        if (result > 0) {
            resultVO = new ResultVO(ResStatus.OK, "删除成功!", null);
        }
        return resultVO;
    }

    /**
     * 批量删除
     * @param list
     * @return
     */
    @Override
    public ResultVO delMyWeekMore(String[] list) {

        int result = adHomeMapper.delMyWeekMore(list);
        if (result > 0) {
            resultVO = new ResultVO(ResStatus.OK, "删除成功!", null);
        }
        return resultVO;
    }

    /**
     * 添加月份数据
     * @param client
     * @return
     */
    @Override
    public ResultVO addOneMon(Client client) {
        int result = adHomeMapper.addOneMon(client);
        if (result > 0) {
            resultVO = new ResultVO(ResStatus.OK, "新增成功!", client);
            // 检索生成的 ID
//            int id = client.getId();
//            System.out.println("自增的id是"+id);//成功读取自增id
        }
        return resultVO;
    }

    /**
     * 添加周报
     * @param myPlus
     * @return
     */
    @Override
    public ResultVO addOneWeek(MyPlus myPlus) {

        int result = myPlusMapper.insert(myPlus);
        if (result > 0) {
            resultVO = new ResultVO(ResStatus.OK, "大量的数据保存成功2!", null);
        }
        return resultVO;
    }

    /**
     * 下载的数据在2张表里面所以需要事务,
     * @param monthsId
     * @param response
     * @return
     * @throws IOException
     * @throws ParseException
     */
    @Override
    @Transactional
    public String export(String monthsId, HttpServletResponse response) throws IOException, ParseException {

        List<Client> clientS = adHomeMapper.getMyWeekList("", monthsId);
        Client client = clientS.stream().filter(o -> o.getId() == Integer.valueOf(monthsId)).findFirst().get();
        log.info("进入下载！excel");
        QueryWrapper<MyPlus> wrapper = new QueryWrapper<>();

        wrapper.eq("months_id", monthsId);
        MyPlus myPlus = myPlusMapper.selectOne(wrapper);
        return Excel.simpleRead(response, myPlus, client);


    }


}
