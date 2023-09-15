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
    }

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
