package com.itwill.inheritance01;

/*
 * 클래스: 속성(필드) + 생성자 + 메서드 => 데이터 타입.
 * 전원 소리 채널
 */

public class BasicTv {
    public static final int MIN_CHANNEL = 0;
    public static final int MAX_CHANNEL = 2;
    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 2;

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

    //Tv의 기능 메서드로 만들자...!
    public boolean powerOnOff() {
        if(powerOn==true) {
            powerOn = false;
            //System.out.println("TV 꺼짐");
        } else {
            powerOn = true;
            //System.out.println("TV 켜짐");
        }
        return powerOn;
    }//end of powerOnOff...

    public int channelUp() {
        if(channel < MAX_CHANNEL) {
            channel++;
        } else if(channel == MAX_CHANNEL) {
            channel = MIN_CHANNEL;
        }
        return channel;
    }

    public int channelDown() {
        if(MAX_CHANNEL >= channel && channel > MIN_CHANNEL) {
            channel--;
        } else if(channel == MIN_CHANNEL) {
            channel = MAX_CHANNEL;
        }
        return channel;
    }

    public int volumeUp() {
        if(volume < MAX_VOLUME) {
            volume++;
        } else if(volume==MAX_VOLUME){
            volume = MAX_VOLUME;
        }
        return volume;
    }

    public int volumeDown() {
        if(MAX_VOLUME >= volume && volume > MIN_VOLUME) {
            volume--;
        }else if(volume==MIN_VOLUME) {
            volume = MIN_VOLUME;
        }
        return volume;
    }
}
