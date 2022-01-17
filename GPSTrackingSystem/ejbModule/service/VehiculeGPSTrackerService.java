package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import connexion.Utile;
import dao.VehiculeDaoLocal;
import dao.VehiculeGPSTrackerDao;
import dao.VehiculeGPSTrackerDaoLocal;
import entities.Vehicule;
import entities.VehiculeGPSTracker;
import entities.VehiculeGPSTrackerKey;

@Stateless
public class VehiculeGPSTrackerService implements VehiculeGPSTrackerDao,VehiculeGPSTrackerDaoLocal{

	EntityManager em=Utile.getEntityManager();
	
	@Override
	public boolean create(VehiculeGPSTracker v) {
		em.merge(v);
		return true;
	}

	@Override
	public boolean delete(VehiculeGPSTrackerKey id) {
		VehiculeGPSTracker v=findById(id);
		if(v !=null) {
			em.remove(em.contains(v) ? v : em.merge(v));
			return true;
		}
		return false;
	}

	@Override
	public boolean update(VehiculeGPSTracker v) {
		VehiculeGPSTracker vehicule=findById(v.getId());
		if(vehicule!=null) {
				//em.merge(vehicule);
			vehicule.setDateDebut(v.getDateDebut());
			vehicule.setDateFin(v.getDateFin());
			vehicule.setVehicule(v.getVehicule());
			vehicule.setGpstracker(v.getGpstracker());
			em.merge(vehicule);
			//em.persist(vehicule);
				return true;
			}
		return false;
	}

	@Override
	public List<VehiculeGPSTracker> findAll() {
		return em.createQuery("select v from VehiculeGPSTracker v",VehiculeGPSTracker.class).getResultList();
	}

	@Override
	public VehiculeGPSTracker findById(VehiculeGPSTrackerKey id) {
		return em.find(VehiculeGPSTracker.class,id);
	}
	

}
