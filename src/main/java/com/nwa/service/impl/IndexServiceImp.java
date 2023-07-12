package com.nwa.service.impl;

import com.nwa.bean.Client;
import com.nwa.bean.ResultVO;
import com.nwa.mapper.IndexMapper;
import com.nwa.service.IndexService;
import com.nwa.until.JWTUtils;
import com.nwa.until.ResStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class IndexServiceImp implements IndexService {
    @Resource
    private IndexMapper indexMapper;
    public ResultVO resultVO;

    /**
     * 登录
     * @param acc
     * @param pwd
     * @return
     */
    @Override
    public ResultVO login(String acc, String pwd) {
        Client client = indexMapper.login(acc, pwd);
        if (client != null) {
            String token = JWTUtils.token(acc, pwd);
            client.setToken(token);

            resultVO = new ResultVO(ResStatus.OK, "登录成功", client);
        } else {
            resultVO = new ResultVO(ResStatus.FAIL, "登录失败", null);
        }
        return resultVO;
    }

}
