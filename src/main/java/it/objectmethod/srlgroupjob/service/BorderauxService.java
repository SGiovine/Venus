package it.objectmethod.srlgroupjob.service;

import java.io.OutputStream;
import java.util.List;
import it.objectmethod.srlgroupjob.controller.bean.BorderauxBean;
import it.objectmethod.srlgroupjob.entities.BorderauxEntity;
import it.objectmethod.srlgroupjob.entities.VBorderauxEntity;

public interface BorderauxService {

	public List<VBorderauxEntity> getListaBorderaux(String tipoRegistro);

	public BorderauxBean getBorderauxBeanById(String idBorderaux);

//	public void modifyBorderauxSingleValue(String value, String column, String id);

	public VBorderauxEntity getBorderauxById(String idBorderaux);

	public void buildCSV(List<String> idBorList,OutputStream outStream);

	public List<BorderauxBean> getListaBorderauxBean(String tipoRegistro);

	public void addBorderaux(List<String> idBorList);

}
