package com.nwa.mapper;

import com.nwa.bean.Client;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexMapper {
    Client login(@Param("acc") String acc, @Param("pwd") String pwd);

}
