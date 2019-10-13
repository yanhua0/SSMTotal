package org.total;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class InsertThread extends Thread{
    public void run(){
        String url = "jdbc:mysql://localhost:3306/shoponline"; //数据库连接地址
        String name = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "123456";//密码
        Connection conn = null;
        try {
            Class.forName(name);
            conn= DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);//关闭自动提交
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long begin=new Date().getTime();
        String sql= "INSERT INTO teachers (t_name,t_password,sex,description,pic_url,school_name,regist_date,remark) VALUES(?,?,?,?,?,?,?,?)";
        try {
            StringBuilder sqls= new StringBuilder();
            conn.setAutoCommit(false);
            PreparedStatement pst=conn.prepareStatement(sql);
            //编写事务
            for(int i=1;i<=10;i++){

                for(int j=1;j<=1000000;j++){
                    pst.setString(1,"teacher122");
                    pst.setString(2, "12223444");
                    pst.setString(3, "男");
                    pst.setString(4, "教师");
                    pst.setString(5, "www.bbb.com");
                    pst.setString(6, "java大学");
                    pst.setString(7, "2016-08-16 14:43:26");
                    pst.setString(8, "你好啊");
                    pst.addBatch();//批量添加信息
                }
                // 执行批量操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 结束时间
        Long end = new Date().getTime();
        // 耗时
        System.out.println("100万条数据插入花费时间 : " + (end - begin) / 1000 + " s"+"  插入完成");
    }

}
