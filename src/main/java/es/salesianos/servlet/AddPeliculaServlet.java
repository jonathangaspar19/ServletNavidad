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
import es.salesianos.model.Pelicula;
import es.salesianos.service.PeliculaService;

@WebServlet("/addPeliculaServlet")
public class AddPeliculaServlet extends HttpServlet {

	private PeliculaService peliculaService = new PeliculaService();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost in AddPeliculaServlet...");
		System.out.println("tittle: " + req.getParameter("tittle"));
		System.out.println("codOwner: " + req.getParameter("codOwner"));
		Pelicula pelicula = peliculaService.assembleOwnerFromRequest(req);
		peliculaService.addPelicula(pelicula);
		//
		List<Pelicula> listAllPeliculas = peliculaService.listAllPeliculas();
		req.setAttribute("listAllPeliculas", listAllPeliculas);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listFilms.jsp");
		dispatcher.forward(req, resp);
	}
}
