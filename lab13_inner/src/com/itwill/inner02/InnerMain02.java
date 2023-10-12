package com.itwill.inner02;

public class InnerMain02 {

    public static void main(String[] args) {
        // Book 타입 객체 생성.
        Book book1 = new Book("일론 머스크","월터 아이작슨","21세기북스");
        System.out.println(book1);

        Book book2 = new Book("Elon Musk", "월터 아이작슨");
        System.out.println(book2);
        
        Book book4 = Book.builder().build();
        System.out.println(book4);
        
        Book book5 = Book.builder().author("월터 아이작슨").build();
        System.out.println(book5);
        
        Book book6 = Book.builder().publisher("21세기북스")
                                    .title("일론머스크")
                                    .author("월터 아이작슨")
                                    .build();
        System.out.println(book6);
                
    }

}
