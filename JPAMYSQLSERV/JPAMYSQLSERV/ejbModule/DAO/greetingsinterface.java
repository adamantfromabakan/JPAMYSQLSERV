package DAO;

import java.util.Collection;

import javax.ejb.Remote;

@Remote

public interface greetingsinterface {
	public String INS_GREETINGS(String name);
	public String UPD_GREETINGS(int id,String newname);
	public String REM_GREETINGS(long id);
	public Collection<greetings> findAllGreetings(); 
	public greetings FindGreetings(int id);	
}
