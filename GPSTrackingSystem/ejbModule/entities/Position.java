package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Position implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double longitude;
	private double latitude;
	private Date date;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private GPSTracker gpsTracker;
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Position(double longitude, double latitude, Date date, GPSTracker gpsTracker) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.date = date;
		this.gpsTracker = gpsTracker;
	}
	public Position(int id, double longitude, double latitude, Date date, GPSTracker gpsTracker) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.date = date;
		this.gpsTracker = gpsTracker;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public GPSTracker getGpsTracker() {
		return gpsTracker;
	}
	public void setGpsTracker(GPSTracker gpsTracker) {
		this.gpsTracker = gpsTracker;
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", date=" + date
				+ ", gpsTracker=" + gpsTracker + "]";
	}
	
	

}
