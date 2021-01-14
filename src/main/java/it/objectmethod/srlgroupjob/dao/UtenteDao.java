package it.objectmethod.srlgroupjob.dao;

import it.objectmethod.srlgroupjob.model.Utente;

public interface UtenteDao {

	public Utente getAgenteByUsername(String username);
	public Utente getAgenteByIdAgente(String idAgente);
	public boolean doUsernameAndPasswordAlreadyExist(String username,String password);
	
}
