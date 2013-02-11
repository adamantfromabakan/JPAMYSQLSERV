package DAO;

import java.nio.channels.Channel;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import DAO.AbstractFacade;

@Stateless
public class GreetingsFacade extends AbstractFacade<greetings>{
	
	@PersistenceContext(unitName = "JPAMYSQLSERV")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public GreetingsFacade() {
		super(greetings.class);
	}

	   public List<greetings> findByNameUpdated() {
	       Query query = em.createQuery("SELECT c FROM greetings c WHERE c.name like '%UPDATED%'");
	       @SuppressWarnings("unchecked")
	       List<greetings> res = query.getResultList();
	       return res;
	   }
	   
	   public greetings findById(long id) {
	       return (greetings) em.createQuery(
	        "select g from greetings g where g.id = :id").setParameter("id", id).getSingleResult();
	   }

	
	//	GreetingsFacade GF = new GreetingsFacade(greetings);

	
	



	
	//public GreetingsFacade() {
	//	super(Greetings.class);
	//}



	
	
}
