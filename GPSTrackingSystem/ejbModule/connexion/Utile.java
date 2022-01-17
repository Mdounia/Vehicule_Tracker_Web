package connexion;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Utile {

	private static EntityManager em;
	
	static {
		em=Persistence.createEntityManagerFactory("GPSTrackingSystem").createEntityManager();
	}
	private Utile() {
		// TODO Auto-generated constructor stub
	}
	public static EntityManager getEntityManager() {
		return em;
	}
	

}
