package com.itwill.loop05;

public class LoopMain05 {

    public static void main(String[] args) {
        // 반복문 break vs continue.
        // break 반복문 실행 중에 break 문장을 만나면, break가 포함된 가장 가까운 반복문 블록을 탈출
        // continue: 반복문 실행중에 continue 문장을 만나면,
        // continue 아래의 코드들을 무시하고 그 다음 반복 과정을 수행.
        
        for(int i=1; i<=5; i++) {
            if(i==3) {
                continue;
            }
            System.out.println(i);
        }
        System.out.println();
        System.out.println("===============================");
        System.out.println();
        for(int i=1; i<=5; i++) {
            if(i==3) {
                break;
            }
            System.out.println(i);
        }
        
        System.out.println("===============================");
        //break 문 활용 - 무한 반복문을 종료시킬 때 
        for(int n =1; ;n++) { //for 구문 조건식이 없는 경우 무한 반복문.
            
            if(n==10) {
                break;
            }
            System.out.println(n);
        }
        
        
        
    }

}
