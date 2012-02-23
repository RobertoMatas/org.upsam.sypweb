package org.upsam.sypweb.domain.citas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.servicio.Servicio;

@Entity
@NamedQueries({
	@NamedQuery(
		name  = "getListCitacionEnFechaNoAcudidas",
		query = "SELECT DISTINCT c " +
				"FROM Citacion c " +
				"WHERE c.servicio = :servicio " +
				"AND c.cita = :cita " +
				"AND c.hora >= :hora " +
				"AND c.acudio = FALSE " +
				"ORDER BY c.cita, c.hora" 
	),
	@NamedQuery(
		name  = "getListCitacionMayorIgualQueFecha",
		query = "SELECT DISTINCT c " +
				"FROM Citacion c " +
				"WHERE c.servicio = :servicio " +
				"AND c.cita >= :cita" 
	)
	
})
public class Citacion { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date cita;
	
	@Column(nullable = false, length = 6)
	private String hora;
	
	private Boolean acudio;
	
	@ManyToOne(optional = false)
	private Mujer mujer;
	
	@ManyToOne(optional = false)
	private Servicio servicio;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the cita
	 */
	public Date getCita() {
		return cita;
	}

	/**
	 * @param cita the cita to set
	 */
	public void setCita(Date cita) {
		this.cita = cita;
	}

	/**
	 * @return the hora
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * @return the acudio
	 */
	public Boolean getAcudio() {
		return acudio;
	}

	/**
	 * @param acudio the acudio to set
	 */
	public void setAcudio(Boolean acudio) {
		this.acudio = acudio;
	}

	/**
	 * @return the mujer
	 */
	public Mujer getMujer() {
		return mujer;
	}

	/**
	 * @param mujer the mujer to set
	 */
	public void setMujer(Mujer mujer) {
		this.mujer = mujer;
	}

	/**
	 * @return the servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
}