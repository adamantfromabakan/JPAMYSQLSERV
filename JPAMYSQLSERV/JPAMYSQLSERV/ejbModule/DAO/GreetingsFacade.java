package DAO;

import java.nio.channels.Channel;

import javax.persistence.EntityManager;

public class GreetingsFacade extends AbstractFacade<greetings>    {
 
	public GreetingsFacade(Class<greetings> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
