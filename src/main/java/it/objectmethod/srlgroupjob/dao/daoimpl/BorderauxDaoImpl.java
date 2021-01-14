package it.objectmethod.srlgroupjob.dao.daoimpl;
/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import it.objectmethod.srlgroupjob.dao.BorderauxDao;
import it.objectmethod.srlgroupjob.model.modelmap.BorderauxMap;
import waste.VBorderaux;

@Component
public class BorderauxDaoImpl implements BorderauxDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<VBorderaux> getListaBorderauxByTipoRegistroWhereIdDocumentoIsNotInBorderauxGenerati(
			String tipoRegistro) {

		String sql = "SELECT * FROM v_borderaux WHERE id_documento NOT IN (SELECT id_documento FROM borderaux) and tipo_registro = \""
				+ tipoRegistro + "\"";
		List<VBorderaux> getLista = jdbcTemplate.query(sql, new BorderauxMap());
		
		return getLista;

	}

	@Override
	public void addBorderaux(VBorderaux bAux) {

		String sql = "insert into v_borderaux (cap,indirizzo,nazione,provincia,aspetto,codice,rag_soc_1,rag_soc_2,tipo_registro,peso) values (\"" + bAux.getCap() + "\",\"" + bAux.getIndirizzo() + "\",\"" + bAux.getNazione() + "\",\""
				+ bAux.getProvincia() + "\",\"" + bAux.getAspetto() + "\",\"" + bAux.getCodice() + "\",\"" + bAux.getRagSoc1() + "\",\"" + bAux.getRagSoc2() + "\",\"" + bAux.getTipoRegistro() + "\",\"" +bAux.getPeso()+ "\")";
		jdbcTemplate.update(sql);

	}

	@Override
	public VBorderaux getBorderauxById(String idBorderaux) {
		String sql = "select * from v_borderaux where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idBorderaux }, new BorderauxMap());
	}

	@Override
	public void updateBorderaux(String value, String column, String id) {
		String sql = "update v_borderaux set " + column + " = \"" + value + "\" where id = " + id;

		jdbcTemplate.update(sql);
	}
}
*/