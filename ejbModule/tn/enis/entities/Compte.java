package tn.enis.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="T_COMPTE")/* changer le nom de la base*/
public class Compte implements Serializable /* specification jee*/{
	

	/**
	 * pour un clean code  
	 */
	private static final long serialVersionUID = 1L;
	
	@Id /*primary key */ 
	@GeneratedValue(strategy=GenerationType.AUTO)
	/* auto increment*/
	private Long rib;
	
	//@Column(name="NOM_CLIENT",length = 50,unique = true,nullable = false)
	@ManyToOne 
	@JoinColumn (name="id_Client")
	private Client client ;
	private float solde;
	
	public Compte() {/* specification jee*/
		super();
		
	}
	
	public Compte( Client client, float solde) {
		super();
		
		this.client = client;
		this.solde = solde;
	}
	
	

	public Compte(Long rib, Client client, float solde) {
		super();
		this.rib = rib;
		this.client = client;
		this.solde = solde;
	}

	public Long getRib() {
		return rib;
	}

	public void setRib(Long rib) {
		this.rib = rib;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rib == null) ? 0 : rib.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Compte other = (Compte) obj;
		if (rib == null) {
			if (other.rib != null) {
				return false;
			}
		} else if (!rib.equals(other.rib)) {
			return false;
		}
		return true;
	}
	
	

}
