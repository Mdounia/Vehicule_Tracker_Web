package service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import connexion.Utile;
import dao.PositionDao;
import dao.PositionDaoLocal;
import entities.GPSTracker;
import entities.Position;
import entities.VehiculeGPSTracker;
@Stateless
public class PositionService implements PositionDao,PositionDaoLocal{
	EntityManager em=Utile.getEntityManager();
	@Override
	public boolean create(Position p) {
		em.merge(p);
		return true;
	}

	@Override
	public boolean delete(int id) {
		Position p=findById(id);
		if(p !=null) {
			em.remove(em.contains(p) ? p : em.merge(p));
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Position p) {
		Position position=findById(p.getId());
		if(position !=null) {
			//em.merge(tracker);
			position.setLongitude(p.getLongitude());
			position.setLatitude(p.getLatitude());
			position.setDate(p.getDate());
			position.setGpsTracker(p.getGpsTracker());
			em.merge(position);
			return true;
		}
		return false;
	}

	@Override
	public List<Position> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Position p",Position.class).getResultList();
	}

	@Override
	public Position findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Position.class,id);
	}

	@Override
	public String count(int id) {
		// TODO Auto-generated method stub
		return em.createQuery("select COUNT(p.id) from Position p where p.gpsTracker.id = '"+id+"'").getSingleResult().toString();
	}



}
