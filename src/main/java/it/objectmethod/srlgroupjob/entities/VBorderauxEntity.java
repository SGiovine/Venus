package it.objectmethod.srlgroupjob.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLInsert;

@Entity
@Table(name="v_borderaux")
@SQLInsert(sql="insert into VBorderauxEntity (cap,indirizzo,nazione,provincia,aspetto,codice,ragSoc1,ragSoc2,tipoRegistro,peso) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
public class VBorderauxEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@Column(name="id_tipo_trasporto")
	private Integer idTipoTrasporto;

	@Column(name="note_intestazione")
	private String noteIntestazione;

	@Column(name="id_destinazione")
	private Integer idDestinazione;

	@Column(name="indirizzo")
	private String indirizzo;

	@Column(name="cap")
	private String cap;

	@Column(name="localita")
	private String localita;

	@Column(name="provincia")
	private String provincia;

	@Column(name="id_documento")
	private Integer idDocumento;

	@Column(name="id_prof_documento")
	private Integer idProfDocumento;

	@Column(name="num_progressivo")
	private Integer numProgressivo;

	@Column(name="data_registrazione")
	private LocalDateTime dataRegistro;

	@Column(name="codice")
	private String codice;

	@Column(name="rag_soc_1")
	private String ragSoc1;

	@Column(name="rag_soc_2")
	private String ragSoc2;

	@Column(name="id_con_pagamento")
	private Integer idConPagamento;

	@Column(name="id_lettera_incarico")
	private Integer idLetteraIncarico;

	@Column(name="aspetto")
	private String aspetto;

	@Column(name="tipo_registro")
	private String tipoRegistro;

	@Column(name="nazione")
	private String nazione;

	@Column(name="num_colli")
	private Integer numColli;
	
	@Column(name="peso")
	private String peso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTipoTrasporto() {
		return idTipoTrasporto;
	}

	public void setIdTipoTrasporto(Integer idTipoTrasporto) {
		this.idTipoTrasporto = idTipoTrasporto;
	}

	public String getNoteIntestazione() {
		return noteIntestazione;
	}

	public void setNoteIntestazione(String noteIntestazione) {
		this.noteIntestazione = noteIntestazione;
	}

	public Integer getIdDestinazione() {
		return idDestinazione;
	}

	public void setIdDestinazione(Integer idDestinazione) {
		this.idDestinazione = idDestinazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Integer getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	public Integer getIdProfDocumento() {
		return idProfDocumento;
	}

	public void setIdProfDocumento(Integer idProfDocumento) {
		this.idProfDocumento = idProfDocumento;
	}

	public Integer getNumProgressivo() {
		return numProgressivo;
	}

	public void setNumProgressivo(Integer numProgressivo) {
		this.numProgressivo = numProgressivo;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getRagSoc1() {
		return ragSoc1;
	}

	public void setRagSoc1(String ragSoc1) {
		this.ragSoc1 = ragSoc1;
	}

	public String getRagSoc2() {
		return ragSoc2;
	}

	public void setRagSoc2(String ragSoc2) {
		this.ragSoc2 = ragSoc2;
	}

	public Integer getIdConPagamento() {
		return idConPagamento;
	}

	public void setIdConPagamento(Integer idConPagamento) {
		this.idConPagamento = idConPagamento;
	}

	public Integer getIdLetteraIncarico() {
		return idLetteraIncarico;
	}

	public void setIdLetteraIncarico(Integer idLetteraIncarico) {
		this.idLetteraIncarico = idLetteraIncarico;
	}

	public String getAspetto() {
		return aspetto;
	}

	public void setAspetto(String aspetto) {
		this.aspetto = aspetto;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public Integer getNumColli() {
		return numColli;
	}

	public void setNumColli(Integer numColli) {
		this.numColli = numColli;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}
	
	
	
}
