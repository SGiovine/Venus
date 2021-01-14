package it.objectmethod.srlgroupjob.service.serviceimpl;

import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.objectmethod.srlgroupjob.controller.bean.BorderauxBean;
import it.objectmethod.srlgroupjob.entities.BorderauxEntity;
import it.objectmethod.srlgroupjob.entities.VBorderauxEntity;
import it.objectmethod.srlgroupjob.java.CSVbuilder;
import it.objectmethod.srlgroupjob.repository.BorderauxRepository;
import it.objectmethod.srlgroupjob.repository.VBorderauxRepository;
import it.objectmethod.srlgroupjob.service.BorderauxService;

@Component
public class BorderauxServiceImpl implements BorderauxService {

	@Autowired
	VBorderauxRepository borderRep;
	
	@Autowired
	BorderauxRepository borderGenRep;
	
	@Autowired
	CSVbuilder builder;

	public List<VBorderauxEntity> getListaBorderaux(String tipoRegistro) {

		return borderRep.getListaBorderauxByTipoRegistroWhereIdDocumentoIsNotInBorderauxGenerati(tipoRegistro);
	}

	public List<BorderauxBean> getListaBorderauxBean(String tipoRegistro) {

		List<VBorderauxEntity> listaDocumenti = borderRep
				.getListaBorderauxByTipoRegistroWhereIdDocumentoIsNotInBorderauxGenerati(tipoRegistro);
		List<BorderauxBean> listaDocumentiBean = new ArrayList<BorderauxBean>();
		int i = 0;
		for (VBorderauxEntity bor : listaDocumenti) {
			BorderauxBean borBean = new BorderauxBean();
			borBean.setIdParam(String.valueOf(i));
			borBean.setCodiceCliente(bor.getCodice());
			borBean.setData(String.valueOf(bor.getDataRegistro()));
			borBean.setId(String.valueOf(bor.getId()));
			borBean.setNumeroProg(String.valueOf(bor.getNumProgressivo()));
			borBean.setRagSoc1(bor.getRagSoc1());
			listaDocumentiBean.add(borBean);
			i++;
		}
		return listaDocumentiBean;
	}

	@Override
	public BorderauxBean getBorderauxBeanById(String idBorderaux) {

		BorderauxBean borderauxBean = new BorderauxBean();

		VBorderauxEntity vBorderaux = borderRep.findById(Integer.valueOf(idBorderaux));

		borderauxBean.setId(String.valueOf(vBorderaux.getId()));
		borderauxBean.setData(String.valueOf(vBorderaux.getDataRegistro()));
		borderauxBean.setCodiceCliente(vBorderaux.getCodice());
		borderauxBean.setNumeroProg(String.valueOf(vBorderaux.getNumProgressivo()));
		borderauxBean.setRagSoc1(vBorderaux.getRagSoc1());

		return borderauxBean;
	}

	public VBorderauxEntity getBorderauxById(String idBorderaux) {

		VBorderauxEntity vBorderaux = borderRep.findById(Integer.valueOf(idBorderaux));

		return vBorderaux;
	}

	public void buildCSV(List<String> idBorList,OutputStream outStream) {
		
		List<String[]> listaArrBor = new ArrayList<>();

		List<BorderauxEntity> listaBorGenerati = new ArrayList<>();

		if (idBorList != null) {
			for (String idBor : idBorList) {
				VBorderauxEntity vBorderaux = new VBorderauxEntity();
				BorderauxEntity borGen = new BorderauxEntity();
				vBorderaux = getBorderauxById(idBor);
				String[] arrBorderaux = new String[9];
				borGen.setIdDocumento(vBorderaux.getIdDocumento());
				arrBorderaux[0] = String.valueOf(vBorderaux.getNumProgressivo());
				arrBorderaux[1] = vBorderaux.getRagSoc1();
				arrBorderaux[2] = vBorderaux.getIndirizzo();
				arrBorderaux[3] = vBorderaux.getCap();
				arrBorderaux[4] = vBorderaux.getLocalita();
				arrBorderaux[5] = vBorderaux.getProvincia();
				arrBorderaux[6] = vBorderaux.getNazione();
				arrBorderaux[7] = String.valueOf(vBorderaux.getNumColli());
				arrBorderaux[8] = vBorderaux.getPeso();
				listaArrBor.add(arrBorderaux);
				listaBorGenerati.add(borGen);
			}

			builder.csvBuilder(listaArrBor,outStream);
			listaArrBor = null;
		}

	}

	public void addBorderaux(List<String> listaIdBor) {
		for (String borId : listaIdBor) {
			VBorderauxEntity bor = borderRep.findById(Integer.valueOf(borId));
			BorderauxEntity borGen = new BorderauxEntity();
			borGen.setIdDocumento(bor.getId());
	        String text = "2011-10-02 18:48:05.123456";
	        Timestamp time = Timestamp.valueOf(text);
			borGen.setDateRitiro(time);
			borGen.setDataTime(time);
			borGen.setIdLetteraIncarico(15);
			System.out.println("id border = " + borId);
			borderGenRep.save(borGen);
		}
	}

}
