package com.itwill.inheritance06;

//2차원 평면에서의 점의 좌표.
public class Point {
	//field
	private double x; //X 좌표 
	private double y; //Y 좌표

	//constructor
	public Point() {}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point(x = "+ this.x + ", y = "+this.y + ")";
	}

	//Object 클래스에서는 equals 메서드는 실제 힙에 생성된 객체가 같으면 true.
	//그렇지 않으면 false를 리턴하도록 만들어져있음.
	//Object 클래스에서 상속받은 equals 메서드를 재정의(over_ride)하면서 
	//두 객체의 같음을 새로 정의할 수 있음.
	//예를 들면 2차원 평면의 (x와 y) 좌표값이 같으면 true, 그렇지 않으면 false...

	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		if (obj instanceof Point) {
			Point pt = (Point) obj;
			result = (this.x == pt.x) && (this.y == pt.y);
		}

		return result;
	}

	//object 클래스에서는 hashCode 메서드가 생성된 객체의 주소값을 리턴.
	//hashCode 메서드는 equals가 true가 되는 두 객체는 같은 해시코드 값을 가져야 함.
	//object 클래스에서 상속받은 hashcode 메서드를 재정의 할 때는,
	//equals가 true이면 해시코드가 같도록 정수를 리턴.
	@Override
	public int hashCode() {
		return (int) x + (int) y;
	}

}
