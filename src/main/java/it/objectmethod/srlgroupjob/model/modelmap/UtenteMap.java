package it.objectmethod.srlgroupjob.model.modelmap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.srlgroupjob.model.Utente;

public class UtenteMap implements RowMapper<Utente> {

	public Utente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Utente utente = new Utente();
		utente.setIdAgente(rs.getString("id"));
		utente.setUsername(rs.getString("username"));
		utente.setPassword(rs.getString("password"));
		utente.setEmail(rs.getString("email"));
		utente.setNome(rs.getString("nome"));
		utente.setTipoAgente(rs.getString("flag_tipo_agente"));
		return utente;
	}

}
