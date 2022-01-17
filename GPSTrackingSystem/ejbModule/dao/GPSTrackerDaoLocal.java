package dao;

import java.util.List;

import javax.ejb.Local;

import entities.GPSTracker;

@Local
public interface GPSTrackerDaoLocal {
	boolean create(GPSTracker g);
	boolean delete (int id);
	boolean update(GPSTracker g);
	List<GPSTracker> findAll();
	GPSTracker findById(int id);
	GPSTracker findByIMEI(String imei);

}
