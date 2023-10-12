package com.itwill.inner03;

public class Button {
    //public static 내부 인터페이스. -static은 생략 가능.
    public interface onClickListener {
        void onClick();//public abstract method
    }
    
    //field 
    private String btnName;
    private onClickListener listener; //인터페이스 타입으로 변수 선언.
    
    //constructor
    public Button(String btnName) {
        this.btnName = btnName;
    }
    
    //setter
    public void setOnClickListener(onClickListener listener) {
        this.listener = listener;
    }
    
    //method
    public void click() {
        System.out.print(btnName+"버튼: ");
        listener.onClick();
    }
    
}
