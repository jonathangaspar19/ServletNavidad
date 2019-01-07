package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.assembler.ActorAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.utils.DateConverter;

public class ActorService {
	
	
	private Repository repository = new Repository();
	private DateConverter converter = new DateConverter();
	private static final Logger LOGGER = LogManager.getLogger(ActorService.class);
	
	
	public Actor assembleOwnerFromRequest(HttpServletRequest req) {
		return ActorAssembler.assembleActorFrom(req);
	}
	
	//pasar los datos
	public void addActor(Actor actor) {
		repository.insertActor(actor);
	}

	public void insertOrUpdate(Actor ownerFormulario) {
		Actor userInDatabase = repository.search(ownerFormulario);
		if(null == userInDatabase){
			repository.insertActor(ownerFormulario);
		}else{
			repository.updateActor(ownerFormulario);
		}
	}
	
	public void deleteOwner(Integer codOwner) {
		repository.delete(codOwner);
	}
	
	public void enlazar(Integer codActor, Integer codPelicula) {
		repository.enlazar(codActor, codPelicula);
	}
	/*
	public Actor search(Integer codOwner) {
		return repository.searchByCodOwner(codOwner);
		
	}
*/
	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	public List<Actor> listAllActores() {
		LOGGER.info("listAllActores method...");
		return repository.searchAllActores();
	}
	
	public List<Actor> listYearActor() {
		LOGGER.info("listYearActor method...");
		return repository.searchActoresYear();
	}

	public List<Director> listAllDirectores() {
		LOGGER.info("ESTAS EN EL ListService");
		return repository.searchAllDirectores();
	}

	public Actor search(Actor codActor) {
		return repository.search(codActor);
	}
	
	
	

}
