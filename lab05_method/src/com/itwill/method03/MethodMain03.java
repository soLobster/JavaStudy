package com.itwill.method03;

/*
 * 반환 값이 없는 메서드 작성, 호출 연습
 * 카운트 다운.........
 * 3...2...1...0.... 출력만 하고 끝...!
 */

public class MethodMain03 {
    public static void main(String[] args) {
        countDown(10); // 메서드 호출!...
    }

    public static void countDown(int start) { //void 리턴 값이 없다....를 알려주는 키워드.
        
        if(start < 0) {
            System.out.println("0 보다 큰 값을 입력해주세요.");
            return ;
            // return 문장의 의미:
            // 1) 메서드 종료
            // 2) (return 문장에 값이 있으면), 값을 메서드를 호출한 곳에 반환.
        }
        for(int i=start; i>=0; i--) {
            System.out.println(i);
        }
    }
}
