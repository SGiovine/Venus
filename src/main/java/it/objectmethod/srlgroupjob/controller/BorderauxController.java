package it.objectmethod.srlgroupjob.controller;

import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.srlgroupjob.entities.VBorderauxEntity;
import it.objectmethod.srlgroupjob.service.BorderauxService;

@Controller
public class BorderauxController {

	@Autowired
	BorderauxService service;

	@Autowired
	ServletContext context;

	@GetMapping("/visualizzaBorderaux")
	public String visualizzaBorderaux(ModelMap model) {

		return "VisualizzaBorderauxPage";
	}

/*	@GetMapping("/filtra")
	public String filtra(HttpSession ses, ModelMap model,
			@RequestParam(name = "tipoRegistro", required = false) String tipoRegistro) {

		model.addAttribute("isThereList", true);

		if (tipoRegistro == null) {
			tipoRegistro = (String) ses.getAttribute("tipoRegistro");
		} else {
			ses.setAttribute("tipoRegistro", tipoRegistro);
		}

		List<Borderaux> listaDocumenti = service.getListaBorderaux(tipoRegistro);
		model.addAttribute("listaDocumenti", listaDocumenti);

		return "VisualizzaBorderauxPage";
	}*/

/*	@GetMapping("/applayBorderaux")
	public String applayBorderaux(@RequestParam Map<String, String> params,
			@RequestParam(name = "generaCsv", required = false) String genera,
			@RequestParam(name = "rimuoviBorderspec", required = false) String rimuovi, HttpServletResponse response,
			HttpSession ses) {

		Collection<String> collectionIdBor = params.values();

		Iterator<String> iter = collectionIdBor.iterator();

		if (genera != null) {

			List<String> listaIdBor = new ArrayList<String>();

			while (iter.hasNext()) {
				String idBor = iter.next();
				if (idBor.equals("Genera") == false) {
					listaIdBor.add(idBor);
				}
			}

			response.setContentType("application/csv");

			response.addHeader("Content-Disposition", "attachment; filename=borderaux.csv");

			try {
				OutputStream outPutStream = response.getOutputStream();
				service.buildCSV(listaIdBor,outPutStream);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			service.addBorderauxGenerato();
			iter = null;
			listaIdBor = null;
			return null;

		}

		if (rimuovi != null) {
			System.out.println("rimuovi accesso");
			List<String> listaIdBor = new ArrayList<String>();

			while (iter.hasNext()) {
				String idBor = iter.next();
				if (idBor.equals("Cancella") == false) {
					listaIdBor.add(idBor);
				}
			}

			service.addBorderauxCancellato(listaIdBor);

		}

		return "forward:/visualizzaBorderaux";
	}*/

	
	
	@GetMapping("/creaBorderaux")
	public String creaBorderaux(@RequestParam Map<String, String> params) {
		if (params.isEmpty()) {

			return "CreaBorderauxPage";

		} else {

			VBorderauxEntity border = new VBorderauxEntity();

			border.setLocalita(params.get("localita"));
			border.setNazione(params.get("nazione"));
			border.setProvincia(params.get("provincia"));
			border.setIndirizzo(params.get("indirizzo"));
			border.setCap(params.get("cap"));
			border.setCodice(params.get("codice"));
			border.setRagSoc1(params.get("ragSoc1"));
			border.setRagSoc2(params.get("ragSoc2"));
			border.setAspetto(params.get("aspetto"));
			border.setPeso(params.get("peso"));
			border.setTipoRegistro(params.get("tipoRegistro"));

		//	service.addBorderaux(border);
		}

		return "CreaBorderauxPage";
	}

}
