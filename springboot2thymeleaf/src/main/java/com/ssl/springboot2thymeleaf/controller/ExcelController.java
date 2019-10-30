package com.ssl.springboot2thymeleaf.controller;

import com.ssl.springboot2thymeleaf.bean.User;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ExcelController {
    @RequestMapping("/export")
    public void exportExcel(HttpServletResponse response, HttpSession session, @RequestParam String name) throws Exception {

        String[] tableHeaders = {"id", "姓名", "年龄"};
        XSSFWorkbook workbook = new XSSFWorkbook();
/*        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        HSSFCellStyle cellStyle = workbook.createCellStyle();*/

        //切换成xlsx格式

        XSSFSheet sheet = workbook.createSheet("Sheet1");
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        Font font = workbook.createFont();
        //设置单元格颜色
        font.setColor(HSSFColor.RED.index);
        //设置加粗
//        font.setBold(true);
        cellStyle.setFont(font);

        // 将第一行的三个单元格给合并
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
//        HSSFRow row = sheet.createRow(0);
        XSSFRow row = sheet.createRow(0);
//        HSSFCell beginCell = row.createCell(0);
        XSSFCell beginCell = row.createCell(0);
        beginCell.setCellValue("通讯录");
        beginCell.setCellStyle(cellStyle);

        row = sheet.createRow(1);
        // 创建表头
        for (int i = 0; i < tableHeaders.length; i++) {
//            HSSFCell cell = row.createCell(i);
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(tableHeaders[i]);
            cell.setCellStyle(cellStyle);
        }

        List<User> users = new ArrayList<>();
        users.add(new User("jason", "男", 1));
        users.add(new User("water", "女", 2));
        users.add(new User("melon", "男", 3));

        for (int i = 0; i < users.size(); i++) {
            row = sheet.createRow(i + 2);
            User user = users.get(i);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getName());
            row.createCell(2).setCellValue(user.getGender());
            //设置行样式
            row.setRowStyle(cellStyle);

        }
        //列宽度自适应
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }
        String now = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        OutputStream outputStream = response.getOutputStream();
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        //文件名含有中文解码再重新编码
        response.setHeader("Content-disposition", "attachment;filename=" + new String((name + "_" + now).getBytes("UTF-8"), "ISO-8859-1") + ".xlsx");
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
