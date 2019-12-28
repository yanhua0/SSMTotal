package org.total.util;

import jxl.Sheet;
import jxl.Workbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelUtils {
    public static List<List<String>> getList(String filePath) {
        try {
            List<List<String>> list = new ArrayList<>();
            List<String> object = new ArrayList<>();
            File file = new File(filePath);
            String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            if (suffix.equals("xls")) {
                // 创建输入流，读取Excel
                InputStream is = new FileInputStream(file.getAbsolutePath());
                // jxl提供的Workbook类
                Workbook wb = Workbook.getWorkbook(is);
                // Excel的页签数量
                int sheet_size = wb.getNumberOfSheets();
                for (int index = 0; index < sheet_size; index++) {
                    List<List> outerList = new ArrayList<List>();
                    // 每个页签创建一个Sheet对象
                    Sheet sheet = wb.getSheet(index);
                    int cols = sheet.getColumns();
                    // sheet.getRows()返回该页的总行数，第二行开始
                    for (int i = 1; i < sheet.getRows(); i++) {
                        for (int j = 0; j < cols; j++) {
                            object.add(sheet.getCell(j, i).getContents());
                        }
                        // Nk nk = new Nk(sheet.getCell(0, i).getContents(), sheet.getCell(1, i).getContents(), sheet.getCell(2, i).getContents(),sheet.getCell(3, i).getContents(),sheet.getCell(4, i).getContents(),sheet.getCell(5, i).getContents(),sheet.getCell(6, i).getContents());
                        list.add(object);
                    }
                }
            } else if (suffix.equals("xlsx")) {
                InputStream is = new FileInputStream(file);
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
                // 获取每一个工作薄
                for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                    XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                    if (xssfSheet == null) {
                        continue;
                    }
                    // 获取当前工作薄的每一行，第2行开始
                    for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                        XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                        for (int col = 0; col < xssfSheet.getRow(rowNum).getPhysicalNumberOfCells(); col++) {
                            XSSFCell xssfCell = xssfRow.getCell(col);
                            xssfCell.setCellType(CellType.STRING);
                            object.add(xssfCell.getStringCellValue());
                        }
                        list.add(object);
                        object=new ArrayList<>();
                    }
                }

            }
            return list;
        } catch (Exception e) {
          e.printStackTrace();
        }
        return new ArrayList<>();
    }

}

