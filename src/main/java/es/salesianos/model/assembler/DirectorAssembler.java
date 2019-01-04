package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Pelicula;

public class DirectorAssembler {

	public static Director assembleDirectorFrom(HttpServletRequest req) {
		Director director = new Director();
		String cod = req.getParameter("cod");
		if (null != cod) {
			director.setCod(Integer.parseInt(cod));
		}
		String name = req.getParameter("name");
		Integer year = Integer.parseInt(req.getParameter("yearofbirthdate"));
		director.setName(name);
		return director;
	}
}