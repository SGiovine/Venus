package it.objectmethod.srlgroupjob.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.objectmethod.srlgroupjob.controller.bean.UtenteBean;
import it.objectmethod.srlgroupjob.dao.UtenteDao;
import it.objectmethod.srlgroupjob.model.Utente;
import it.objectmethod.srlgroupjob.service.UtenteService;

@Component
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	UtenteDao utenteDao;

	public boolean doNamePassExist(String username, String password) {
		boolean itExists = utenteDao.doUsernameAndPasswordAlreadyExist(username, password);
		return itExists;
	}
	
	public UtenteBean CheckUsernameAndPasswordThenGetAgenteBean(String username, String password) {

		Utente utente = new Utente();

		UtenteBean utenteBean = new UtenteBean();

		boolean itExists = false;

		itExists = utenteDao.doUsernameAndPasswordAlreadyExist(username, password);

		if (itExists) {
			utente = utenteDao.getAgenteByUsername(username);
		}

		utenteBean.setIdAgente(utente.getIdAgente());
		utenteBean.setNome(utente.getNome());
		utenteBean.setEmail(utente.getEmail());

		return utenteBean;
	}

	public UtenteDao getAgenteDao() {
		return utenteDao;
	}

	public void setAgenteDao(UtenteDao utenteDao) {
		this.utenteDao = utenteDao;
	}

}
