package com.itwill.switch03;

public class SwitchMain03 {
    
    public static void main(String[] args) {
        // WeekDay 타입의 변수를 선언하고 초기화:
        
        
        WeekDay day = WeekDay.SUN;
        
        switch(day) {
        
        case MON:
            System.out.println("아이티윌....");
            break;
        case TUE:
            //System.out.println("화요일.");
            //break;
        case WED:
            //System.out.println("수요일.");
            //break;
        case THU:
            System.out.println("버텨야지....");
            break;
        case FRI:
            System.out.println("불금.....");
            break;
        case SAT:
            //System.out.println("토요일.");
        case SUN:
            System.out.println("휴일.....");
            break;
        }
        
    }

}
