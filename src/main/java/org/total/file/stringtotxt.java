package org.total.file;

import java.io.*;

public class stringtotxt {
    public  static void main(String args[]){

        File file=new File("H:\\111.txt");
        if(!file.exists())
        {
            try {
                String s="hello world!";
                OutputStreamWriter fos=new OutputStreamWriter(new FileOutputStream(file.getAbsoluteFile(),true),"utf-8");
                System.out.println(file.getAbsoluteFile());
                fos.append(s);
                fos.close();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
