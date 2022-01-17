package dao;

import java.util.List;

import javax.ejb.Remote;

import entities.GPSTracker;


@Remote
public interface GPSTrackerDao {
	boolean create(GPSTracker g);
	boolean delete (int id);
	boolean update(GPSTracker g);
	List<GPSTracker> findAll();
	GPSTracker findById(int id);
	GPSTracker findByIMEI(String imei);
}
