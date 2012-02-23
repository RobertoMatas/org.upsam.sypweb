package org.upsam.sypweb.domain.ficha;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.upsam.sypweb.domain.mujer.Mujer;
import org.upsam.sypweb.domain.servicio.Servicio;

@Entity
@NamedQueries({
	@NamedQuery(
		name  = "getHistorialFichas",
		query = "SELECT f " +
				"FROM Ficha f " +
				"WHERE f.persona = :persona " +
				"AND f.cerrada = TRUE"
	),	
	@NamedQuery(
		name  = "getFichaAbierta",
		query = "SELECT f " +
				"FROM Ficha f " +
				"WHERE f.persona = :persona " +
				"AND f.servicio = :servicio " +
				"AND f.cerrada = FALSE"
	)
})
public class Ficha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Boolean cerrada;
	
	@Temporal(TemporalType.DATE)
	private Date apertura;
	
	@Temporal(TemporalType.DATE)
	private Date cierre;
	
	private String descripcion;
	
	@OneToMany(mappedBy = "ficha")
	private List<DocumentoAdjunto> adjuntos = new ArrayList<DocumentoAdjunto>();
	
	@ManyToOne
	private Mujer mujer;
	
	@ManyToOne
	private Servicio servicio;
	
	@OneToMany( mappedBy = "ficha")
	private List<Seguimiento> seguimientos = new ArrayList<Seguimiento>();

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
	 * @return the cerrada
	 */
	public Boolean getCerrada() {
		return cerrada;
	}

	/**
	 * @param cerrada the cerrada to set
	 */
	public void setCerrada(Boolean cerrada) {
		this.cerrada = cerrada;
	}

	/**
	 * @return the apertura
	 */
	public Date getApertura() {
		return apertura;
	}

	/**
	 * @param apertura the apertura to set
	 */
	public void setApertura(Date apertura) {
		this.apertura = apertura;
	}

	/**
	 * @return the cierre
	 */
	public Date getCierre() {
		return cierre;
	}

	/**
	 * @param cierre the cierre to set
	 */
	public void setCierre(Date cierre) {
		this.cierre = cierre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the adjuntos
	 */
	public List<DocumentoAdjunto> getAdjuntos() {
		return adjuntos;
	}

	/**
	 * @param adjuntos the adjuntos to set
	 */
	public void setAdjuntos(List<DocumentoAdjunto> adjuntos) {
		this.adjuntos = adjuntos;
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

	/**
	 * @return the seguimientos
	 */
	public List<Seguimiento> getSeguimientos() {
		return seguimientos;
	}

	/**
	 * @param seguimientos the seguimientos to set
	 */
	public void setSeguimientos(List<Seguimiento> seguimientos) {
		this.seguimientos = seguimientos;
	}
	
}