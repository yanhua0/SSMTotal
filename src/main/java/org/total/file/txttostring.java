package org.total.file;

import java.io.*;

public class txttostring {
    public static void main(String args[]) {
        File file = new File("H:\\11.txt");
        if (file.exists() && file.isFile()) {
            try {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader buff = new BufferedReader(read);
                String text = null;
                StringBuffer sb = new StringBuffer();
                while ((text = buff.readLine()) != null) {
                    System.out.println(text);
                    sb.append(text);

                }
                System.out.println(sb.toString());
                read.close();
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
