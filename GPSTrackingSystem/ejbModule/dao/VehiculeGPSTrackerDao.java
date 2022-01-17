package dao;

import java.util.List;

import javax.ejb.Remote;

import entities.VehiculeGPSTracker;
import entities.VehiculeGPSTrackerKey;


@Remote
public interface VehiculeGPSTrackerDao {
	boolean create(VehiculeGPSTracker v);
	boolean delete (VehiculeGPSTrackerKey id);
	boolean update(VehiculeGPSTracker v);
	List<VehiculeGPSTracker> findAll();
	VehiculeGPSTracker findById(VehiculeGPSTrackerKey id);

}
