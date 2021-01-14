package it.objectmethod.srlgroupjob.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.srlgroupjob.entities.VBorderauxEntity;

@Repository
public interface VBorderauxRepository extends JpaRepository<VBorderauxEntity,Long> {
	
	@Query("SELECT v FROM VBorderauxEntity v WHERE v.id NOT IN (SELECT b.idDocumento FROM BorderauxEntity b) and v.tipoRegistro = ?1")
	public List<VBorderauxEntity> getListaBorderauxByTipoRegistroWhereIdDocumentoIsNotInBorderauxGenerati(String tipoRegistro);
	
	public VBorderauxEntity findById(Integer idBorderaux);
	
/*	@Modifying
	@Transactional
	@Query(value="insert into VBorderauxEntity (cap,indirizzo,nazione,provincia,aspetto,codice,ragSoc1,ragSoc2,tipoRegistro,peso) values (:cap, :indirizzo, :nazione, :provincia, :aspetto, :codice, :ragSoc1, :ragSoc2, :tipoRegistro, :peso)", nativeQuery=true)
	public void addBorderaux(@Param("cap") String cap,@Param("indirizzo") String indirizzo,@Param("nazione") String nazione,@Param("provincia") String provincia,@Param("aspetto") String aspetto,@Param("codice") String codice,@Param("ragSoc1") String ragSoc1,@Param("ragSoc2") String ragSoc2,@Param("tipoRegistro") String tipoRegistro,@Param("peso") String peso);
	*/
//	public void updateBorderaux(String value,String column,String id);
	
}
