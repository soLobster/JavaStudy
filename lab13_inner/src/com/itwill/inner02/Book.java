package com.itwill.inner02;

public class Book {

    //field.
    private String title;
    private String author;
    private String publisher;
    
    //constructors
    
    public Book() {}
    
    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
    
    public Book(String title) {
        this(title,null,null);//다른 생성자를 호출하는 방법.
    }
    
}
