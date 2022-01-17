package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VehiculeDaoLocal;
import entities.Vehicule;



/**
 * Servlet implementation class VehiculeController
 */
@WebServlet("/Vehicule")
public class VehiculeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private  VehiculeDaoLocal service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehiculeController() {
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
		case "create_Vehicule":
			url="/vues/createVehicule.jsp";
			break;
		case "Ajouter":
			//take whats in the fields
			String matricule=request.getParameter("matricule");
			String marque=request.getParameter("marque");
			String type=request.getParameter("type");
			//add the product now
			Vehicule v=new Vehicule(matricule,marque,type);
			service.create(v);
			request.setAttribute("vehicules",service.findAll());
			url = "/vues/listVehicule.jsp";
			break;
		case "suppression":
			int id=Integer.parseInt(request.getParameter("id"));
			//System.err.println("id : "+id);
			service.delete(id);
			request.setAttribute("vehicules",service.findAll());
			url = "/vues/listVehicule.jsp";
			break;
		case "details":
			int id1=Integer.parseInt(request.getParameter("id"));
			Vehicule vehicule=service.findById(id1);
			request.setAttribute("vehicule", vehicule);
			url="/vues/vehiculeDetails.jsp";
			break;
		case "Modification":
			int id2=Integer.parseInt(request.getParameter("id"));
			String mat=request.getParameter("matricule");
			String mar=request.getParameter("marque");
			String ty=request.getParameter("type");
			Vehicule v1 = new Vehicule(mat,mar,ty);
			v1.setId(id2);
			service.update(v1);
			request.setAttribute("vehicules",service.findAll());
			url = "/vues/listVehicule.jsp";
			break;
		default:
			request.setAttribute("vehicules",service.findAll());
			url = "/vues/listVehicule.jsp";
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
