package com.itwill.inheritance06;

public class InheritanceMain06 {

	public static void main(String[] args) {
		// Point 타입 객체 생성.
		Point p1 = new Point();
		System.out.println(p1);

		Point p2 = new Point(0.0,0.0);
		System.out.println(p2);

		System.out.println(p1.equals(p2));

		System.out.println("=========================================");

		User user1 = new User();
		user1 = new User("aaa", "2222");
		System.out.println("user1."+user1);
		System.out.println("user1."+user1.toString());

		//User user2 = new User("ABC");
		//System.out.println("user2 >> "+user2);
		//System.out.println("user2 >> "+user2.toString());

		System.out.println();
		User user3 = new User("abc","1234");

		System.out.println("user1 Id equals user3 Id??");
		System.out.println("answer >> "+user1.equals(user3));

		System.out.println();
		System.out.println("user3."+user3);
		System.out.println("user3."+user3.toString());

		//System.out.print("user1 equals user2 ?? >> ");
		//System.out.println(user1.equals(user2));
		//System.out.print("user1 equals user3 ?? >> ");
		//System.out.println(user1.equals(user3));
	}
	//Object 클래스에서 toString 메서드는 "패키지.클래스@해시코드" 형식의 문자열을 리턴.
	//Object 클래스에서 상속받은 toString을 재정의(over_ride)하게 되면 콘솔 출력 내용을 변경 할 수 있게 된다.


}
