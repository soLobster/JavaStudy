package com.itwill.ver01;

import java.util.Scanner;

public class ContactMain01 {
    public static final int MAX_LENGTH = 5; //배열의 길이(원소 개수).
    // static final 멤버 변수들은 전부 대문자로 하는게 관례이다....

    private Scanner scanner = new Scanner(System.in); //입력 도구....
    private Contact[] contacts = new Contact[MAX_LENGTH]; //연락처들을 저장할 배열...
    private int count = 0; //배열 contacts에 저장된 연락처 개수를 저장하는 변수.....
    //배열에 새로운 연락처가 저장될 때마다 1씩 증가시킨다.... count++  / count--

    public static void main(String[] args) {
        System.out.println("---------*****---------연락처 v0.1-----------*****--------");
        ContactMain01 app = new ContactMain01();

        boolean run = true; //프로그램 실행/종료 여부......

        while(run) {

            int menu = app.showMainMenu();

            switch (menu) {
            case 0: //종료 케이스....
                run = false;
                System.out.println("프로그램을 종료합니다.");
                break;
            case 1: //배열에 저장된 전체 목록 출력...
                app.readAllContacts();
                break;
            case 2: //새 연락처 등록....
                app.createContact();
                break;
            case 3: //index 검색...
                app.readContactByIndex();
                break;
            case 4: //연락처 수정 기능...
                app.updateContact();
                break;
            default:
                System.out.println("올바른 메뉴를 선택해주세요(0~4) :) ");
            }//end of switch...

        }//end of while...

        System.out.println();
        System.out.println("--------*****---------^^좋은하루^^---------*****---------");
    }//end of main...

    private void readAllContacts() {

        System.out.println("저장된 연락처를 표기합니다.");
        System.out.println();
        System.out.println("연락처 목록----");

        for(int i = 0; i<count; i++) { //배열에 실제로 저장된 연락처 개수만큼 반복....
            System.out.printf("%d) %s",i,contacts[i].toString()).println();
        }

        System.out.println("------------");
        System.out.println();

    }//end of readAllContacts method....


    private void createContact() { 

        if(count >= MAX_LENGTH) { //애초에 에러 조건을 만들어 보자....!
            System.out.println();
            System.out.println("저장할 수 있는 최대 용량을 초과했습니다....");
            return;  //리턴 타입이 void니까 return을 해버리면 아예 밑에 코드들이 실행되지 않는다.....!!
        }

        System.out.println("연락처를 저장합니다.");
        System.out.print("이름을 입력해주세요 >> ");
        String name = scanner.nextLine();
        System.out.print("번호를 입력해주세요 >> ");
        String number = scanner.nextLine();
        System.out.print("E-Mail을 입력해주세요 >> ");
        String email = scanner.nextLine();

        //여기도 에러 발생 if-else...
        //배열의 길이는 제한적임...
        Contact c = new Contact(name, number, email); //String 3개를 저장하는 객체 C....
        contacts[count] = c; //연락처 객체를 배열에 저장... // arrayindex out of bounds 에러....
        count++; //배열에 저장된 연락처 개수를 1 증가...!!!
        System.out.println("새 연락처 저장 성공!");

    }//end of createContact....

    private void readContactByIndex() {

        System.out.println("---인덱스 검색---");
        System.out.print("검색할 인덱스를 입력해주세요 >> ");
        int index = Integer.parseInt(scanner.nextLine());
        if(index >= 0 && index < count) {		//MAX_LENGTH 로 생각하면 안된다. 현재 저장된 카운트를 고려해야함...!!
            //contacts[index] != null -> error  arrayindex out of bounds 
            System.out.println(contacts[index].toString()); //-> nullpointerException error...이거 해결하는 과제...
            //if-else로 해결하면 될듯....
        } else {
            System.out.println();
            System.out.println("찾고자 하는 인덱스값이 없어요...");
            System.out.println("정확한 값을 입력해 주세요...");
        }

    }//end of readContactByIndex...

    private void updateContact() {
        System.out.println("---연락처 수정---");
        System.out.print("수정할 인덱스를 입력해주세요 >> "); //인덱스를 입력받아서 이름,번호,메일 수정...
        //인덱스를 찾아서 수정한다....
        int index = Integer.parseInt(scanner.nextLine());
        if(index < 0 || index >= count) { //에러값을 미리 찾아서 setting...! 인덱스가 정상 범위 밖인 경우....!
            System.out.println();
            System.out.println("수정하고자 하는 인덱스값이 없어요...");
            System.out.println("정확한 값을 입력해 주세요...");
            return; //메서드 종료!
        }         
        
        System.out.println("수정 전 >> "+contacts[index].toString());
        
        
        //Contact[] contacts = new Contact[MAX_LENGTH];
        
        System.out.print("이름 >> ");
        String name = scanner.nextLine();
        
        
        System.out.print("번호 >> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 >> ");
        String email = scanner.nextLine();
        
//        방법 1) setter 사용...! 이 경우 이름, 번호, 메일중 한가지만 바꾸고자 할 때 적합해보임...!
//        contacts[index].setName(name);
//        contacts[index].setPhone(phone);
//        contacts[index].setEmail(email);

//        방법 2) 새 객체로 변경...! 
        contacts[index] = new Contact(name, phone, email);
        
        System.out.println("수정 후 >> "+contacts[index].toString());
        System.out.println("연락처 수정 성공....!");
        
    }//end of updateContact....



    private int showMainMenu() {

        System.out.println("----------------------------------------------------------");
        System.out.println("  0.종료 | 1.목록 | 2.새 연락처 | 3.인덱스 검색 | 4.수정  ");
        System.out.println("----------------------------------------------------------");
        System.out.println();
        System.out.print("메뉴를 선택하세요 >> ");
        int menu = Integer.parseInt(scanner.nextLine());
        return menu;

    }//end of showMainMenu....


}//end of class...
