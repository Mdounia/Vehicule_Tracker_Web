package dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entities.GPSTracker;
import entities.Position;

@Local
public interface PositionDaoLocal {
	
	boolean create(Position p);
	boolean delete (int id);
	boolean update(Position p);
	List<Position> findAll();
	Position findById(int id);	
	String count(int id);

}
