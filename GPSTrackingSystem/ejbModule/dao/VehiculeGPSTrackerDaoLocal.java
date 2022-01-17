package dao;

import java.util.List;

import javax.ejb.Local;

import entities.VehiculeGPSTracker;
import entities.VehiculeGPSTrackerKey;

@Local
public interface VehiculeGPSTrackerDaoLocal {
	boolean create(VehiculeGPSTracker v);
	boolean delete (VehiculeGPSTrackerKey id);
	boolean update(VehiculeGPSTracker v);
	List<VehiculeGPSTracker> findAll();
	VehiculeGPSTracker findById(VehiculeGPSTrackerKey id);

}
