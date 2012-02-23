package org.upsam.sypweb.domain.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import org.upsam.sypweb.domain.citas.Citacion;
import org.upsam.sypweb.domain.user.User;

@Entity
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, nullable = false, length = 100)
	private String codigo;

	@Column(nullable = false, length = 100)
	private String descripcion;

	@OneToMany(mappedBy = "servicio")
	@OrderBy("diaSemana, hora ASC")
	private List<Horario> disponibilidad = new ArrayList<Horario>();

	@OneToMany(mappedBy = "servicio")
	private List<Citacion> citaciones = new ArrayList<Citacion>();

	@OneToOne(optional = false)
	private User responsable;

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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * @return the disponibilidad
	 */
	public List<Horario> getDisponibilidad() {
		return disponibilidad;
	}

	/**
	 * @param disponibilidad the disponibilidad to set
	 */
	public void setDisponibilidad(List<Horario> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	/**
	 * @return the citaciones
	 */
	public List<Citacion> getCitaciones() {
		return citaciones;
	}

	/**
	 * @param citaciones the citaciones to set
	 */
	public void setCitaciones(List<Citacion> citaciones) {
		this.citaciones = citaciones;
	}

	/**
	 * @return the responsable
	 */
	public User getResponsable() {
		return responsable;
	}

	/**
	 * @param responsable the responsable to set
	 */
	public void setResponsable(User responsable) {
		this.responsable = responsable;
	}

}