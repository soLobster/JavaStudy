package com.itwill.condition07;
import java.util.Random;
import java.util.Scanner;

public class RpsMain {

    public static void main(String[] args) {
        // 가위바위보 게임
        // 가위 0 바위 1 보 2
        System.out.println("*******************");
        System.out.println("* 가위바위보 게임 *");
        System.out.println("*     가위[0]     *");
        System.out.println("*     바위[1]     *");
        System.out.println("*      보[2]      *");
        System.out.println("*                 *");
        System.out.println("*   CHOOSE ONE!   *");
        System.out.println("*******************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("USER의 가위바위보!!  >> ");
        int userRps = scanner.nextInt();
        
        Random random = new Random();
        int comRps = random.nextInt(3);
        System.out.println("COM의  가위바위보!!  >> "+comRps);
        
        if(userRps == 2) { //유저 보
            
            if(comRps == 0) {
                System.out.println("COM WIN!");
            } else if(comRps == 1) {
                System.out.println("USER WIN!!");
            } else {
                System.out.println("DRAW");
            }
            
        } else if(userRps == 1) { //유저 바위
            
            if(comRps == 0) {
                System.out.println("USER WIN!");
            } else if(comRps == 1) {
                System.out.println("DRAW");
            } else {
                System.out.println("COM WIN!");
            }
            
        } else { //유저 가위
            
            if(comRps == 0) {
                System.out.println("DRAW");
            } else if(comRps == 1) {
                System.out.println("COM WIN!");
            } else {
                System.out.println("USER WIN!");
            }
            
        }
        
        scanner.close();
    }

}
