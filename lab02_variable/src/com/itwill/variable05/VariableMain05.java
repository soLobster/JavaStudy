package com.itwill.variable05;



public class VariableMain05 {

    public static void main(String[] args) {
        // boolean 논리형 true or false , 1 or 0 
        // true, false 역시 키워드. 변수 이름으로 사용 불가.
        // 비교 연산자. : == , != , > , < , >= , <= / 
        // 논리 연산자. : &&(and) , ||(or) , !(not)

        int a = 2;
        int b = 13;
        
        boolean b1 = (a == b);
        System.out.println(b1);
        
        boolean b2 = (a>0) && (a<10);
        System.out.println(b2);
        
        
        if(a==b) {
            System.out.println("it's true!");
        } else {
            System.out.println("it's false!");
        }
        
        
        
    }

}
