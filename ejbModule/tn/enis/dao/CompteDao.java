package tn.enis.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.enis.entities.Client;
import tn.enis.entities.Compte;

/**
 * Session Bean implementation class CompteDao
 */
@Singleton
@LocalBean
public class CompteDao {
	
	@PersistenceContext
	private EntityManager em;/*init tout seul*/
	
	
	public Compte getById(Long rib) {
		
		return em.find(Compte.class, rib);
		
	}
	
	public void save(Compte compte) {
		em.persist(compte);
}
	
	public void delete(Compte compte) {
		em.remove(compte);
		
	}
	
	public void update(Compte compte) {
		em.merge(compte);
		
	}
	
	
	public List<Compte> getAll(){
		
		/*Ejb querry language =- Hibernate QL et JPA QL --> sql oriented object*/
		 return em.createQuery("SELECT cp FROM Compte cp ", Compte.class).getResultList();
		
	}
	
	
	
}