package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class GPSTrackerController
 */
@WebServlet("/GPSTracker")
public class GPSTrackerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private  GPSTrackerDaoLocal service;
	@EJB
	private PositionDaoLocal position;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GPSTrackerController() {
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
		case "create_GPSTracker":
			url="/vues/listGPSTracker.jsp";
			break;
		case "Ajouter":
			String simNumber=request.getParameter("simNumber");
			String imei=request.getParameter("imei");
			GPSTracker g=new GPSTracker(simNumber,imei);
			service.create(g);
			request.setAttribute("trackers",service.findAll());
			url = "/vues/listGPSTracker.jsp";
			break;
		case "suppression":
			int id=Integer.parseInt(request.getParameter("id"));
			service.delete(id);
			request.setAttribute("trackers",service.findAll());
			url = "/vues/listGPSTracker.jsp";
			break;
		case "details":
			int id1=Integer.parseInt(request.getParameter("id"));
			GPSTracker gpsTracker=service.findById(id1);
			request.setAttribute("gpsTracker", gpsTracker);
			url="/vues/gpsTrackerDetails.jsp";
			break;
		case "Modification":
			int id2=Integer.parseInt(request.getParameter("id"));
			String simNumber1=request.getParameter("simNumber");
			String imei1=request.getParameter("imei");
			GPSTracker g1=new GPSTracker(simNumber1,imei1);
			g1.setId(id2);
			service.update(g1);
			request.setAttribute("trackers",service.findAll());
			url = "/vues/listGPSTracker.jsp";
			break;	
		case "reporting":
			
		default:
			List<String> nbrs=new ArrayList<String>();
			List<GPSTracker>trackers=service.findAll();
			for(GPSTracker gt:trackers) {
				nbrs.add( position.count(gt.getId()));
			}
			request.setAttribute("nbrs",nbrs);
			url = "/vues/listGPSTracker.jsp";
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
