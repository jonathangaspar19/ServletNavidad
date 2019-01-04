package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.service.ActorService;

/**
 * Servlet implementation class AddActorServlet
 */
@WebServlet("/addActorServlet ")
public class AddActorServlet extends HttpServlet {
private ActorService service = new ActorService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost in AddActorServlet...");
		System.out.println("name: " + req.getParameter("name"));
		System.out.println("dateOfBirth: " + req.getParameter("dateOfBirth"));
		Actor actor = service.assembleOwnerFromRequest(req);
		service.addActor(actor);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/savedActor.jsp");
		dispatcher.forward(req,resp);
	}
}
