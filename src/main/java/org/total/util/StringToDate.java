package org.total.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
    public static void main(String[] args) throws ParseException {
    String year="2017-";
    String month="11-";
    String day="30";
    StringBuffer sb=new StringBuffer();
    sb.append(year);
    sb.append(month);
    sb.append(day);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse(sb.toString());
        System.out.println(date);
    }
}
