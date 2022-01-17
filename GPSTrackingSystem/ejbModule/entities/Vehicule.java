package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Vehicule implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String matricule;
	private String marque;
	private String type;
	@OneToMany(mappedBy = "vehicule")
	private List<VehiculeGPSTracker> vehiculeGPSTracker;
	
	
	public Vehicule() {
		super();
	}



	public Vehicule(int id, String matricule, String marque, String type) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.marque = marque;
		this.type = type;
	}

	public Vehicule(String matricule, String marque, String type) {
		super();
		this.matricule = matricule;
		this.marque = marque;
		this.type = type;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public List<VehiculeGPSTracker> getVehiculeGPSTracker() {
		return vehiculeGPSTracker;
	}
	public void setVehiculeGPSTracker(List<VehiculeGPSTracker> vehiculeGPSTracker) {
		this.vehiculeGPSTracker = vehiculeGPSTracker;
	}
	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", matricule=" + matricule + ", marque=" + marque + ", type=" + type
				+ ", vehiculeGPSTracker=" + vehiculeGPSTracker + "]";
	}

	
	
	

}
