package com.itwill.modifier05;
/**
 * 클래스 멤버에 접근(가시성) 수식어: private < (package) < protected < public
 * 클래스 접근 수식어....(가시성 수식어(access/visibility modifier): 
 * 1. public...어디서나 공개된 클래스. import 문장을 사용할 수 있음...
 * 2.(package): 수식어가 없는 경우....같은 패키지의 클래스에서만 사용할 수 있는 클래스...
 * ★★★★★★★★★(주의) public class의 이름...-> 자바 파일의 이름과 같아야한다....!!!!!!!!!!★★★★★★★★★
 * 하나의 자바 파일 안에서 클래스를 여러개 선언 하는 것은 가능하지만,
 * public class는 파일 안에서 단 하나만 있어야한다....!!!!
 * 한개의 파일에서 클래스를 여러개 선언했을 때, 컴파일 후에는 각각의 클래스 파일(바이트코드)이 생성된다....
 * 바이트 코드: JVM이 실행할 수 있는 명령어 SET.....
 */

import com.itwill.modifier06.PublicClass; //public 클래스만 보인다....!!!
//import com.itwill.modifier06.PackageClass; //package라 not visible 에러!!!
public class modifierMain05 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        PublicClass pc = new PublicClass();
        System.out.println(pc);
        

    }

}
