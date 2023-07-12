package com.nwa.until;/**
 * @Author Lucky友人a
 * @Date 2023/7/9 -13:26
 */

import com.nwa.bean.Client;
import com.nwa.bean.MyPlus;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author Lucky友人a
 * @Date 2023/7/9 -13:26
 */
public class Excel {
    public static String simpleRead(HttpServletResponse response, MyPlus myPlus, Client client) throws IOException, ParseException {
//        String p = "D:\\workspace\\JavaSpace\\weeklyA-master\\";
        String l = "target/classes/static/files/";
        String fileName = "周报" + new SimpleDateFormat("yyyy-MM-dd").format(client.getMonday()) + "至" + new SimpleDateFormat("yyyy-MM-dd").format(client.getSunday()) + ".xls";
        response.reset();
        //设置响应头，
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        response.setContentType("application/msexcel");
        //创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //设置它的样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);//增加水平居中样式-old
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//增加垂直居中样式-old
        //创建工作表
        HSSFSheet sheet = workbook.createSheet("周报表");
        // 创建一个行,0就是第一行一般都是表头,给row加列就是第一行的每一列了
        HSSFRow row = sheet.createRow(0);
        //创建表头
        HSSFCell cell1 = row.createCell(0);
        cell1.setCellValue("周时间");
        HSSFCell cell2 = row.createCell(1);
        cell2.setCellValue("日期");
        sheet.addMergedRegion(new CellRangeAddress(
                0,  // 第一行（从0开始）
                0,  // 最后一行（从0开始）
                1,  // 第一列（从0开始）
                2  // 最后一列（从0开始）
        ));
        cell2.setCellStyle(cellStyle);    // 应用于单元格居中
        HSSFCell cell4 = row.createCell(3);
        cell4.setCellValue("时间");
        HSSFCell cell5 = row.createCell(4);
        cell5.setCellValue("具体事宜");
        sheet.addMergedRegion(new CellRangeAddress(
                0,  // 第一行（从0开始）
                0,  // 最后一行（从0开始）
                4,  // 第一列（从0开始）
                9  // 最后一列（从0开始）
        ));
        cell5.setCellStyle(cellStyle);    // 应用于单元格居中
        HSSFCell cell6 = row.createCell(10);
        cell6.setCellValue("标记");
        HSSFCell cell7 = row.createCell(11);
        cell7.setCellValue("结果分析");
        sheet.addMergedRegion(new CellRangeAddress(
                0,  // 第一行（从0开始）
                0,  // 最后一行（从0开始）
                11,  // 第一列（从0开始）
                16  // 最后一列（从0开始）
        ));
        cell7.setCellStyle(cellStyle);    // 应用于单元格居中
        //表头结束
        //绘制合并有规律的单元格
//-----------------------------------------------------------------------------------------------------
        for (int i = 1; i <= 7; i++) {   //合并有规律的单元格
            sheet.addMergedRegion(new CellRangeAddress(
                    5 * i - 4,  // 第一行（从0开始）
                    5 * i - 1,  // 最后一行（从0开始）
                    0,  // 第一列（从0开始）
                    0  // 最后一列（从0开始）
            ));
            sheet.addMergedRegion(new CellRangeAddress(
                    5 * i - 4,  // 第一行（从0开始）
                    5 * i - 1,  // 最后一行（从0开始）
                    1,  // 第一列（从0开始）
                    2  // 最后一列（从0开始）
            ));

            sheet.addMergedRegion(new CellRangeAddress(
                    5 * i - 4,  // 第一行（从0开始）
                    5 * i - 4,  // 最后一行（从0开始）
                    4,  // 第一列（从0开始）
                    9  // 最后一列（从0开始）
            ));
            sheet.addMergedRegion(new CellRangeAddress(
                    5 * i - 3,  // 第一行（从0开始）
                    5 * i - 3,  // 最后一行（从0开始）
                    4,  // 第一列（从0开始）
                    9  // 最后一列（从0开始）
            ));
            sheet.addMergedRegion(new CellRangeAddress(
                    5 * i - 2,  // 第一行（从0开始）
                    5 * i - 2,  // 最后一行（从0开始）
                    4,  // 第一列（从0开始）
                    9  // 最后一列（从0开始）
            ));
            sheet.addMergedRegion(new CellRangeAddress(
                    5 * i - 1,  // 第一行（从0开始）
                    5 * i - 1,  // 最后一行（从0开始）
                    4,  // 第一列（从0开始）
                    9  // 最后一列（从0开始）
            ));
            sheet.addMergedRegion(new CellRangeAddress(
                    5 * i - 4,  // 第一行（从0开始）
                    5 * i - 4,  // 最后一行（从0开始）
                    11,  // 第一列（从0开始）
                    16  // 最后一列（从0开始）
            ));
            sheet.addMergedRegion(new CellRangeAddress(
                    5 * i - 3,  // 第一行（从0开始）
                    5 * i - 3,  // 最后一行（从0开始）
                    11,  // 第一列（从0开始）
                    16  // 最后一列（从0开始）
            ));
            sheet.addMergedRegion(new CellRangeAddress(
                    5 * i - 2,  // 第一行（从0开始）
                    5 * i - 2,  // 最后一行（从0开始）
                    11,  // 第一列（从0开始）
                    16  // 最后一列（从0开始）
            ));
            sheet.addMergedRegion(new CellRangeAddress(
                    5 * i - 1,  // 第一行（从0开始）
                    5 * i - 1,  // 最后一行（从0开始）
                    11,  // 第一列（从0开始）
                    16  // 最后一列（从0开始）
            ));

            //合并1-2之间的单元格
            sheet.addMergedRegion(new CellRangeAddress(
                    5 * i,  // 第一行（从0开始）
                    5 * i,  // 最后一行（从0开始）
                    0,  // 第一列（从0开始）
                    16  // 最后一列（从0开始）
            ));

//周1-日可以绘制的部分
            String weekDay = (i == 1) ? "星期一" :
                    (i == 2) ? "星期二" :
                            (i == 3) ? "星期三" :
                                    (i == 4) ? "星期四" :
                                            (i == 5) ? "星期五" :
                                                    (i == 6) ? "星期六" :
                                                            "星期日";

            sheet.createRow(5 * i - 4).createCell(0).setCellValue(weekDay);
            sheet.getRow(5 * i - 4).getCell(0).setCellStyle(cellStyle); //设置星期一居中
            sheet.getRow(5 * i - 4).createCell(1).setCellStyle(cellStyle);//日期位置
            sheet.createRow(5 * i - 3).createCell(3).setCellValue("上午");
            sheet.createRow(5 * i - 2).createCell(3).setCellValue("下午");
            sheet.createRow(5 * i - 1);

        }
//-----------------------------------------------------------------------------------------------------
        //星期1的赋值

        sheet.getRow(1).getCell(1).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(client.getMonday()));

        sheet.getRow(1).createCell(4).setCellValue(myPlus.getMonMoA1());
        sheet.getRow(2).createCell(4).setCellValue(myPlus.getMonMoA2());
        sheet.getRow(3).createCell(4).setCellValue(myPlus.getMonAfA1());
        sheet.getRow(4).createCell(4).setCellValue(myPlus.getMonAfA2());

        sheet.getRow(1).createCell(10).setCellValue(myPlus.getMonMoA1S());
        sheet.getRow(2).createCell(10).setCellValue(myPlus.getMonMoA2S());
        sheet.getRow(3).createCell(10).setCellValue(myPlus.getMonMoA1S());
        sheet.getRow(4).createCell(10).setCellValue(myPlus.getMonAfA2S());

        sheet.getRow(1).createCell(11).setCellValue(myPlus.getMonMoR1());
        sheet.getRow(2).createCell(11).setCellValue(myPlus.getMonMoR2());
        sheet.getRow(3).createCell(11).setCellValue(myPlus.getMonAfR1());
        sheet.getRow(4).createCell(11).setCellValue(myPlus.getMonAfR2());

//-----------------------------------------------------------------------------------------------------
        //星期2的部分


//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(client.getMonday());
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        // 获取结果
//        Date nextDay = calendar.getTime();
//        String formattedNextDay = new SimpleDateFormat("yyyy-MM-dd").format(nextDay);

        sheet.getRow(6).getCell(1).setCellValue(DateTimeUtils.addDate(client.getMonday(), 1));

        sheet.getRow(6).createCell(4).setCellValue(myPlus.getTuMoA1());
        sheet.getRow(7).createCell(4).setCellValue(myPlus.getTuMoA2());
        sheet.getRow(8).createCell(4).setCellValue(myPlus.getTuAfA1());
        sheet.getRow(9).createCell(4).setCellValue(myPlus.getTuAfA2());

        sheet.getRow(6).createCell(10).setCellValue(myPlus.getTuMoA1S());
        sheet.getRow(7).createCell(10).setCellValue(myPlus.getTuMoA2S());
        sheet.getRow(8).createCell(10).setCellValue(myPlus.getTuAfA1S());
        sheet.getRow(9).createCell(10).setCellValue(myPlus.getTuAfA2S());

        sheet.getRow(6).createCell(11).setCellValue(myPlus.getTuMoR1());
        sheet.getRow(7).createCell(11).setCellValue(myPlus.getTuMoR2());
        sheet.getRow(8).createCell(11).setCellValue(myPlus.getTuAfR1());
        sheet.getRow(9).createCell(11).setCellValue(myPlus.getTuAfR2());
//-----------------------------------------------------------------------------------------------------
        //星期3的部分
        sheet.getRow(11).getCell(1).setCellValue(DateTimeUtils.addDate(client.getMonday(), 2));

        sheet.getRow(11).createCell(4).setCellValue(myPlus.getWeMoA1());
        sheet.getRow(12).createCell(4).setCellValue(myPlus.getWeMoA2());
        sheet.getRow(13).createCell(4).setCellValue(myPlus.getWeAfA1());
        sheet.getRow(14).createCell(4).setCellValue(myPlus.getWeAfA2());

        sheet.getRow(11).createCell(10).setCellValue(myPlus.getWeMoA1S());
        sheet.getRow(12).createCell(10).setCellValue(myPlus.getWeMoA2S());
        sheet.getRow(13).createCell(10).setCellValue(myPlus.getWeAfA1S());
        sheet.getRow(14).createCell(10).setCellValue(myPlus.getWeAfA2S());

        sheet.getRow(11).createCell(11).setCellValue(myPlus.getWeMoR1());
        sheet.getRow(12).createCell(11).setCellValue(myPlus.getWeMoR2());
        sheet.getRow(13).createCell(11).setCellValue(myPlus.getWeAfR1());
        sheet.getRow(14).createCell(11).setCellValue(myPlus.getWeAfR2());

//-----------------------------------------------------------------------------------------------------
//            //星期4的部分
        sheet.getRow(16).getCell(1).setCellValue(DateTimeUtils.addDate(client.getMonday(), 3));

        sheet.getRow(16).createCell(4).setCellValue(myPlus.getThMoA1());
        sheet.getRow(17).createCell(4).setCellValue(myPlus.getThMoA2());
        sheet.getRow(18).createCell(4).setCellValue(myPlus.getThAfA1());
        sheet.getRow(19).createCell(4).setCellValue(myPlus.getThAfA2());

        sheet.getRow(16).createCell(10).setCellValue(myPlus.getThMoA1S());
        sheet.getRow(17).createCell(10).setCellValue(myPlus.getThMoA2S());
        sheet.getRow(18).createCell(10).setCellValue(myPlus.getThAfA1S());
        sheet.getRow(19).createCell(10).setCellValue(myPlus.getThAfA2S());

        sheet.getRow(16).createCell(11).setCellValue(myPlus.getThMoR1());
        sheet.getRow(17).createCell(11).setCellValue(myPlus.getThMoR1());
        sheet.getRow(18).createCell(11).setCellValue(myPlus.getThAfR1());
        sheet.getRow(19).createCell(11).setCellValue(myPlus.getThAfR2());
////-----------------------------------------------------------------------------------------------------
//            //星期5的部分
        sheet.getRow(21).getCell(1).setCellValue(DateTimeUtils.addDate(client.getMonday(), 4));

        sheet.getRow(21).createCell(4).setCellValue(myPlus.getFrMoA1());
        sheet.getRow(22).createCell(4).setCellValue(myPlus.getFrMoA2());
        sheet.getRow(23).createCell(4).setCellValue(myPlus.getFrAfA1());
        sheet.getRow(24).createCell(4).setCellValue(myPlus.getFrAfA2());

        sheet.getRow(21).createCell(10).setCellValue(myPlus.getFrMoA1S());
        sheet.getRow(22).createCell(10).setCellValue(myPlus.getFrMoA2S());
        sheet.getRow(23).createCell(10).setCellValue(myPlus.getFrAfA1S());
        sheet.getRow(24).createCell(10).setCellValue(myPlus.getFrAfA2S());

        sheet.getRow(21).createCell(11).setCellValue(myPlus.getFrMoR1());
        sheet.getRow(22).createCell(11).setCellValue(myPlus.getFrMoR2());
        sheet.getRow(23).createCell(11).setCellValue(myPlus.getFrAfR1());
        sheet.getRow(24).createCell(11).setCellValue(myPlus.getFrAfR2());
////-----------------------------------------------------------------------------------------------------
//            //星期6的部分
        sheet.getRow(26).getCell(1).setCellValue(DateTimeUtils.addDate(client.getSunday(), -1));

        sheet.getRow(26).createCell(4).setCellValue(myPlus.getSaMoA1());
        sheet.getRow(27).createCell(4).setCellValue(myPlus.getSaMoA2());
        sheet.getRow(28).createCell(4).setCellValue(myPlus.getSaAfA1());
        sheet.getRow(29).createCell(4).setCellValue(myPlus.getSaAfA2());

        sheet.getRow(26).createCell(10).setCellValue(myPlus.getSaMoA1S());
        sheet.getRow(27).createCell(10).setCellValue(myPlus.getSaMoA2S());
        sheet.getRow(28).createCell(10).setCellValue(myPlus.getSaAfA1S());
        sheet.getRow(29).createCell(10).setCellValue(myPlus.getSaAfA2S());

        sheet.getRow(26).createCell(11).setCellValue(myPlus.getSaMoR1());
        sheet.getRow(27).createCell(11).setCellValue(myPlus.getSaMoR2());
        sheet.getRow(28).createCell(11).setCellValue(myPlus.getSaAfR1());
        sheet.getRow(29).createCell(11).setCellValue(myPlus.getSaAfR2());
//
////-----------------------------------------------------------------------------------------------------
//            //星期7的部分
        sheet.getRow(31).getCell(1).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(client.getSunday()));

        sheet.getRow(31).createCell(4).setCellValue(myPlus.getSuMoA1());
        sheet.getRow(32).createCell(4).setCellValue(myPlus.getSuMoA2());
        sheet.getRow(33).createCell(4).setCellValue(myPlus.getSuAfA1());
        sheet.getRow(34).createCell(4).setCellValue(myPlus.getSuAfA2());

        sheet.getRow(31).createCell(10).setCellValue(myPlus.getSuMoA1S());
        sheet.getRow(32).createCell(10).setCellValue(myPlus.getSuMoA2S());
        sheet.getRow(33).createCell(10).setCellValue(myPlus.getSuAfA1S());
        sheet.getRow(34).createCell(10).setCellValue(myPlus.getSuAfA2S());

        sheet.getRow(31).createCell(11).setCellValue(myPlus.getSuMoR1());
        sheet.getRow(32).createCell(11).setCellValue(myPlus.getSuMoR2());
        sheet.getRow(33).createCell(11).setCellValue(myPlus.getSuAfR1());
        sheet.getRow(34).createCell(11).setCellValue(myPlus.getSuAfR2());
//
//-----------------------------------------------------------------------------------------------------


//生成一张表io，03版本是xls结尾,这里生成到后端本地了--------------------------------------------------------
        FileOutputStream fileOutputStream = new FileOutputStream(l + fileName);
        workbook.write(fileOutputStream);
        fileOutputStream.close();

        File savePos = new File("src/main/resources/static/");
        String canonicalPath = savePos.getCanonicalPath();
        System.out.println("路径是" + canonicalPath);//这是存到本地项目里的路径
        FileOutputStream fileOutputStream2 = new FileOutputStream(canonicalPath + "/files/" + "周报" + new SimpleDateFormat("yyyy-MM-dd").format(client.getMonday()) + "至" + new SimpleDateFormat("yyyy-MM-dd").format(client.getSunday()) + ".xls");
        workbook.write(fileOutputStream2);
        fileOutputStream.close();
        System.out.println("文件上传成功了，路径是:Http://localhost:9999/" + fileName);
        return "Http://localhost:9999/static/files/" + fileName;
        //输出Excel文件输出到前端
//                OutputStream output = response.getOutputStream();
//                workbook.write(output);
//                output.close();

    }


}
