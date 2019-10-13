package task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static void main(String[] args){
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        for(int i=0;i<3;i++){
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });

        }
        System.out.println("执行over");
    }
}
