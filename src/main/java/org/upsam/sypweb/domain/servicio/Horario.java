package org.upsam.sypweb.domain.servicio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "DIA_SEMANA", "SERVICIO_ID", "HORA" }))
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer servicioId;

	private Integer diaSemanda;

	@Column(length = 6)
	private String hora;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(insertable = false, updatable = false)
	private Servicio servicio;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@SuppressWarnings("unused")
	private void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the servicioId
	 */
	public Integer getServicioId() {
		return servicioId;
	}

	/**
	 * @param servicioId the servicioId to set
	 */
	public void setServicioId(Integer servicioId) {
		this.servicioId = servicioId;
	}

	/**
	 * @return the diaSemanda
	 */
	public Integer getDiaSemanda() {
		return diaSemanda;
	}

	/**
	 * @param diaSemanda the diaSemanda to set
	 */
	public void setDiaSemanda(Integer diaSemanda) {
		this.diaSemanda = diaSemanda;
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