package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Director;
import es.salesianos.service.DirectorService;

@WebServlet("/addDirectorServlet ")

public class AddDirectorServlet extends HttpServlet{

private DirectorService service = new DirectorService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost in AddDirectorServlet...");
		System.out.println("name: " + req.getParameter("name"));
		Director director = service.assembleOwnerFromRequest(req);
		service.addDirector(director);
		
		//This piece pulls out all the directors from the Database
		List<Director> listAllDirectores = service.listAllDirectores();
		req.setAttribute("listAllDirectores", listAllDirectores);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listDirectors.jsp");
		dispatcher.forward(req,resp);
	}
}
