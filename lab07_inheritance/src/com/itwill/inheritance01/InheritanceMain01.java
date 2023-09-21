package com.itwill.inheritance01;
//상속....!
public class InheritanceMain01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BasicTv tv = new BasicTv();

        System.out.println(tv.toString());
        //System.out.println("전원이 켜져 있는가? >> "+tv.isPowerOn());
        //System.out.println("전원이 켜져 있는가? >> "+tv.isPowerOn());
        tv.powerOnOff();
        //System.out.println("지금 상태는?? >> "+tv.isPowerOn());
        System.out.println(tv.toString());
        tv.powerOnOff();
        System.out.println(tv.toString());
        //System.out.println("지금 상태는?? >> "+tv.isPowerOn());
        System.out.println();
        System.out.println("===channel Test===");
        System.out.println();
        //System.out.println("현재 tv 채널은?? >> "+tv.getChannel()); //0
        tv.channelUp(); //++
        System.out.println(tv.toString());
        tv.powerOnOff();
        //System.out.println("현재 tv 채널은?? >> "+tv.getChannel()); //1
        tv.channelUp(); //++
        System.out.println(tv.toString());
        //System.out.println("현재 tv 채널은?? >> "+tv.getChannel()); //2
        tv.channelUp(); //++ 
        System.out.println(tv.toString());

        //System.out.println("현재 tv 채널은?? >> "+tv.getChannel()); //0

        tv.channelUp();
        System.out.println(tv.toString());
        //System.out.println("현재 tv 채널은?? >> "+tv.getChannel()); //1
        tv.channelUp();
        System.out.println(tv.toString());
        //System.out.println("현재 tv 채널은?? >> "+tv.getChannel()); //2
        tv.channelDown();
        System.out.println(tv.toString());
        //System.out.println("현재 tv 채널은?? >> "+tv.getChannel()); //1
        tv.channelDown();
        System.out.println(tv.toString());
        //System.out.println("현재 tv 채널은?? >> "+tv.getChannel()); //0
        tv.channelDown();
        System.out.println(tv.toString());
        //System.out.println("현재 tv 채널은?? >> "+tv.getChannel()); //2
        tv.powerOnOff();
        System.out.println();


        System.out.println();
        System.out.println("===volume Test===");
        System.out.println();
        //System.out.println("현재 tv 볼륨은?? >> "+tv.getVolume()); //0
        tv.volumeUp();
        System.out.println(tv.toString());
        //System.out.println("현재 tv 볼륨은?? >> "+tv.getVolume()); //1
        tv.volumeUp();
        System.out.println(tv.toString());
        //System.out.println("현재 tv 볼륨은?? >> "+tv.getVolume()); //2
        tv.volumeUp();
        System.out.println(tv.toString());
        //System.out.println("현재 tv 볼륨은?? >> "+tv.getVolume()); //변동 없어야함.
        tv.volumeDown();
        System.out.println(tv.toString());
        //System.out.println("현재 tv 볼륨은?? >> "+tv.getVolume()); //1
        tv.powerOnOff();
        tv.volumeDown();
        System.out.println(tv.toString());
        //System.out.println("현재 tv 볼륨은?? >> "+tv.getVolume()); //0
        tv.volumeDown();
        System.out.println(tv.toString());
        //System.out.println("현재 tv 볼륨은?? >> "+tv.getVolume()); //변동 없어야함..
        System.out.println();

        tv.powerOnOff();
        System.out.println(tv.toString());

    }//end of Main....

}//end of InheritanceMain01 class..
