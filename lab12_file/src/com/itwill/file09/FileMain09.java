package com.itwill.file09;

import java.io.File;

/*
 * 파일, 폴더(디렉토리) 관리 - 정보, 생성, 삭제.
 * 
 * 현재 작업 디렉토리(CWD) 현재 프로그램(프로세서)가 실행되는 디렉토리 위치.
 * - 이클립스에서 자바 프로그램을 실행(run as java Application) 할 때, 작업 디렉토리 위치는 프로젝트 폴더. 
 * 
 * 절대 경로(absolute Path).
 * - 시스템의 루트부터 파일또는 폴더가 있는 위치까지를 찾아가는 방식
 * ex) c:\workspace\lab_java\lab12_file\data\ansi.txt (WIN)
 * ex) /users/itwill/documents/ansi.txt (MAC,LINUX)
 * 
 * 상대 경로(relative Path).
 * - 현재 작업 디렉토리(CWD, Current Working Directory)를 기준으로 파일 또는 폴더 위치를 찾아가는 방식.
 * ex) data\ansi.txt (win)
 * ex) data/ansi.txt (mac)
 * - 현재 디렉토리 : . (ex) ./data/ansi.txt
 * - 상위 디렉토리 : ..(ex) ../src/com/itwill
 * 
 *  
 * 
 * 
 */

public class FileMain09 {

    public static void main(String[] args) {
        // Java Runtime이 프로그램을 실행하고 있는 현재 디렉토리 찾기.
        String cwd = System.getProperty("user.dir");
        System.out.println(cwd);
        
        String path = "C:\\work_space\\lab_java\\JavaStudy\\lab12_file"; //Windows에서의 절대 경로 표현.
        System.out.println(path);
        
        String path2 = "data\\ansi.txt"; //windows에서의 상대 경로.
        //현재는 os 구분없이 "data/ansi.txt"로 표현해도 됨.
        
        System.out.println(path2);
        
        String path3 = "data"+File.separator+"ansi.txt";
        
        System.out.println(path3);
    }

}
