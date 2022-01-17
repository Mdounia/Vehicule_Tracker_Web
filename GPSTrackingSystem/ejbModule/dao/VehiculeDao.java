package dao;

import java.util.List;

import javax.ejb.Remote;

import entities.Vehicule;


@Remote
public interface VehiculeDao {
	boolean create(Vehicule v);
	boolean delete (int id);
	boolean update(Vehicule v);
	List<Vehicule> findAll();
	Vehicule findById(int id);
}
