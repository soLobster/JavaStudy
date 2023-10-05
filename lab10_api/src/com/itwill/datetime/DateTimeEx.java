package com.itwill.datetime;

import java.sql.Timestamp; //java.sql을 사용한다.
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class DateTimeEx {

    public static void main(String[] args) {
        //Java 8버전부터 java.time 패키지의 날짜/시간 클래스
        
        LocalDate today = LocalDate.now();//현재 시간... 오늘 날짜.
        
        System.out.println(today); //today.toString() --> over_riding 과 같다.

        System.out.println(today.getDayOfYear()); // -> 연도에서 몇번째 날인지
        
        System.out.println(today.getMonthValue()); 
        
        System.out.println(today.getMonth()); //enum -> 상수 정의 -> Month라고 하는 enum에서 가져온다. 
        
        System.out.println(today.getDayOfMonth()); // 날짜를 int로 리턴...
        
        System.out.println(today.getDayOfWeek()); // -> 요일 정보 DayOfWeek 타입의 enum을 리턴.
        
        System.out.println(today.plusDays(1)); //-> 날짜를 더해준다.
        
        System.out.println(today.plusMonths(1));
        System.out.println(today.minusDays(1));
        
        System.out.println(today.of(2024, Month.MARCH, 11));
        LocalDate date = LocalDate.of(2024, 3, 11);
        System.out.println(date);
        
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        
        LocalDateTime time = LocalDateTime.of(2024, 1, 1, 0, 0);
        System.out.println(time);
        
        System.out.println("-----------------");
        
        // Timestamp: 1970-01-01 00:00:00를 기준으로 1/1000초 마다 
        // 1씩 증가하는 정수(long 타입)를 기반으로 날짜와 시간 정보를 저장하는 클래스 타입.
        // 1) LocalDateTime ---> Timestamp 변환
        Timestamp ts = Timestamp.valueOf(now);
        System.out.println(ts);
        // 2) Timestamp ---> LocalDateTime 변환
        LocalDateTime dt = ts.toLocalDateTime();
        System.out.println(dt);
    
    }

}
