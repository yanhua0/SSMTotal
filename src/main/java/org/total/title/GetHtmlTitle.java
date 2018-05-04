package org.total.title;

import info.monitorenter.cpdetector.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GetHtmlTitle {

    public static String GetHtmlTitle(String htmlUrl){
        System.out.println("/n------------开始读取网页(" + htmlUrl + ")-----------");
        String htmlSource = "";
        htmlSource = getHtmlSource(htmlUrl);//获取htmlUrl网址网页的源码
        System.out.println("------------读取网页(" + htmlUrl + ")结束-----------/n");
        System.out.println("------------分析(" + htmlUrl + ")结果如下-----------/n");
        String title = getTitle(htmlSource);
        System.out.println("网站标题： " + title);
        return title;
    }

    /**
     * 根据网址返回网页的源码
     * @param htmlUrl
     * @return
     */
    public static String getHtmlSource(String htmlUrl){
        URL url;
        StringBuffer sb = new StringBuffer();
        try{
            url = new URL(htmlUrl);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),GetHtmlTitle.getUrlCharset(htmlUrl)));//读取网页全部内容
            String temp;
            while ((temp = in.readLine()) != null)
            {
                sb.append(temp);
            }
            in.close();
        }catch (MalformedURLException e) {
            System.out.println("你输入的URL格式有问题！请仔细输入");
        }catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 从html源码(字符串)中去掉标题
     * @param htmlSource
     * @return
     */
    public static String getTitle(String htmlSource){
        List<String> list = new ArrayList<String>();
        String title = "";

        //Pattern pa = Pattern.compile("<title>.*?</title>", Pattern.CANON_EQ);也可以
        Pattern pa = Pattern.compile("<title>.*?</title>");//源码中标题正则表达式
        Matcher ma = pa.matcher(htmlSource);
        while (ma.find())//寻找符合el的字串
        {
            list.add(ma.group());//将符合el的字串加入到list中
        }
        for (int i = 0; i < list.size(); i++)
        {
            title = title + list.get(i);
        }
        return outTag(title);
    }


    public static String outTag(String s)
    {
        s=s.replaceAll("<.*?>", "");
        s=s.replace("<title>","");
        s=s.replace("</title>","");
        s=s.replace("&nbsp;","");
        return s;
    }

    public static String getUrlCharset(String url){
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            System.out.println("Content-Type" + "--->" + map.get("Content-Type"));
            List<String> list=map.get("Content-Type");
            if (list.size()>0){
                String contentType=list.toString().toUpperCase();
                if (contentType.contains("UTF-8")){
                    return "UTF-8";
                }
                if(contentType.contains("GB2312")){
                    return "GB2312";
                }
                if (contentType.contains("GBK")){
                    return "GBK";
                }
            }

            //如果相应头里面没有编码格式,用下面这种
            CodepageDetectorProxy codepageDetectorProxy = CodepageDetectorProxy.getInstance();
            codepageDetectorProxy.add(JChardetFacade.getInstance());
            codepageDetectorProxy.add(ASCIIDetector.getInstance());
            codepageDetectorProxy.add(UnicodeDetector.getInstance());
            codepageDetectorProxy.add(new ParsingDetector(false));
            codepageDetectorProxy.add(new ByteOrderMarkDetector());
            Charset charset = codepageDetectorProxy.detectCodepage(new URL(url));
            return charset.name();
        }catch (Exception e){}
        return null;
    }
    public static void main(String[] args) throws IOException {

    }

}
