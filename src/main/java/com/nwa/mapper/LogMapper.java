package com.nwa.mapper;

import com.nwa.bean.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper {

    void save(Client client);
}
