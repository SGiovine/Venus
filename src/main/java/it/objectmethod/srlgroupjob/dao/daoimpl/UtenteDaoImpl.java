package it.objectmethod.srlgroupjob.dao.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import it.objectmethod.srlgroupjob.dao.UtenteDao;
import it.objectmethod.srlgroupjob.model.Utente;
import it.objectmethod.srlgroupjob.model.modelmap.UtenteMap;

@Component
public class UtenteDaoImpl implements UtenteDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Utente getAgenteByUsername(String username) {

		String sql = "select * from agente where username = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { username }, new UtenteMap());
	}

	public Utente getAgenteByIdAgente(String idAgente) {

		String sql = "select * from agente where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idAgente }, new UtenteMap());
	}

	public boolean doUsernameAndPasswordAlreadyExist(String username, String password) {

		String sql = "select * from agente";

		List<Utente> listaAgenti = jdbcTemplate.query(sql, new UtenteMap());

		boolean itExists = false;

		for (Utente utente : listaAgenti) {
			if (username != null && password != null) {
				if (username.equals(utente.getUsername()) && password.equals(utente.getPassword())) {
					itExists = true;
				}
			}
		}

		return itExists;
	}

}
