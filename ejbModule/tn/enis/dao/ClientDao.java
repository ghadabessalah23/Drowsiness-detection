package tn.enis.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.enis.entities.Client;
import tn.enis.entities.Compte;

/**
 * Session Bean implementation class ClientDao
 */
@Singleton
@LocalBean
public class ClientDao {
	
	@PersistenceContext
	private EntityManager em;/*init tout seul*/
	@EJB
	private CompteDao dao;

public Client getById(String cin) {
		
		return em.find(Client.class, cin);
		
	}
	
	public void save(Client client) {
		em.persist(client);
}
	
	public void delete(Client client) {
		em.remove(client);
		
	}
	
	public void update(Client client) {
		em.merge(client);
		
	}
	
	
	public List<Client> getAll(){
		
		/*Ejb querry language =- Hibernate QL et JPA QL --> sql oriented object*/
		 return em.createQuery("SELECT cl FROM Client cl ", Client.class).getResultList();
		
	}
	
	
 
	

}
