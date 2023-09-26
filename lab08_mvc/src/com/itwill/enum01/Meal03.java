package com.itwill.enum01;

public enum Meal03 { //Meal2를 간단하게 표현....
    BREAKFAST, LUNCH, DINNER; //상수들만 저장하는 클래스....

    //enum은 private 생성자만 만들수 있다. public (X)
    //enum은 특별한 종류의 클래스이기 때문에 메서드를 작성할 수 있음....
    public int getOrder() {
        if(this == BREAKFAST) {
            return 0;
        } else if(this==LUNCH) {
            return 1;
        } else {
            return 2;
        }

    }
}
