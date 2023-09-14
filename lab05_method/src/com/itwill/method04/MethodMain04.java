package com.itwill.method04;

/*
 *  메서드 오버로딩(Method Overloading).
 *  자바에선 같은 이름으로 메서드를 여러개 만들어도 괜찮다.
 *  대신 파라미터가 달라야한다. -> 이것이 메서드 오버로딩....!
 *  오버로딩이란 개념이 없었다면 모든 메서드 이름을 다르게 만들어야했다.
 *  
 *  => 메서드의 파라미터가 다르면 같은 이름으로 메서드를 여러개 선언할 수 있음.....!!
 *  (주의) 파라미터는 동일하고 리턴 타입만 다르게는 오버로딩할 수 없다. -> 컴파일 에러.....!
 *  
 */

public class MethodMain04 {

    public static void main(String[] args) {
       
        System.out.println("String");
        newLine(2);
        System.out.println(1);
        //System.out.println();
        newLine(1);
        System.out.println(1.0);

        
        
    } //end main ---> 꿀팁.....
    /**
     * newLine().
     * System.out.println()의 간략화 메서드.
     * 콘솔에 빈 줄 하나를 출력해준다.
     */
    public static void newLine() {
        System.out.println();
    }
    
   // public static void newLine() { ---> 이런 경우 안된다.....!  
   //     return 1; =============> (주의) 파라미터는 동일하고 리턴 타입만 다르게는 오버로딩할 수 없다. -> 컴파일 에러!
   // }
    
    /**
     * newLine(int n).
     * 아규먼트로 전달 받은 숫자만큼 콘솔에 빈 줄을 출력해준다.
     * @param n 출력할 빈 줄의 개수. 양의 정수. 0또는 음수인 경우에는 아무것도 출력하지 않음....
     */
    public static void newLine(int n) { //메서드 이름은 같지만 파라미터가 다르다 --> 다른 메서드 취급. 오버로딩...!!
        for(int i = 0; i<n; i++) {
            System.out.println();
        }
    }
    
} //end class.... 
