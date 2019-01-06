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
import es.salesianos.model.Director;
import es.salesianos.model.assembler.ActorAssembler;
import es.salesianos.model.assembler.DirectorAssembler;
import es.salesianos.repository.DirectorRepository;
import es.salesianos.repository.Repository;
import es.salesianos.utils.DateConverter;

public class DirectorService {
	
	
	private DirectorRepository repository = new DirectorRepository();
	
	private DateConverter converter = new DateConverter();
	private static final Logger LOGGER = LogManager.getLogger(DirectorService.class);
	
	
	public Director assembleOwnerFromRequest(HttpServletRequest req) {
		return DirectorAssembler.assembleDirectorFrom(req);
	}
	
	//pasar los datos
	public void addDirector(Director director) {
		repository.insertDirector(director);
	}

	public void insertOrUpdate(Director ownerFormulario) {
		Director userInDatabase = repository.search(ownerFormulario);
		if(null == userInDatabase){
			repository.insertDirector(ownerFormulario);
		}else{
			repository.updateDirector(ownerFormulario);
		}
	}
	
	public void deleteOwner(Integer codOwner) {
		repository.delete(codOwner);
	}
	
	public Actor search(Actor codAutor) {
		return repository.search(codAutor);
		
	}

	
	
	public List<Director> listAllDirectores() {
		LOGGER.info("ESTAS EN EL ListService");
		return repository.searchAllDirectors();
	}
	
	public DirectorRepository getRepository() {
		return repository;
	}

	public void setRepository(DirectorRepository repository) {
		this.repository = repository;
	}

}
