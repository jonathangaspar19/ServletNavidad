package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Pelicula;

public class ActorAssembler {

	public static Actor assembleActorFrom(HttpServletRequest req) {
		Actor actor = new Actor();
		String cod=req.getParameter("cod");
		if(null != cod) {
			actor.setCod(Integer.parseInt(cod));
		}
		String name = (req.getParameter("name")!=null && !req.getParameter("name").isEmpty()) ? req.getParameter("name") : "";
		actor.setName(name);
		
		Integer yearOfBirth = (req.getParameter("dateOfBirth")!=null && !req.getParameter("dateOfBirth").isEmpty()) ? Integer.parseInt(req.getParameter("dateOfBirth")) : 0;
		actor.setYearOfTheBirthDate(yearOfBirth);
		System.out.println(actor.toString());
		return actor;
	}
}