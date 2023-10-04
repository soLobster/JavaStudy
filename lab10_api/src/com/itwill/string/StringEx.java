package com.itwill.string;

public class StringEx {

    public static void main(String[] args) {
        // String 클래스의 메서드 사용법

        // ex1. 주민번호 문자열에서 성별을 표시하는 위치의 문자를 출력.
        String ssn = "990904-1234567";
        System.out.println(ssn.charAt(7));

        // ex2. 아래의 문자열 배열에서 5글자 이상인 문자열들만 출력.
        // 결과: JavaScript Servlet Spring
        String[] array = {"Java", "SQL", "JavaScript", "HTML", "CSS", "Servlet", "Spring"};
        //        for(String x : array) {
        //            if(x.length()> 5)
        //                System.out.print(x+" ");
        //        }

        for(int i = 0; i<array.length; i++) {
            int length = array[i].length();
            if(length > 5) {
                System.out.print(array[i]+" ");
            }
        }


        System.out.println();

        // ex3. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력.
        // 만약에 "홍길동"이 배열에 없는 경우에는 -1을 출력.
        // 결과: 2
        String[] names = {"오쌤", "John", "홍길동", "Gildong", "홍길동"};

        int index = -1;
        for(int i = 0; i<names.length; i++) {
            if(names[i].equals("홍길동")) {
                index = i;
                break;
            }
        }
        System.out.println(index);

        // ex4. 아래의 문자열 배열에서 대소문자 구별없이 "est"를 포함하는 문자열들을 출력.
        // 결과: TEST test TeSt tEsT
        String[] tests = {"TEST", "test", "TeSt", "tEsT", "테스트"};

        for(String est : tests) {
            if(est.toLowerCase().contains("est")) {
                System.out.print(est+" ");
            }
        }

        System.out.println();
        //ex5. 아래의 "YYYY-MM-DD" 형식의 날짜 문자열에서 년/월/일 정보를 int 타입 변수에 저장.
        //결과: year=2023, month=10, day=4.
        String date = "2023-10-04";
        String[] strArray = date.split("-"); // ->{"2023" , "10" , "04"}  "-" 구분자를 기준으로 짜른다.
//        for(String s : strArray) {
//            System.out.print(s);
//        }
        int year = Integer.parseInt(strArray[0]);
        int month = Integer.parseInt(strArray[1]);
        int day = Integer.parseInt(strArray[2]);
        
        System.out.printf("year=%d, month=%d, day=%d",year,month,day);
    }

}