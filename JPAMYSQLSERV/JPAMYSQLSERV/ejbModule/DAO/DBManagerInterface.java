package DAO;

import java.util.Collection;

import javax.ejb.Remote;

@Remote
public interface DBManagerInterface {
	public String creategreetings(String name);
	public String updategreetings(int id,String newname);
	public String removegreetings(long id);
	public Collection<greetings> findAllGreetings();
	public greetings findGreetingsId(long id);
	
}
