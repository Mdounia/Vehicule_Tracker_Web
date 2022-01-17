package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import connexion.Utile;
import dao.GPSTrackerDao;
import dao.GPSTrackerDaoLocal;
import entities.GPSTracker;

@Stateless
public class GPSTrackerService implements GPSTrackerDao,GPSTrackerDaoLocal{
	
	EntityManager em=Utile.getEntityManager();

	@Override
	public boolean create(GPSTracker g) {
		em.persist(g);
		return true;
	}

	@Override
	public boolean delete(int id) {
		GPSTracker g=findById(id);
		if(g !=null) {
			em.remove(em.contains(g) ? g : em.merge(g));
			return true;
		}
		return false;
	}

	@Override
	public boolean update(GPSTracker g) {
		GPSTracker tracker=findById(g.getId());
		if(tracker !=null) {
			//em.merge(tracker);
			tracker.setSimNumber(g.getSimNumber());
			tracker.setImei(g.getImei());
			em.persist(tracker);
			return true;
		}
		return false;
	}

	@Override
	public List<GPSTracker> findAll() {
		return em.createQuery("select g from GPSTracker g",GPSTracker.class).getResultList();
	}

	@Override
	public GPSTracker findById(int id) {
		return em.find(GPSTracker.class,id);
	}

	@Override
	public GPSTracker findByIMEI(String imei) {
		// TODO Auto-generated method stub
		return em.find(GPSTracker.class,imei);
	}

}
