package com.itwill.method06;

import java.util.Random;

public class MethodMain06 {

    public static void main(String[] args) {
        // 메서드 작성 연습.
        Random random = new Random();

        int genderCode = random.nextInt(5); //[0,5) 범위의 난수 저장.
        System.out.println("genderCode : "+genderCode);

        //parseGenderCode()는 아규먼트가 1or3이면 male, 2or4이면 female, 0인경우 unknown 리턴.
        String gender = parseGenderCode(genderCode);
        System.out.println("gender : "+gender);

        System.out.println("====================================================");
        //ex2
        int number = random.nextInt(100);
        //isEven(int num) 정수가 짝수이면 true, false 
        boolean result = isEven(number);
        System.out.println("Result isEven : "+ result);

        System.out.println("====================================================");
        //ex3
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        System.out.println("x = "+x+" y = "+y);

        //whoIsBigger(x,y): x,y 중에서 더 큰 수를 리턴.
        int bigger = whoIsBigger(x,y);
        System.out.println("Bigger is = "+bigger);
    }

    public static int whoIsBigger(int x, int y) {
        int bigger; //어지간하면 변수는 선언하고 아무값이든 초기화를 해놓고 하는것이 좋다.
        // <= 이것은 괜찮지만 조금 아쉬운 코드.......
        // 정수 -> 0
        // 실수 -> 0.0
        // boolean -> false.
        // 참조 타입 -> null.
        System.out.printf("%d VS %d\n",x,y);
        if(x>=y) {
            bigger = x;
        } else {
            bigger = y;
        }
        return bigger;
    }


    public static boolean isEven(int num) {
        boolean result  = false; //초기화 되어있지 않은 변수를 프린트 혹은 리턴하려 하면 에러가 난다.
        // result; 로 초기화 한다면 밑에 else 블럭이 무조건 있어야한다.
        System.out.println("input Number = "+num);
        if( num % 2 == 0) {
            result = true;
        } else {
            result = false;
        } // 
        return result;   
    }//end isEven


    public static String parseGenderCode(int num) {
        String gender = " ";

        //        if(num==1||num==3) {
        //            gender = "M";
        //        } else if(num==2||num==4) {
        //            gender = "F";
        //        } else {
        //            gender = "UnKnown";
        //        }

        switch (num) {
        case 1,3: 
            gender = "M";
        break;
        case 2,4:
            gender = "F";
        break;
        default:
            gender = "UnKnown";
            break;
        }

        return gender;
    }//end parseGenderCode...

}//end class...
