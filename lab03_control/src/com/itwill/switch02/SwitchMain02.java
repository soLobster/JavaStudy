package com.itwill.switch02;
import java.util.Random;

public class SwitchMain02 {

    public static void main(String[] args) {
        Random random = new Random();
        int genderCode = random.nextInt(6);
        System.out.println("성별 코드 : "+genderCode);
        // switch 구문을 사용해서.
        // genderCode의 값이 1 또는 3이면 "남성"을 출력,
        // genderCode의 값이 2 또는 4이면 "여성"을 출력.
        // genderCode의 값이 1~4 이외의 값이면 "몰라요"를 출력.
        switch (genderCode) {
        case 1,3: 
            System.out.println("남성");
            break;
        case 2,4:
            System.out.println("여성");
            break;
        /*
        case 3: 
            System.out.println("2000년도 이후 출생 남성");
            break;
        case 4:
            System.out.println("2000년도 이후 출생 여성");
            break;
        */   
        default:
            System.out.println("몰라요....");
        }

    }

}
