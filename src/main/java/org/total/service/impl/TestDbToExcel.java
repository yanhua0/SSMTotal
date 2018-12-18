package org.total.service.impl;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import mybatis.dao.UserMapper;
import mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class TestDbToExcel {
    @Autowired
    private UserMapper userMapper;
    public  void main() {
        try {
            WritableWorkbook wwb = null;

            // 创建可写入的Excel工作簿
            String fileName = "E://book.xls";//路径
            File file=new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //以fileName为文件名来创建一个Workbook
            wwb = Workbook.createWorkbook(file);

            // 创建工作表
            WritableSheet ws = wwb.createSheet("Test Shee 1", 0);

            //查询数据库中所有的数据

            List<User> list= userMapper.findAll();
            //要插入到的Excel表格的行号，默认从0开
            Label labelId= new Label(0, 0, "编号(id)");//表示第
            Label labelName= new Label(1, 0, "密碼(name)");
            Label labelSex= new Label(2, 0, "電話(sex)");
            Label labelNum= new Label(3, 0, "時間(num)");

            ws.addCell(labelId);
            ws.addCell(labelName);
            ws.addCell(labelSex);
            ws.addCell(labelNum);
            //i表示行数依次生成
            for (int i = 0; i < list.size(); i++) {

                Label labelId_i= new Label(0, i+1, list.get(i).getUsername()+"");
                Label labelName_i= new Label(1, i+1, list.get(i).getPassword());
                Label labelSex_i= new Label(2, i+1, list.get(i).getPhone());
                Label labelNum_i= new Label(3, i+1, list.get(i).getCreateTime()+"");
                ws.addCell(labelId_i);
                ws.addCell(labelName_i);
                ws.addCell(labelSex_i);
                ws.addCell(labelNum_i);
            }

            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            wwb.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
