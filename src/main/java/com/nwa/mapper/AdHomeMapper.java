package com.nwa.mapper;


import com.nwa.bean.Client;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdHomeMapper  {

    List<Client> personShow(@Param("acc") String acc);

    int modifyPwd(@Param("acc") String userAcc,@Param("pwd") String newPassword);

    List<Client> getLogList(@Param("userId") int  userId);

    List<Client> getMyWeekList(@Param("months") String months,@Param("id") String id);

    Client getMyWeek(@Param("id") String months);

    int keepMyWeekly(Client client);

    int delMyWeekOne(@Param("id") int idOne);

    int delMyWeekMore(String[] list);

    int addOneMon(Client client);
}
