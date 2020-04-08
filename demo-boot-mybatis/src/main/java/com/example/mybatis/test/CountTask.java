package com.example.mybatis.test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * fork join 测试
 * @author ccubee
 * @since 20-4-5 13:37
 */
public class CountTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 1000;
    private long start;
    private long end;

    public CountTask(long start, long end){
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        long sum = 0;
        boolean canComplate = (end - start) < THRESHOLD;
        if(canComplate){
            for (long i = start; i <= end; i++){
                sum += i;
            }
        }else {
            long step = (start + end) / 100;
            ArrayList<CountTask> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++){
                long lastOne = pos + step;
                if(lastOne > end) {
                    lastOne = end;
                }
                CountTask subTask = new CountTask(pos, lastOne);
                pos += step + 1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for (CountTask t : subTasks){
                sum+= t.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0, 100000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            System.out.println(System.currentTimeMillis());
            Long res = result.get();
            System.out.println("sum=" + res);
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
