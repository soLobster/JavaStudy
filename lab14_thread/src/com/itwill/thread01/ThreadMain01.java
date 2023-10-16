package com.itwill.thread01;

/*
 * 쓰레드 사용방법.
 * 1) thread를 상속하는 클래스 선언
 * 2) 1)에서 선언한 클래스에서 run() 메서드를 재정의(over_ride) -> 쓰레드가 할 일.
 * 3) 2)에서 작성한 클래스의 객체를 생성.
 * 4) 3)에서 생성된 객체에서 start() 메서드를 호출 -> 쓰레드 실행.
 * 주의) Over_ride한 run 메서드를 직접 호출하면 안됨...!
 * 이유 - start() 메서드 호출 -> JRE에서 쓰레드를 초기화(메모리 할당,....) -> run() 메서드가 자동으로 실행된다.
 * 
 */


public class ThreadMain01 {

    public static void main(String[] args) {
        //1) Thread를 상속하는 클래스를 선언.(local class)
        class MyThread extends Thread {
            private String name;

            public MyThread(String name) {
                this.name = name;
            }

            //2) run() 메서드 오버라이드.
            @Override
            public void run() {
                for(int i=0; i < 100; i++) {
                    System.out.println(i+" : "+name);
                    try {
                        sleep(100); // Thread 클래스의 sleep 메서드 호출 - 0.01초 쉼.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }//for
            }//run() method
        }//class MyThread 

        //3) Thread 객체 생성.
        MyThread th1 = new MyThread("쓰레드");
        MyThread th2 = new MyThread("Hello");
        MyThread th3 = new MyThread("안녕하세요");
        long start = System.currentTimeMillis();
        
        
        //4) Thread 객체에서 Start() 메서드를 호출. (쓰레드 실행)
        th1.start();
        th2.start();
        th3.start();
        try {
            th1.join(); //th1 쓰레드가 종료될 때까지 main 메서드가 기다림.
            th2.join();
//            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long end = System.currentTimeMillis();
        
        System.out.println("경과시간 = "+ (end-start) +"ms");
        
        System.out.println("==== main 메서드 종료 ===="); //main은 쓰레드를 실행시키고 종료된다.
    }//main

}//class
