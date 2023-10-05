package com.itwill.list04;

import java.util.ArrayList;

public class ListMain04 {

    public static void main(String[] args) {
        // Member 타입을 저장하는 ArrayList를 선언, 객체 생성.
        ArrayList<Member> members = new ArrayList<Member>();
        
        members.add(new Member("admin","1234"));
        members.add(new Member("guest","0000"));
        members.add(new Member("guest2","1111"));
        members.add(new Member("guest3","2222"));
        members.add(new Member("itwill","0410"));

        //members의 내용을 출력
        System.out.println(members);

        System.out.println("------------------------------");
        
        //향상된 for 구문사용 members의 원소들을 출력...
        for(Member x : members) {
            System.out.println(x);
        }
        
        System.out.println("----------------------------");
        //회원 아이디에 est가 포함된 모든 회원들을 찾아서 저장하는 ArrayList를 만들고 출력.
        ArrayList<Member> est = new ArrayList<>();
        for(Member m : members) {
            if(m.getId().contains("est")) {
                est.add(m);
            }
        }
        System.out.println(est);
        System.out.println("=====================");
        
//        for(int i=0; i<members.size(); i++) {
//            if(members.get(i).getId().contains("est")) {
//                est.add(members.get(i));
//            }
//            
//        }System.out.println(est);
//        
//        System.out.println("=====================");
        //리스트에서 원소 삭제...
        //리스트에서 members에서 아이디가 "guest"인 (첫번째) 회원 삭제..
       for(int i =0; i<members.size(); i++) {
           if(members.get(i).getId().equals("guest")) {
               members.remove(i);
               break;
           }
       }
       System.out.println(members);
       
//       for(Member m : members) {
//           if(m.getId().equals("guest2")) {
//               members.remove(m);
//               break;
//           }
//       }
//       
//       System.out.println(members);
      
     System.out.println("==================");  
    members.remove(new Member("itwill", null));
    System.out.println(members);
    
//    members.remove(new Member("guest",null));
//    //생성자 호출할때마다 새로운 객체가 생성된다.
//    //이방법은 equals와 hashcode over_ride 필요...
//       
//       
//    System.out.println(members);
    }
    
}
