package com.itwill.loop12;
import java.util.Random;

public class LoopMain12 {

    public static void main(String[] args) {
        // p161 문3. while / Math.random() 2개의 주사위.
        // 눈의 합이 5가 아니면 계속 주사위. 합이 5면 실행을 멈춰라.
        System.out.println("p161 문제 (3)=======================================");
        System.out.println();
        int dice1 = 0;
        int dice2 = 0;
        
        Random random = new Random();
        
        while(true) { //무한 반복문 시작 while(true).
            dice1 = random.nextInt(1,7); //1이상 7미만의 정수 난수 생성.
            dice2 = random.nextInt(1,7);
                if(dice1+dice2!=5) {
                    System.out.printf("your dice : (%d,%d)\n",dice1,dice2);
                    //System.out.println("your dice : "+"("+dice1+","+dice2+")");
                } else {
                    System.out.printf("FIVE!! : <(%d,%d)>\n",dice1,dice2);
                    //System.out.println("FIVE!! : "+"("+dice1+","+dice2+")");
                    break;
                }   
            }  
        System.out.println();
        System.out.println("p161 문제 (4)=================================");
        System.out.println();
        //p161 문4 x,y=10 이하의 자연수 (1,2,3,4,.....10)
        // 4x+5y = 60 을 만족하는 모든 X,Y를 찾으세요.
        // EX) X=5 , Y=8....
        for(int x=1; x<=10;x++) {
            for(int y=1; y<=10; y++) {
                    if((4*x)+(5*y)==60) {
                        System.out.printf("(X=%d , Y=%d)\n",x,y);
                        break;
                    }
            }
        }
    }
}
