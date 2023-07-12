import com.nwa.mapper.AdHomeMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class TestA {
    @Resource
    private AdHomeMapper adHomeMapper;
    String Path = "E:\\LuckyWorckSpace\\weeklyApi\\";

    //    private List<DemoData> data() {
//        List<DemoData> list = ListUtils.newArrayList();
//        for (int i = 0; i < 10; i++) {
//            DemoData data = new DemoData();
//            data.setString("字符串" + i);
//            data.setDate(new Date());
//            data.setDoubleData(0.56);
//            list.add(data);
//        }
//        return list;
//    }
//    @Test
//    public void simpleWrite() {
//        String fileName = Path+"easyTest.xlsx";
//        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
//
//    }
//
//
//    @Test
//    public void simpleRead() {
//
//        String fileName = Path+"easyTest.xlsx";
//
//        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
//
//    }
//    @Test
//    public void load() throws IOException {
//        MyPlus myPlus = new MyPlus();
//        Client client = new Client();
//        Excel.simpleRead(myPlus,client);
//    }

    @Test
    public void simpleRead() throws IOException {

        String fileName = Path + "easyTest.xls";

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
            //星期一到日
            sheet.createRow(5 * i - 4).createCell(0).setCellValue("星期" + i);
            sheet.getRow(5 * i - 4).getCell(0).setCellStyle(cellStyle);
//            sheet.getRow(5*i-4).createCell(1).setCellValue("2023-02-27");//日期位置
            sheet.getRow(5 * i - 4).createCell(1).setCellStyle(cellStyle);//日期位置
            sheet.createRow(5 * i - 3).createCell(3).setCellValue("上午");
            sheet.createRow(5 * i - 2).createCell(3).setCellValue("下午");
            sheet.createRow(5 * i - 1);
        }
//-----------------------------------------------------------------------------------------------------
        //星期1的部分 A1代表星期一的第一行
//        HSSFRow rowA1 = sheet.createRow(1);
//        HSSFCell cellA1 = rowA1.createCell(0);
//        cellA1.setCellValue("星期一");
//        cellA1.setCellStyle(cellStyle);	// 应用于单元格居中
//        rowA1.createCell(1).setCellValue("2023-02-27");
//        rowA1.getCell(1).setCellStyle(cellStyle);	// 应用于单元格居中
//        HSSFRow rowA2 = sheet.createRow(2);
//        HSSFRow rowA3 = sheet.createRow(3);
//        HSSFRow rowA4 = sheet.createRow(4);
//        rowA2.createCell(3).setCellValue("上午");
//        rowA3.createCell(3).setCellValue("上午");
//        rowA1.createCell(4).setCellValue("上午事情1");
//        rowA2.createCell(4).setCellValue("上午事情2");
//        rowA3.createCell(4).setCellValue("下午事情1");
//        rowA4.createCell(4).setCellValue("下午事情2");
//        rowA1.createCell(10).setCellValue("完成");
//        rowA2.createCell(10).setCellValue("未完成");
//        rowA3.createCell(10).setCellValue("完成");
//        rowA4.createCell(10).setCellValue("未完成");
//        rowA1.createCell(11).setCellValue("上午结果分析1");
//        rowA2.createCell(11).setCellValue("上午结果分析2");
//        rowA3.createCell(11).setCellValue("下午结果分析1");
//        rowA4.createCell(11).setCellValue("下午结果分析2");
//
//
////-----------------------------------------------------------------------------------------------------
// //星期2的部分
//        HSSFRow rowB6 = sheet.createRow(6);
//        HSSFCell cellB1 = rowB6.createCell(0);
//        cellB1.setCellValue("星期二");
//        cellB1.setCellStyle(cellStyle);	// 应用于单元格居中
//        rowB6.createCell(1).setCellValue("2023-02-27");
//        rowB6.getCell(1).setCellStyle(cellStyle);	// 应用于单元格居中
//        HSSFRow rowB7 = sheet.createRow(7);
//        HSSFRow rowB8 = sheet.createRow(8);
//        HSSFRow rowB9 = sheet.createRow(9);
//        rowB7.createCell(3).setCellValue("上午");
//        rowB8.createCell(3).setCellValue("上午");
//        rowB6.createCell(4).setCellValue("上午事情1");
//        rowB7.createCell(4).setCellValue("上午事情2");
//        rowB8.createCell(4).setCellValue("下午事情1");
//        rowB9.createCell(4).setCellValue("下午事情2");
//        rowB6.createCell(10).setCellValue("完成");
//        rowB7.createCell(10).setCellValue("未完成");
//        rowB8.createCell(10).setCellValue("完成");
//        rowB9.createCell(10).setCellValue("未完成");
//        rowB6.createCell(11).setCellValue("上午结果分析1");
//        rowB7.createCell(11).setCellValue("上午结果分析2");
//        rowB8.createCell(11).setCellValue("下午结果分析1");
//        rowB9.createCell(11).setCellValue("下午结果分析2");


        //生成一张表io，03版本是xls结尾
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        workbook.write(fileOutputStream);
        fileOutputStream.close();
        log.info("表格生成成功！");

    }


    @Test
    public void sRead() throws IOException {

        String fileName = Path + "easyTest.xls";
        //创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //设置它的样式
        HSSFSheet sheet = workbook.createSheet("周报表");
        // 创建一个行,0就是第一行一般都是表头,给row加列就是第一行的每一列了
        HSSFRow row = sheet.createRow(0);
        //创建表头
        HSSFCell cell1 = row.createCell(0);
        cell1.setCellValue("周时间");
        HSSFCell cell2 = row.createCell(1);
        cell2.setCellValue("日期");

        HSSFRow row2 = sheet.createRow(1);
        //创建表头
        HSSFCell cell12 = row2.createCell(0);
        cell12.setCellValue("11111");
        HSSFCell cell22 = row2.createCell(1);
        cell22.setCellValue("sssssz");
        //生成一张表io，03版本是xls结尾
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        log.info("表格生成成功！");
    }

    @Test
    public void Test23() {

    }
}
