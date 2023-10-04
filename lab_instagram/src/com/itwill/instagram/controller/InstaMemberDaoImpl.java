package com.itwill.instagram.controller;
import com.itwill.instagram.model.InstaMember;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

//DAO Data Accesss Object...

public class InstaMemberDaoImpl implements InstaMemberDao{

	//singleton....
	private static InstaMemberDaoImpl instance = null;
	
	public InstaMemberDaoImpl() {}
	
	public static InstaMemberDaoImpl getInstance() {
		if(instance == null) {
			instance = new InstaMemberDaoImpl();
		}
		return instance;
	}//singleton...
	
	Scanner sc = new Scanner(System.in);
	List<InstaMember> members = new ArrayList<>();
	
	
	public void run() {
		int key = 0;
		while((key = menu())!= 0) {
			switch(key) {
			case 1:
				Login();
				break;
			case 2:
				MemberJoin();
				break;
			case 3:
				SelectMember();
				
			}
		}
	}
	
	
	private void SelectMember() {
		Iterator<InstaMember> ite = members.iterator();
		
		while(ite.hasNext()) {
			System.out.println(ite.next() + " ");
		}
		
	}

	private void MemberJoin() {
		sc.nextLine();
		String id = getStrInput(" ID  : ");
		String password = getStrInput(" Password : ");
		String password2 = getStrInput(" Password Confirm : ");
		String email = getStrInput(" E-MAIL : ");
		String name = getStrInput(" Name : ");
		String phone = getStrInput("PHONE NUMBER : ");
		
		if(idCheck(id)) {
			System.out.println("중복된 ID 입니다.");
		} else if(password.equals(password2)) {
			members.add(new InstaMember(id, password, email, name, phone));
			System.out.println(id+" 님 가입을 축하드립니다.");
		} else {
			System.out.println("비밀번호를 확인해주세요...");
		}
	}

	private boolean idCheck(String id) {
		boolean check = true;
		InstaMember member = FindByid(id);
		if(member == null) 
			check = false;
		
		return false;
	}
	
	private void Login() {
		sc.nextLine();
		String id = getStrInput(" ID : ");
		String password = getStrInput("PASSWORD : ");
		
		InstaMember member = FindByid(id);
		if(member == null) {
			System.out.println("등록되지 않은 아이디 입니다.");
		} else if(member.getPassword().equals(password)) {
			System.out.println("["+member.getId()+"] 님께서 로그인 하셨습니다.");
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}

	private InstaMember FindByid(String id) {
		for(InstaMember member : members) {
			if(member.getId().equals(id)) {
				return member;
			}
		}
		return null;
	}

	private String getStrInput(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}

	
	private int menu() {
		System.out.println("*****INSTAGRAM*****");
		return getNumInput("1.Sign In 2.Sign Up 3.Find ID or Password 0.EXIT");
	}

	private int getNumInput(String msg) {
		System.out.println(msg);
		System.out.print("select Menu >> ");
		return Integer.parseInt(sc.nextLine());
		
	}

//	@Override
//	public InstaMember[] read() {
//		InstaMember[] memberArray = new InstaMember[count];
//		for(int i = 0; i<count; i++) {
//			memberArray[i] = members[i];
//		}
//		return memberArray;
//	}//Over_ride read()...
//
//	@Override
//	public int create(InstaMember instaMember) {
//		int result = 0;
//		if(count < MAX_LENGTH) {
//			members[count] = instaMember;
//			count++;
//			result = 1;
//		}
//		return result;
//	}//Over_ride create...
//
//	@Override
//	public InstaMember read(String phone, String email) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}//end class InstaMemberDaoImpl....
