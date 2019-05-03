package org.total.util;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 建议服务器
 */
public class Server {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // 调用系统socket接口，监听某端口的socket请求
            Socket httpInputSocket = serverSocket.accept(); // 在这里，程序线程等待socket输入
            this.printHttpRequest(httpInputSocket);
            this.responseHttpRequest(httpInputSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印来自外部的http请求
     *
     * @param httpInputSocket
     */
    private void printHttpRequest(Socket httpInputSocket) {
        try {
            // 调用系统IO，打印请求
            BufferedReader br = new BufferedReader(new InputStreamReader(httpInputSocket.getInputStream()));
            StringBuilder receivedHttp = new StringBuilder();
            String line = null;
            while ( !"".equals(line = br.readLine())) {
                receivedHttp.append(line);
                receivedHttp.append(System.getProperty("line.searator", "\n"));
            }
            System.out.println(receivedHttp.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回页面供请求方显示
     *
     * @param httpInputSocket
     */
    private void responseHttpRequest(Socket httpInputSocket) {

        // 创建响应体
        StringBuilder contextText = new StringBuilder();
        contextText.append(
                "<html>" +
                        "<head>" +
                        "<title>Build A Web Server</title>" +
                        "</head>" +
                        "<body>Hello World, This is my page</body>" +
                        "</html>");

        // 创建响应头
        StringBuilder headText = new StringBuilder();
        headText.append("HTTP/1.1").append(" ").append("200").append(" ").append("OK").append("\n");
        headText.append("Server:myServer").append(" ").append("0.0.1v").append(" ");
        headText.append("Date:Sat,"+" ").append(new Date()).append("\n");
        headText.append("Content-Type:text/html;charset=UTF-8").append("\n");
        headText.append("Content-Length:").append(contextText.toString().getBytes().length).append("\n");

        // http response
        StringBuilder responseText = new StringBuilder();
        responseText.append(headText).append("\n").append(contextText);
        System.out.println(responseText);

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(httpInputSocket.getOutputStream()));
            bw.write(responseText.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
