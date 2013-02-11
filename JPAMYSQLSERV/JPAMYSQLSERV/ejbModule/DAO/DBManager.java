package DAO;

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
	@PersistenceContext(unitName="JPAMYSQLSERV")
	
	@EJB
	GreetingsFacade greetingsfacade;

	@Override
	public String creategreetings(String name) {
		greetings gr = new greetings();
		gr.setName(name);
		greetingsfacade.create(gr);
		return null;
	}

}
