package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import tn.enis.dao.ClientDao;
import tn.enis.entities.Client;
import tn.enis.entities.Compte;

/**
 * Session Bean implementation class ClientService
 */
@Stateless
@LocalBean
@Path("/clients/")
public class ClientService {

	@EJB
	private ClientDao dao;

	public void save(Client client) {
		dao.save(client);

	}

	public Client getById(String cin) {

		return dao.getById(cin);

	}

	public void delete(String cin) {
		Client client = getById(cin);
		dao.delete(client);

	}

	public void update(Client client) {
		dao.update(client);

	}

	public List<Client> getAll() {

		return dao.getAll();

	}


	
}
