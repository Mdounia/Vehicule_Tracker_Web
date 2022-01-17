package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Vehicule;
@Local
public interface VehiculeDaoLocal {
	boolean create(Vehicule v);
	boolean delete (int id);
	boolean update(Vehicule v);
	List<Vehicule> findAll();
	Vehicule findById(int id);

}
