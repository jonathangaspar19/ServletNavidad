package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.assembler.ActorAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.service.ActorService;

public class editActorServlet extends HttpServlet{
ActorService service = new ActorService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codOwner = req.getParameter("codActor");
		Actor actorFormulario= new Actor();
		//actorFormulario.setCodActor(Integer.parseInt(codOwner));
		//Actor actorFromDatabase = service.search(actorFormulario.getCodActor());
		//req.setAttribute("owner", actorFromDatabase);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ownerEdited.jsp");
		dispatcher.forward(req,resp);
	}
}
