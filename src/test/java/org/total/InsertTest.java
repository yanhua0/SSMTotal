package org.total;


public class InsertTest {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new InsertThread().start();
        }
    }

}

