package it.objectmethod.srlgroupjob.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.srlgroupjob.controller.bean.LoginError;
import it.objectmethod.srlgroupjob.entities.VBorderauxEntity;
import it.objectmethod.srlgroupjob.service.BorderauxService;
import it.objectmethod.srlgroupjob.service.UtenteService;

@RestController
public class ExportRestController {

	@Autowired
	UtenteService serviceCliente;

	@Autowired
	BorderauxService serviceBorder;

	public LoginError error(String username, String password) {

		boolean errExist = !serviceCliente.doNamePassExist(username, password);

		System.out.println(errExist);

		LoginError err = new LoginError();

		err.setError(String.valueOf(errExist));

		return err;
	}

	@GetMapping(value = "/usercheck")
	public String usercheck(HttpSession ses, @RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password) {
		String json = "{\"isThereErr\" : \"";
		LoginError err = error(username, password);
		json += String.valueOf(err.getError()) + "\"}";

		return json;

	}

	@GetMapping(value = "/filtra")
	public List<VBorderauxEntity> getLista(@RequestParam(name = "tipoRegistro") String tipoRegistro) {

		List<VBorderauxEntity> lista = serviceBorder.getListaBorderaux(tipoRegistro);

		return lista;
	}

	@GetMapping(value = "/addBorderaux")
	public void addBorder(@RequestParam Map<String, String> params, HttpServletResponse response) {

		Collection<String> collectionIdBor = params.values();

		Iterator<String> iter = collectionIdBor.iterator();

		List<String> listaIdBor = new ArrayList<String>();

		System.out.println("mappa id bor: "+collectionIdBor);
		
		boolean decideGenCan = false;
		
		while (iter.hasNext()) {
			
			String idBor = iter.next();
			System.out.println(idBor);
			if (idBor.equals("GEN")) {
				decideGenCan = true;
			} else if (idBor.equals("CAN")) {
				decideGenCan = false;
			} else {
				listaIdBor.add(idBor);
			}
		}
		System.out.println("lista id bor: "+listaIdBor);
		serviceBorder.addBorderaux(listaIdBor);
		if (decideGenCan) {
			try {
				OutputStream outPutStream = response.getOutputStream();
				serviceBorder.buildCSV(listaIdBor, outPutStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void downloadBorderaux(HttpServletResponse response, List<String> listaIdBor) {

		response.setContentType("application/csv");

		response.addHeader("Content-Disposition", "attachment; filename=borderaux.csv");

		try {
			
			OutputStream outPutStream = response.getOutputStream();
			serviceBorder.buildCSV(listaIdBor, outPutStream);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
