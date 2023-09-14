package com.itwill.increase;

public class OperatorMain01 {

    public static void main(String[] args) {
        //증가(++), 감소(--) 연산자:
        // 1) 단항 연산자. 변수 앞 또는 뒤에서 사용 가능. ex) ++x / x++
        // 2) 단독으로 사용되는 경우에는, 변수 앞에 있는 것과 변수 뒤에 있는 것이 동일.
        // 3) 다른 연산자와 함께 사용되는 경우에는,
        //      ㄱ) 변수앞에 있는 경우는, 다른 연산자들보다 먼저 연산이 수행됨.
        //      ㄴ) 변수뒤에 있는 경우는, 다른 연산들이 끝난 다음에 수행됨.

        int x =1;
        System.out.println("x= "+x);
        
        x++;
        System.out.println("x= "+x);
        
        ++x;
        System.out.println("x= "+x);
        
        
        int y = 1;
        System.out.println("y= "+y);
        
        int result = ++y +10; //변수 앞에서 사용된 증가 연산자. y를 증가하고 10을 더한다. 전위연산자. 
        System.out.println("result= "+result);
        System.out.println("y= "+y);
        
        int z = 1;
        System.out.println("z= "+z);
        
        int result2 = z++ +10; //변수 뒤에서 사용된 증가 연산자. 1+10을 먼저한다. 후위연산자.
        System.out.println("result2= "+result2);
        System.out.println("z= "+z);
        
        int n = 1;
        int result3 = n++ + 10 + ++n; 
        // 1) 전위 연산자는 먼저 값을 할당한 N->1 다음 증가시킨다.
        // 2) 전위연산자 1 + 10 -> 11이 되고 N-> 2가 된다.
        // 3) 11 + ++n 에선 후위 연산자는 증가 시키고 그 값을 할당한다 . 1에서 n은 2가 되었고 그값을 다시 증가 3이 된다.
        // 4) result는 14가 된다.
        System.out.println("result = "+ result3);
        System.out.println("n ="+n);
        
    }

}
