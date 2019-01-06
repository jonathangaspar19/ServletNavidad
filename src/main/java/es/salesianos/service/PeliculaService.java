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
import es.salesianos.repository.FilmRepository;
import es.salesianos.model.assembler.PeliculaAssambler;
import es.salesianos.repository.Repository;
import es.salesianos.utils.DateConverter;

public class PeliculaService {
	
	
	private FilmRepository repository = new FilmRepository();
	private DateConverter converter = new DateConverter();
	private static final Logger LOGGER = LogManager.getLogger(PeliculaService.class);
	
	
	public Pelicula assembleOwnerFromRequest(HttpServletRequest req) {
		return PeliculaAssambler.assemblePeliculaFrom(req);
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
	
	
	public FilmRepository getRepository() {
		return repository;
	}

	public void setRepository(FilmRepository filmRepository) {
		this.repository = repository;
	}
	
	public List<Pelicula> listAllPeliculas() {
		LOGGER.info("listAllPeliculas");
		return repository.searchAllPeliculas();
	}
	
	
	

}
