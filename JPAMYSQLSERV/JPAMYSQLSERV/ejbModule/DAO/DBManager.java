package DAO;

import java.util.Collection;
import java.util.logging.Level;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class DBManager
 */
@Stateless
//@LocalBean
public class DBManager implements DBManagerInterface{
	
	@EJB
	GreetingsFacade greetingsfacade;

	@Override
	public String creategreetings(String name) {
		String result = null;
		try {
		greetings gr = new greetings();
		gr.setName(name);
		greetingsfacade.create(gr);
		result = "Row inserted: " + name;//JPAMYSQL.test.test1(name);
		} 
	catch (Exception e) {
			result = Level.SEVERE + " Caught Exception processing object " + e;
			//System.out.println(Level.SEVERE + " Caught Exception processing object " + e);
		}
	return result;
				
	}

	@Override
	public String updategreetings(int id, String newname) {
		String result = null;
		try {
			
				result = "Row updated: ID " + id + " new NAME " + newname;
		} catch (Exception e) {
			result = Level.SEVERE + " Caught Exception processing object " + e;
			//System.out.println(Level.SEVERE + " Caught Exception processing object " + e);
		}
		return result;
	}

	@Override
	public String removegreetings(long id) {
		String result = null;
		try {
			greetings gr = new greetings();
			gr=greetingsfacade.find(id);
			greetingsfacade.remove(gr);
		
		result = "Row deleted: ID " + id;
			} catch (Exception e) {
				result = Level.SEVERE + " Caught Exception processing object " + e;
				//System.out.println(Level.SEVERE + " Caught Exception processing object " + e);
			}
		
		return result;
	}

	@Override
	public Collection<greetings> findAllGreetings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public greetings findGreetingsId(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

			

}
