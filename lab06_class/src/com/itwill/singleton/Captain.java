package com.itwill.singleton;
/**
 * singleton 객체 
 * 1) private static field
 * 2) 생성자 private.
 * 3) public static method -> class Captain을 리턴해주는 역할....
 */
public class Captain {
//1) private static field 자기자신타입....(Captain)
    private static Captain instance = null;
    
    private String name = "캡틴 아메리카";
    
//2) private 생성자
    private Captain() {
        //do nothing....
    }
//3) public static이고 자기 자신 타입을 리턴하는 method
    public static Captain getInstance() {
       if(instance == null) { //Captain.instance....
           instance = new Captain();
       }
       return instance;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
