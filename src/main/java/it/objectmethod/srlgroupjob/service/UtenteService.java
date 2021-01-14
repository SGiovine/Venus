package it.objectmethod.srlgroupjob.service;

import it.objectmethod.srlgroupjob.controller.bean.UtenteBean;

public interface UtenteService {

	public UtenteBean CheckUsernameAndPasswordThenGetAgenteBean(String username,String password);
	public boolean doNamePassExist(String username, String password);
}
