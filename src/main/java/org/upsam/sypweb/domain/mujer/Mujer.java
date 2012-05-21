package org.upsam.sypweb.domain.mujer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.upsam.sypweb.domain.aula.AulaAbierta;
import org.upsam.sypweb.domain.citas.Citacion;
import org.upsam.sypweb.domain.ficha.Ficha;
import org.upsam.sypweb.domain.mujer.domicilio.Domicilio;

@Entity
public class Mujer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Boolean empadronada;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAlta;
	
	@Nullable
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNac;

	@Column(length = 10)
	private String telfFijo;

	@Column(length = 10)
	private String telfMovil;

	@OneToMany(mappedBy = "mujer")
	private List<Citacion> citaciones = new ArrayList<Citacion>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Domicilio domicilio;

	@OneToMany(mappedBy = "mujer")
	private List<Ficha> fichas = new ArrayList<Ficha>();

	@ManyToMany
	private List<AulaAbierta> talleres = new ArrayList<AulaAbierta>();

	@Embedded
	private Nombre nombre;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	protected void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the empadronada
	 */
	public Boolean getEmpadronada() {
		return empadronada;
	}

	/**
	 * @param empadronada the empadronada to set
	 */
	public void setEmpadronada(Boolean empadronada) {
		this.empadronada = empadronada;
	}

	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * @return the fechaNac
	 */
	public Date getFechaNac() {
		return fechaNac;
	}

	/**
	 * @param fechaNac the fechaNac to set
	 */
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	/**
	 * @return the telfFijo
	 */
	public String getTelfFijo() {
		return telfFijo;
	}

	/**
	 * @param telfFijo the telfFijo to set
	 */
	public void setTelfFijo(String telfFijo) {
		this.telfFijo = telfFijo;
	}

	/**
	 * @return the telfMovil
	 */
	public String getTelfMovil() {
		return telfMovil;
	}

	/**
	 * @param telfMovil the telfMovil to set
	 */
	public void setTelfMovil(String telfMovil) {
		this.telfMovil = telfMovil;
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
	 * @return the domicilio
	 */
	public Domicilio getDomicilio() {
		return domicilio;
	}

	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * @return the fichas
	 */
	public List<Ficha> getFichas() {
		return fichas;
	}

	/**
	 * @param fichas the fichas to set
	 */
	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}

	/**
	 * @return the talleres
	 */
	public List<AulaAbierta> getTalleres() {
		return talleres;
	}

	/**
	 * @param talleres the talleres to set
	 */
	public void setTalleres(List<AulaAbierta> talleres) {
		this.talleres = talleres;
	}

	/**
	 * @return the nombre
	 */
	public Nombre getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(Nombre nombre) {
		this.nombre = nombre;
	}
	
}
