package com.itwill.instagram.controller;
import com.itwill.instagram.model.InstaMember;
public class InstaMemberDaoImpl implements InstaMemberDao{

	//singleton....
	private static InstaMemberDaoImpl instance = null;
	
	private InstaMemberDaoImpl() {}
	
	public static InstaMemberDaoImpl getInstance() {
		if(instance == null) {
			instance = new InstaMemberDaoImpl();
		}
		return instance;
	}//singleton...
	
	public static final int MAX_LENGTH = 1;
	
	private InstaMember[] members = new InstaMember[MAX_LENGTH];
	
	private int count = 0;
	
	public int getCount() {
		return count;
	}
	
	@Override
	public InstaMember[] read() {
		InstaMember[] memberArray = new InstaMember[count];
		for(int i = 0; i<count; i++) {
			memberArray[i] = members[i];
		}
		return memberArray;
	}//Over_ride read()...

	@Override
	public int create(InstaMember instaMember) {
		int result = 0;
		if(count < MAX_LENGTH) {
			members[count] = instaMember;
			count++;
			result = 1;
		}
		return result;
	}//Over_ride create...

	@Override
	public InstaMember read(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}//end class InstaMemberDaoImpl....
