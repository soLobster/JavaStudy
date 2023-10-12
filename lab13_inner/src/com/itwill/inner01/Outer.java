package com.itwill.inner01;

public class Outer {
    // field
    
    private int x;
    private int y;
    private String s;
    
    // constructor
    public Outer(int x,int y,String s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
        
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    // method
    @Override
    public String toString() {
        return String.format("Outer{x=%d, y=%d, s=%s}", this.x,this.y,this.s); //printf와 유사함.
    }
    
    // static이 아닌 내부 클래스 선언.
    public class Inner {
        //inner class field
        private int y;
        
        //constructor
        public Inner(int y){
            this.y = y;
        }
        
        //method
        public void info() {
            System.out.println("---inner class---");
            System.out.println("Inner y = "+ y);
            System.out.println("Outer x = " + x); // 내부 클래스는 외부 클래스의 멤버를 접근할 수 있다.
            System.out.println("Outer y = " + Outer.this.y); //-> OuterClass.this.member
            System.out.println("Outer s = " + s);
            System.out.println(Outer.this.toString()); // 외부 클래스의 메서드를 사용할 수 있음.
        }
        
    }//inner class
}//outer class
