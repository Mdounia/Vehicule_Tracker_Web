package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VehiculeGPSTrackerKey implements Serializable{
	
	@Column(name = "vehicule_id")
    int vehiculeId;

    @Column(name = "gpstracker_id")
    int gpstrackerId;

	public VehiculeGPSTrackerKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehiculeGPSTrackerKey(int vehiculeId, int gpstrackerId) {
		super();
		this.vehiculeId = vehiculeId;
		this.gpstrackerId = gpstrackerId;
	}

	public int getVehiculeId() {
		return vehiculeId;
	}

	public void setVehiculeId(int vehiculeId) {
		this.vehiculeId = vehiculeId;
	}

	public int getGpstrackerId() {
		return gpstrackerId;
	}

	public void setGpstrackerId(int gpstrackerId) {
		this.gpstrackerId = gpstrackerId;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


    
    

}
