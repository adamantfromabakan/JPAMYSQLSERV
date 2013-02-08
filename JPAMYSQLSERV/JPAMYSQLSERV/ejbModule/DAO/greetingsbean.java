package DAO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.logging.Level;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
//@Stateful
//@Remote(greetingsinterface.class)

public class greetingsbean implements greetingsinterface {
//	public EntityManagerFactory emf;
	@PersistenceContext(unitName="JPAMYSQLSERV")
	public EntityManager em;
	//public String PERSISTENCE_UNIT_NAME = "JPAMYSQLSERV";

	@Override
    public String INS_GREETINGS(String name) {
		String result = null;
		try {
		greetings gr = new greetings();
		gr.setName(name);
		em.persist(gr);
				result = "Row inserted: " + name;//JPAMYSQL.test.test1(name);
		} 
	catch (Exception e) {
			result = Level.SEVERE + " Caught Exception processing object " + e;
			//System.out.println(Level.SEVERE + " Caught Exception processing object " + e);
		}
	
	return result;


//		EntityManagerFactory emf;
//		EntityManager em = null;
//		String PERSISTENCE_UNIT_NAME = "JPAMYSQLSERV";
//	    emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//	    em = emf.createEntityManager();
//	    em.getTransaction().begin();
	    
		//em.persist(new greetings(name));
		
		
//	    em.getTransaction().commit();
//	    em.close();
//	    emf.close();
	    
	    //greetings gr  = new greetings();
	    //gr = findgreetings(1);	
	    //String gName;
	    //gName = gr.getName();
	    //gr.getName();
		
		//JPAMYSQL.test.test2(name);
	    //em.find(greetings.class, 1)

	
    }
	
	 public greetings FindGreetings(int id) {
		    return em.find(greetings.class, id);
	   }
	 
	 public greetings findById(long id) {
	       return (greetings) em.createQuery(
	        "select g from greetings g where g.id = :id").setParameter("id", id).getSingleResult();
	   
	   }
	 
	  @SuppressWarnings("unchecked")
	  public Collection<greetings> findAllGreetings() 
	     {
		System.out.println("\n\t Inside findAllEmployees()");
	        Query query = em.createQuery("SELECT g FROM greetings g");
	        return (Collection<greetings>) query.getResultList();
	     }

	@Override
	public String UPD_GREETINGS(int id, String newname) {
		String result = null;
		try {
		greetings gr = findById(id);
		if (gr != null) {
			gr.setName(newname);
			em.merge(gr);
		}
		result = "Row updated: ID " + id + " new NAME " + newname;
		} catch (Exception e) {
			result = Level.SEVERE + " Caught Exception processing object " + e;
			//System.out.println(Level.SEVERE + " Caught Exception processing object " + e);
		}
	
	return result;

	}

	@Override
	public String REM_GREETINGS(long id) {
		String result = null;
		try {
		greetings gr = findById(id);
		if (gr != null) {
			em.remove(gr);
		}
		
		
		result = "Row deleted: ID " + id;
			} catch (Exception e) {
				result = Level.SEVERE + " Caught Exception processing object " + e;
				//System.out.println(Level.SEVERE + " Caught Exception processing object " + e);
			}
		
		return result;
	}

}
