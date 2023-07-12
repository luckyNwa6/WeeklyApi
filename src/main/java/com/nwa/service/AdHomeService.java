package com.nwa.service;


import com.nwa.bean.Client;
import com.nwa.bean.MyPlus;
import com.nwa.bean.ResultVO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;


public interface AdHomeService {


    ResultVO modifyPwd(String userAcc, String newPassword, String oldPassword);

    ResultVO getLogList(int userId, int page, int limit);

    ResultVO getMyWeekList(String months, String id, int page, int limit);

    ResultVO getMyWeek(String monthsId);

    ResultVO keepMyWeekly(MyPlus myPlus);


    ResultVO delMyWeekOne(int idOne);

    ResultVO delMyWeekMore(String[] list);

    ResultVO addOneMon(Client client);

    ResultVO addOneWeek(MyPlus myPlus);

    String export(String monthsId, HttpServletResponse response) throws IOException, ParseException;
}
