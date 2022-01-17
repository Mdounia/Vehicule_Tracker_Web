package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class VehiculeGPSTracker implements Serializable{
	
	@EmbeddedId
	VehiculeGPSTrackerKey id=new VehiculeGPSTrackerKey() ;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@MapsId("vehiculeId")
    @JoinColumn(name = "vehicule_id")
	private Vehicule vehicule;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@MapsId("gpstrackerId")
    @JoinColumn(name = "gpstracker_id")
	private GPSTracker gpstracker;
	
	
	public VehiculeGPSTracker() {
		super();
	}


	public VehiculeGPSTracker(Date dateDebut, Date dateFin, Vehicule vehicule, GPSTracker gpstracker) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.vehicule = vehicule;
		this.gpstracker = gpstracker;
	}

	public VehiculeGPSTracker(VehiculeGPSTrackerKey id, Date dateDebut, Date dateFin, Vehicule vehicule,
			GPSTracker gpstracker) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.vehicule = vehicule;
		this.gpstracker = gpstracker;
	}


	public VehiculeGPSTrackerKey getId() {
		return id;
	}


	public void setId(VehiculeGPSTrackerKey id) {
		this.id = id;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public Vehicule getVehicule() {
		return vehicule;
	}


	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}


	public GPSTracker getGpstracker() {
		return gpstracker;
	}


	public void setGpstracker(GPSTracker gpstracker) {
		this.gpstracker = gpstracker;
	}


	@Override
	public String toString() {
		return "VehiculeGPSTracker [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", vehicule="
				+ vehicule + ", gpstracker=" + gpstracker + "]";
	}




	
	

}
