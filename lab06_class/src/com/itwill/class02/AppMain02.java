package com.itwill.class02;

public class AppMain02 {

    public static void main(String[] args) {
        
        Rectangle rect1 = new Rectangle();
        System.out.println(rect1);
        System.out.println("rect1 width = "+rect1.width);
        System.out.println("rect1 height = "+rect1.height);
   
        System.out.println("============");
        
        rect1.width = 2.0;
        rect1.height = 3.0;
        System.out.println(rect1);
        System.out.println("rect1 width = "+rect1.width);
        System.out.println("rect1 height = "+rect1.height);
        System.out.println("============");
        
        System.out.println("rect1 Area = "+rect1.getArea());
        System.out.println("rect1 Perimeter = "+rect1.getPerimeter());
        
        System.out.println("============");
        //아규먼트를 갖는 생성자를 사용해서 객체 생성.
        
        Rectangle rect2 = new Rectangle(3.0, 4.0);
        
        System.out.println(rect2);
        System.out.println("rect2 width = "+rect2.width);
        System.out.println("rect2 height = "+rect2.height);
        
        System.out.println("============");
        
        System.out.println("rect2 Area = "+rect2.getArea());
        System.out.println("rect2 Perimeter = "+rect2.getPerimeter());
        
    }

}
