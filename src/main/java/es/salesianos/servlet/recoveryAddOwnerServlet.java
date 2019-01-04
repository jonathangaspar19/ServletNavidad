package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.service.ActorService;

public class recoveryAddOwnerServlet extends HttpServlet{
	ActorService service = new ActorService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codOwner = req.getParameter("codOwner");
		Actor ownerFormulario= new Actor();
		//ownerFormulario.setCodOwner(Integer.parseInt(codOwner));
		////Owner ownerFromDatabase = service.search(ownerFormulario.getCodOwner());
		req.setAttribute("codOwner", codOwner);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addPet.jsp");
		dispatcher.forward(req,resp);
	}
}
