package com.iamhotcenplotz.www.chapter10.abstract_;

public class TemplatePattern {
    public static void main(String[] args) {
        JobOne jobOne = new JobOne();
        JobTwo jobTwo = new JobTwo();
        jobOne.getDuration();
        jobTwo.getDuration();
    }
}


abstract class Template{

    public void getDuration(){
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("Duration: " + (end - start));
    }

    abstract void job();
}

class JobOne extends Template{
    @Override
    void job() {
        long sum=0;
        for (long i = 0; i < 100000; i++) {
            sum+=i;
        }
        System.out.println("sum: " + sum);
    }
}

class JobTwo extends Template{
    @Override
    void job() {
        long sum=0;
        for (long i = 0; i < 200000; i++) {
            sum += i;
        }
        System.out.println("sum: " + sum);
    }
}
