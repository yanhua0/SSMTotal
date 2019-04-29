package org.total.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTestUtil {
    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd");
        String str="11/12";
        Date dt=new Date();
       dt.setDate(30);
        System.out.println(dt.getDate());
        dt.setMonth(12);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
//        rightNow.add(Calendar.YEAR,-1);//日期减1年
//        rightNow.add(Calendar.MONTH,3);//日期加3个月
        rightNow.add(Calendar.DAY_OF_YEAR,1);//日期加10天
        Date dt1=rightNow.getTime();
        String reStr = sdf.format(dt1);

        System.out.println(reStr);

    }


}
