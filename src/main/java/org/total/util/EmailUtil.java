package org.total.util;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailSSLSocketFactory;
import org.total.message.GetMessageCode;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

public class EmailUtil {

    public static String send(String to,String subject,String msg){

        Properties props = new Properties();
        //邮件传输的协议
        props.put("mail.transport.protocol", "smtp");
        //连接的邮件服务器
        props.put("mail.host","smtp.qq.com");
        //发送人
        props.put("mail.from","2060146330@qq.com");

        //第一步：创建session
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", "true");
            //第二步：获取邮件传输对象
            Transport ts= session.getTransport();
            //连接邮件服务器
            ts.connect("2060146330@qq.com", "ranpqsldfevsejja");
            //第三步：创建邮件消息体
            MimeMessage message = new MimeMessage(session);
            //设置邮件的内容
            message.setSubject(subject);
            //设置邮件的内容
            message.setContent(msg,"text/html;charset=utf-8");
            //第四步：设置发送昵称
            String nick="";
            nick = javax.mail.internet.MimeUtility.encodeText("小Q");
            message.setFrom(new InternetAddress(nick+"'<2060146330@qq.com>'"));
            //第五步：设置接收人信息
            ts.sendMessage(message, InternetAddress.parse(to));

        } catch (Exception ex) {
            // TODO Auto-generated catch block
            System.out.println("邮箱不存在");
            msg=null;
        }

        return msg;

    }
public static String sendEmain(String qq)
{   String rod=GetMessageCode.smsCode();
    rod=EmailUtil.send(qq,"验证码",rod);
    return rod;

}
    public static void main(String[] args) {


                String rod=GetMessageCode.smsCode();
                rod=EmailUtil.send("1256656046@qq.com", "验证码","【在线购物】登录验证码："+rod+"，如非本人操作，请忽略此短信。");


             println(rod);
     }

}