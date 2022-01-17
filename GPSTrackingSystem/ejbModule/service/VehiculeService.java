package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import connexion.Utile;
import dao.VehiculeDao;
import dao.VehiculeDaoLocal;
import entities.Vehicule;

@Stateless
public class VehiculeService implements VehiculeDao,VehiculeDaoLocal{

	EntityManager em=Utile.getEntityManager();

	@Override
	public boolean create(Vehicule v) {
		em.persist(v);
		return true;
	}

	@Override
	public boolean delete(int id) {
		Vehicule v=findById(id);
		if(v !=null) {
			em.remove(em.contains(v) ? v : em.merge(v));
			return true;
		}
		return false;
	}

	
	@Override
	public boolean update(Vehicule v) {
		Vehicule vehicule=findById(v.getId());
		if(vehicule!=null) {
				//em.merge(vehicule);
			vehicule.setMatricule(v.getMatricule());
			vehicule.setMarque(v.getMarque());
			vehicule.setType(v.getType());
			em.persist(vehicule);
			return true;
			}
		return false;
	}

	@Override
	public List<Vehicule> findAll() {
		return em.createQuery("select v from Vehicule v",Vehicule.class).getResultList();
	}

	@Override
	public Vehicule findById(int id) {
		return em.find(Vehicule.class,id);
	}
}
