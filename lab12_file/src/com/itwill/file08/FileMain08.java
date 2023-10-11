package com.itwill.file08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * IO Stream... 바이트 스트림. 읽기/쓰기의 기본단위는 byte 단위.
 * - 모든 종류의 파일(txt,jpg,mp4, ppt, ....)에서 사용 가능.
 * InputSteam...
 *         |______FileInputStream, BufferedInputStream, ObjectInputStream....
 * OutputStream...
 *         |______FileOutputStream, BufferedOutputStream, ObjectOutpurStream...
 * 
 * Reader/Writer. : 문자 스트림(character stream) 읽기/쓰기의 기본 단위는 문자(character) 단위
 *  - 텍스트 파일(txt, csv, ...)에서만 사용....
 *  
 * Reader
 *    |___InputStreamReader, BufferedReader...
 *         |_____FileReader
 * Writer(유사 OutputStream)
 *    |____OutputStreamWriter, BufferedWriter...
 *            |_____FileWriter
 * 
 * 인코딩(encoding) : 문자를 그 문자에 해당하는 코드(정수 값)로 변환. ex) 'A' -> 65 
 * 디코딩(decoding) : 문자 코드(정수)를 그 코드에 해당하는 문자로 변환. ex) 65 -> 'A'
 * 운영체제(OS)의 기본 인코딩 방식:
 *  -  MS-Windows : 한글(EUC-KR, CP949) , 영어(CP1252),....
 *  -  MacOs, Linux, Unix : UTF-8 
 */

public class FileMain08 {

    public static void main(String[] args) {
        // 파일 이름
        String ansiFile = "data/ansi.txt";
        String utf8FIle = "data/utf8.txt";

        // Java 11 버전 이전에서 문자 스트링과 인코딩을 다루는 방법.
        // FileReader, FileWriter 클래스는 인코딩 설정 방법이 없음.

        try (
                //1. FileInputStream(byte Stream)을 먼저 생성.
                FileInputStream fis = new FileInputStream(ansiFile);
                //2. 인코딩을 설정한 InputStreamReader(문자 스트림) 생성.
                InputStreamReader isr = new InputStreamReader(fis, "EUC-KR"); //인코딩 타입 설정.
                //3. 읽기 속도를 빠르게 하기 위해 BufferedReader (문자 스트림) 객체 생성.
                BufferedReader br = new BufferedReader(isr);
                ){

            while(true) { //루프
                int read = br.read(); // 1글자씩 읽음.
                if(read == -1) {
                    break;
                }
                System.out.print((char) read); //char 캐스팅
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
