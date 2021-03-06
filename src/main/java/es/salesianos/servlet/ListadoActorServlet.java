package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.salesianos.model.Actor;
import es.salesianos.repository.Repository;
import es.salesianos.service.ActorService;

public class ListadoActorServlet extends HttpServlet {
	private static final Logger log = LogManager.getLogger(ListadoActorServlet.class);
	private ActorService servicio = new ActorService();
	private Repository repository = new Repository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Actor> listAllActores = servicio.listAllActores();
		req.setAttribute("listAllActores", listAllActores);
/*		
 		log.debug("This is a debug message");
		log.info("This is an info message");
		log.warn("This is a warn message");
		log.error("This is an error message");
		log.fatal("This is a fatal message");
*/
		
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addActor.jsp");
		dispatcher.forward(req, resp);
	}
}
