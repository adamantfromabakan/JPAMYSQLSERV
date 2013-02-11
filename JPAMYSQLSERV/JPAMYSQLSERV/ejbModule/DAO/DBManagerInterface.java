package DAO;

import javax.ejb.Remote;

@Remote
public interface DBManagerInterface {
	public String creategreetings(String name);
	
}
