package it.objectmethod.srlgroupjob.controller.bean;

import it.objectmethod.srlgroupjob.model.Utente;

public class UtenteBean {

	private String idAgente, nome, email;

	public boolean equals(Object objectAgente) {

		boolean itEquals = false;

		if (objectAgente != null) {
			itEquals = false;

			if (this == objectAgente) {
				itEquals = true;

				if (getClass() != objectAgente.getClass()) {
					itEquals = false;
				}

				Utente utente = (Utente) objectAgente;

				if (this.idAgente == utente.getIdAgente() && this.nome == utente.getNome()
						&& this.email == utente.getEmail()) {
					itEquals = true;
				}

			}

		} else {

			if(idAgente==null&&nome==null&&email==null) {

				itEquals = true;
				
			} else {

				itEquals = false;
				
			}
			
		}

		return itEquals;
	}

	public String getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(String idAgente) {
		this.idAgente = idAgente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
