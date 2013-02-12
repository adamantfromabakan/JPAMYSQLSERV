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
	   
	   public List<greetings> findById(long id)  {
		   Query query = em.createQuery("select g from greetings g where g.id = :id").setParameter("id", id);
		   List<greetings> res = query.getResultList();
	       return res; //.getSingleResult();
	   }

	
	//	GreetingsFacade GF = new GreetingsFacade(greetings);

	
	



	
	//public GreetingsFacade() {
	//	super(Greetings.class);
	//}



	
	
}
