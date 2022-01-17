package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GPSTrackerDaoLocal;
import dao.PositionDaoLocal;
import entities.GPSTracker;
import entities.Position;
import entities.Vehicule;

/**
 * Servlet implementation class PositionController
 */
@WebServlet("/Position")
public class PositionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PositionDaoLocal service;
	
	@EJB
	private  GPSTrackerDaoLocal gpsTrackerService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PositionController() {
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
		case "create_Position":
			List<GPSTracker>gpsTrackers=gpsTrackerService.findAll();
			request.setAttribute("gpsTrackers", gpsTrackers);
			url="/vues/createPosition.jsp";
			break;
		case "Ajouter":
			double longitude =Double.parseDouble(request.getParameter("longitude"));
			double latitude =Double.parseDouble(request.getParameter("latitude"));
			String date= request.getParameter("date").replace("-", "/");
			int gpsTrackerId=Integer.parseInt(request.getParameter("GPSId"));
			GPSTracker g=gpsTrackerService.findById(gpsTrackerId);
			Position position=new Position(longitude,latitude,new Date(date),g);
			service.create(position);
			request.setAttribute("positions",service.findAll());
			url = "/vues/listPosition.jsp";
			break;
		case "suppression":
			int id=Integer.parseInt(request.getParameter("id"));
			//System.err.println("id : "+id);
			service.delete(id);
			request.setAttribute("positions",service.findAll());
			url = "/vues/listPosition.jsp";
			break;
		case "details":
			int id1=Integer.parseInt(request.getParameter("id"));
			Position position2=service.findById(id1);
			request.setAttribute("position", position2);
			url="/vues/positionDetails.jsp";
			break;
		case "Modification":
			int id2=Integer.parseInt(request.getParameter("id"));
			double longitude1 =Double.parseDouble(request.getParameter("longitude"));
			double latitude1 =Double.parseDouble(request.getParameter("latitude"));
			String date1= request.getParameter("date").replace("-", "/");
			int gpsTrackerId1=Integer.parseInt(request.getParameter("GPSId"));
			GPSTracker g1=gpsTrackerService.findById(gpsTrackerId1);
			Position p=new Position(longitude1,latitude1,new Date(date1),g1);
			p.setId(id2);
			service.update(p);
			request.setAttribute("positions",service.findAll());
			url = "/vues/listPosition.jsp";
			break;
		default:
			request.setAttribute("positions",service.findAll());
			url = "/vues/listPosition.jsp";
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
