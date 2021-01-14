package it.objectmethod.srlgroupjob.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLInsert;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name="borderaux")
//@SQLInsert(sql = "insert into borderaux (idDocumento,idLetteraIncarico) values (?,?)")
public class BorderauxEntity {

/*	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;*/

//	@Column(name="id_documento")
	@Id
	private Integer idDocumento;
	
	@Column(name="datatime")
	private Timestamp dataTime;
	
	@Column(name="num_progressivo")
	private Integer numProgressivo;
	
	@Column(name="date_ritiro")
	private Timestamp DateRitiro;
	
	@Column(name="nazione_destinazione")
	private String nazioneDestinazione;
	
	@Column(name="valore_assicurazione")
	private String valoreAssicurazione;
	
	@Column(name="tipo_servizio")
	private String tipoServizio;
	
	@Column(name="tipo_incasso_contrassegno")
	private String tipoIncassoContrassegno;
	
	@Column(name="sent")
	private String sent;
	
	@Column(name="colli")
	private Float colli;
	
	@Column(name="kg")
	private Float kg;
	
	@Column(name="note")
	private String note;
	
	@Column(name="id_lettera_incarico")
	private Integer idLetteraIncarico;
	
	@Column(name="aspetto")
	private String aspetto;
	
	@Column(name="urgenza")
	private Integer urgenza;
	
	@Column(name="data_consegna")
	private Timestamp dataConsegna;
	
	@Column(name="tipo_servizio_tnt")
	private String tipoServizioTnt;

/*	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/

	public Integer getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Integer integer) {
		this.idDocumento = integer;
	}

	public Timestamp getDataTime() {
		return dataTime;
	}

	public void setDataTime(Timestamp dataTime) {
		this.dataTime = dataTime;
	}

	public Integer getNumProgressivo() {
		return numProgressivo;
	}

	public void setNumProgressivo(Integer numProgressivo) {
		this.numProgressivo = numProgressivo;
	}

	public Timestamp getDateRitiro() {
		return DateRitiro;
	}

	public void setDateRitiro(Timestamp dateRitiro) {
		DateRitiro = dateRitiro;
	}

	public String getNazioneDestinazione() {
		return nazioneDestinazione;
	}

	public void setNazioneDestinazione(String nazioneDestinazione) {
		this.nazioneDestinazione = nazioneDestinazione;
	}

	public String getValoreAssicurazione() {
		return valoreAssicurazione;
	}

	public void setValoreAssicurazione(String valoreAssicurazione) {
		this.valoreAssicurazione = valoreAssicurazione;
	}

	public String getTipoServizio() {
		return tipoServizio;
	}

	public void setTipoServizio(String tipoServizio) {
		this.tipoServizio = tipoServizio;
	}

	public String getTipoIncassoContrassegno() {
		return tipoIncassoContrassegno;
	}

	public void setTipoIncassoContrassegno(String tipoIncassoContrassegno) {
		this.tipoIncassoContrassegno = tipoIncassoContrassegno;
	}

	public String getSent() {
		return sent;
	}

	public void setSent(String sent) {
		this.sent = sent;
	}

	public Float getColli() {
		return colli;
	}

	public void setColli(Float colli) {
		this.colli = colli;
	}

	public Float getKg() {
		return kg;
	}

	public void setKg(Float kg) {
		this.kg = kg;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public Integer getUrgenza() {
		return urgenza;
	}

	public void setUrgenza(Integer urgenza) {
		this.urgenza = urgenza;
	}

	public Timestamp getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(Timestamp dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public String getTipoServizioTnt() {
		return tipoServizioTnt;
	}

	public void setTipoServizioTnt(String tipoServizioTnt) {
		this.tipoServizioTnt = tipoServizioTnt;
	}
	
}
