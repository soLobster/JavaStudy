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
	
	
	
	@Override
	public InstaMember[] read() {
		// TODO Auto-generated method stub
		return null;
	}//Over_ride read()...

	@Override
	public int create(InstaMember instaMember) {
		// TODO Auto-generated method stub
		return 0;
	}//Over_ride create...

}//end class InstaMemberDaoImpl....
