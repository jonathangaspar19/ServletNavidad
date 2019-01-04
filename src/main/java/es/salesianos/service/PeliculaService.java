package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Actor;
import es.salesianos.model.Pelicula;
import es.salesianos.model.assembler.ActorAssembler;
//import es.salesianos.model.assembler.PeliculaAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.utils.DateConverter;

public class PeliculaService {
	
	
	private Repository repository = new Repository();
	private DateConverter converter = new DateConverter();
	private static final Logger LOGGER = LogManager.getLogger(PeliculaService.class);
	
	
	public Pelicula assembleOwnerFromRequest(HttpServletRequest req) {
		//return PeliculaAssembler.assemblePeliculaFrom(req);
		return null;
	}
	
	//pasar los datos
	public void addPelicula(Pelicula pelicula) {
		repository.insertPelicula(pelicula);
	}

	public void insertOrUpdate(Pelicula peliculaFormulario) {
		Pelicula userInDatabase = repository.searchPelicula(peliculaFormulario);
		if(null == userInDatabase){
			repository.insertPelicula(peliculaFormulario);
		}else{
			repository.updatePelicula(peliculaFormulario);
		}
	}
	
	public void deleteOwner(Integer codOwner) {
		repository.delete(codOwner);
	}
	
	public Actor search(Integer codOwner) {
		return repository.searchByCodOwner(codOwner);
		
	}

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	public List<Pelicula> listAllPeliculas() {
		LOGGER.info("listAllPeliculas");
		return repository.searchAllPeliculas();
	}
	
	
	

}
