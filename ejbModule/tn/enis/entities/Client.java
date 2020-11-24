package tn.enis.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_CLIENT") /* changer le nom de la base */
public class Client implements Serializable { /* specification jee */
	/**
	 * pour un clean code
	 */
	private static final long serialVersionUID = 1L;

	@Id /* primary key */
	private String cin;

	private String nom;
	private String prenom;
	private String addresse;

	// relation bidirectionnelle optionnnelle
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Compte> comptes;

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Client() {
		super();
		// il est recommandé
	}

	public Client(String cin, String nom, String prenom, String addresse) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
	}

	public Client(String nom, String prenom, String addresse) {
		super();

		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
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
		Client other = (Client) obj;
		if (cin == null) {
			if (other.cin != null) {
				return false;
			}
		} else if (!cin.equals(other.cin)) {
			return false;
		}
		return true;
	}

}
