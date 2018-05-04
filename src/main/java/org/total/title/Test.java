package org.total.title;

public class Test {
    public static void main(String[] args) {
        String s="<title>小木网赚工作室———专业网赚信息分类网 &nbsp;&nbsp;&nbsp;骗子 &nbsp;&nbsp;时时彩 &nbsp;&nbsp;&nbsp;打码 &nbsp;&nbsp;挂机等项目勿扰</title>";
        s=s.replace("<title>","");
        s=s.replace("</title>","");
        s=s.replace("&nbsp;","");
        System.out.println(s);

    }
}
