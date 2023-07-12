package com.nwa.service.impl;

import com.nwa.bean.Client;
import com.nwa.mapper.LogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SysLogService {
    @Resource
    private LogMapper logMapper;

    /**
     * 保存日志
     * @param client
     * @return
     */
    public boolean save(Client client) {
//        log.info(client.getLogCreateBy());
        logMapper.save(client);
        return true;
    }
}
