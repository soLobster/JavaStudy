package com.itwill.inheritance01;

/*
 * 클래스: 속성(필드) + 생성자 + 메서드 => 데이터 타입.
 * 전원 소리 채널
 */

public class BasicTv {
    
    private boolean powerOn; //현재 전원 On(true)/Off(false) 상태...
    private int channel; //채널 번호를 저장. 
    private int volume; //볼륨을 저장
    
    public BasicTv() {} //기본 생성자....
    
    public BasicTv(boolean powerOn, int channel, int volume) { 
        this.powerOn = powerOn;
        this.channel = channel;
        this.volume = volume;   
    }//아규먼트 생성자...
    
    //getter & setter....
    public boolean isPowerOn() { //return type boolean => is or get
        return powerOn;
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    
}
