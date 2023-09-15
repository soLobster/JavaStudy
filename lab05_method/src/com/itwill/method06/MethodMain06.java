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
        System.out.println("bigger is = "+bigger);
    }

    public static int whoIsBigger(int x, int y) {
        int bigger;
        System.out.printf("%d VS %d\n",x,y);
        if(x>y) {
            bigger = x;
        } else {
            bigger = y;
        }
        return bigger;
    }


    public static boolean isEven(int num) {
        boolean result;
        System.out.println("input Number = "+num);
        if(num%2==0) {
            result = true;
        } else {
            result = false;
        }
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
