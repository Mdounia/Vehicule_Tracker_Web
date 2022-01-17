package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GPSTrackerDaoLocal;
import dao.VehiculeDaoLocal;
import dao.VehiculeGPSTrackerDaoLocal;
import entities.GPSTracker;
import entities.Vehicule;
import entities.VehiculeGPSTracker;
import entities.VehiculeGPSTrackerKey;

/**
 * Servlet implementation class VehiculeGPSTrackerController
 */
@WebServlet("/VehiculeGPSTracker")
public class VehiculeGPSTrackerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private VehiculeGPSTrackerDaoLocal affectationService;
	@EJB
	private  GPSTrackerDaoLocal gpsTrackerService;
	@EJB
	private  VehiculeDaoLocal VehiculeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehiculeGPSTrackerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="index.jsp";
		String action="home";
		if(request.getParameter("action")!=null) {
			action=request.getParameter("action");
		}
		
		switch(action) {
		case "affecter":

			List<VehiculeGPSTracker> vgts=affectationService.findAll();
			List<Vehicule>vehicules=VehiculeService.findAll();
			List<Vehicule> removedVehicules=new ArrayList();
			for(Vehicule v :vehicules) {
				for(VehiculeGPSTracker vg:vgts) {
					if(v.getMatricule()==vg.getVehicule().getMatricule()) {
						removedVehicules.add(v);
					}
				}
			}
			vehicules.removeAll(removedVehicules);	

			request.setAttribute("vehicules", vehicules);
			List<GPSTracker>gpsTrackers=gpsTrackerService.findAll();
			request.setAttribute("gpsTrackers", gpsTrackers);
			url="/vues/affectation.jsp";
			break;
		case "Ajouter":
			int vehiculeId=Integer.parseInt(request.getParameter("vehId"));
			int gpsTrackerId=Integer.parseInt(request.getParameter("GPSId"));
			String dateDebut= request.getParameter("dateDebut").replace("-", "/");
			Vehicule v=VehiculeService.findById(vehiculeId);
			GPSTracker g=gpsTrackerService.findById(gpsTrackerId);
			VehiculeGPSTracker a=new VehiculeGPSTracker(new Date(dateDebut),null,v,g);
			affectationService.create(a);
			request.setAttribute("affectations",affectationService.findAll());
			url = "/vues/listAffectation.jsp";
			break;
		case "suppression":
			int idV= Integer.parseInt(request.getParameter("vehiculeId"));
			int idG= Integer.parseInt(request.getParameter("gpstrackerId"));
			VehiculeGPSTrackerKey k=new VehiculeGPSTrackerKey(idV,idG);
			//int id=Integer.parseInt(request.getParameter("id"));
			affectationService.delete(k);
			request.setAttribute("affectations",affectationService.findAll());
			url = "/vues/listAffectation.jsp";
			break;
		case "details":
			int idVeh1= Integer.parseInt(request.getParameter("vehiculeId"));
			int idGps1= Integer.parseInt(request.getParameter("gpstrackerId"));
			VehiculeGPSTrackerKey key1=new VehiculeGPSTrackerKey(idVeh1,idGps1);
			VehiculeGPSTracker affectation=affectationService.findById(key1);
			request.setAttribute("affectation", affectation);
			url="/vues/affectationDetails.jsp";
			break;
		case "Desaffectation":
			int idVeh= Integer.parseInt(request.getParameter("vehiculeId"));
			int idGps= Integer.parseInt(request.getParameter("gpstrackerId"));
			VehiculeGPSTrackerKey key=new VehiculeGPSTrackerKey(idVeh,idGps);
			String dateDebut1= request.getParameter("dateDebut").replace("-", "/");
			String dateFin= request.getParameter("dateFin").replace("-", "/");
			Vehicule v1=VehiculeService.findById(idVeh);
			GPSTracker g1=gpsTrackerService.findById(idGps);		
			VehiculeGPSTracker a1=new VehiculeGPSTracker(new Date(dateDebut1),new Date(dateFin),v1,g1);
			a1.setId(key);
			affectationService.update(a1);
			request.setAttribute("affectations",affectationService.findAll());
			url = "/vues/listAffectation.jsp";
			break;
			
		default:
			request.setAttribute("affectations",affectationService.findAll());
			url = "/vues/listAffectation.jsp";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
