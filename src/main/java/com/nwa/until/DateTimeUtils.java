package com.nwa.until;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author Lucky友人a
 * @Date 2023/7/11 -16:13
 */


public class DateTimeUtils {
    //日期增加，输入的参数是date型的1999-03-27这种
    public static String addDate(Date Day, int variable) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Day);
        calendar.add(Calendar.DAY_OF_MONTH, variable);
        // 获取结果
        Date nextDay = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(nextDay);

    }

}
