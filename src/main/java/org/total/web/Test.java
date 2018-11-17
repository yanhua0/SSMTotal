package org.total.web;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args){
        Date date=new Date();
        SimpleDateFormat sip=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String s=sip.format(date);

        long before=20181112202655893L;

        long now=20181112202755893L;
        long i=now-before;
        System.out.println("时间差"+i);

    }
}
