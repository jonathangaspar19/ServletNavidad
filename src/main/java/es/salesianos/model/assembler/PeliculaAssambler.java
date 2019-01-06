package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Pelicula;

public class PeliculaAssambler {

	public static Pelicula assemblePeliculaFrom(HttpServletRequest req) {
		Pelicula pelicula = new Pelicula();
		String codPelicula = req.getParameter("cod");
		if(null != codPelicula) {
			pelicula.setCod(Integer.parseInt(codPelicula));
		}
		String title = req.getParameter("tittle");
		pelicula.setTitulo(title);
		pelicula.setCodDirector(Integer.parseInt(req.getParameter("codOwner")));
		return pelicula;
	}
}