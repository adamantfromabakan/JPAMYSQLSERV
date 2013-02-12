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
	public String updategreetings(long id, String newname) {
		String result = null;
		try {
			greetings gr = new greetings();
			gr=greetingsfacade.find(id);
			if (gr != null) {
				gr.setName(newname);
				greetingsfacade.edit(gr); 
				result = "Row updated: ID " + id + " new NAME " + newname;
				}
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
			if (gr != null) {
			greetingsfacade.remove(gr);
			result = "Row deleted: ID " + id;
			}
					} catch (Exception e) {
				result = Level.SEVERE + " Caught Exception processing object " + e;
				//System.out.println(Level.SEVERE + " Caught Exception processing object " + e);
			}
		
		return result;
	}

	@Override
	public Collection<greetings> findAllGreetings() {
		return (Collection<greetings>) greetingsfacade.findAll();
	}

	@Override
	public Collection<greetings> findGreetingsId(long id) {
		return (Collection<greetings>) greetingsfacade.findById(id);
	}
	
	

			

}
