package org.upsam.sypweb.domain.aula;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.upsam.sypweb.domain.mujer.Mujer;

@Entity
public class AulaAbierta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date inicio;

	@Temporal(TemporalType.DATE)
	private Date fin;

	private Integer maxPlazas;

	@ManyToOne(fetch = FetchType.EAGER)
	private Taller curso;

	@ManyToMany(mappedBy = "talleres")
	private List<Mujer> personas = new ArrayList<Mujer>();

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
	 * @return the inicio
	 */
	public Date getInicio() {
		return inicio;
	}

	/**
	 * @param inicio the inicio to set
	 */
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the fin
	 */
	public Date getFin() {
		return fin;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(Date fin) {
		this.fin = fin;
	}

	/**
	 * @return the maxPlazas
	 */
	public Integer getMaxPlazas() {
		return maxPlazas;
	}

	/**
	 * @param maxPlazas the maxPlazas to set
	 */
	public void setMaxPlazas(Integer maxPlazas) {
		this.maxPlazas = maxPlazas;
	}

	/**
	 * @return the curso
	 */
	public Taller getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Taller curso) {
		this.curso = curso;
	}

	/**
	 * @return the personas
	 */
	public List<Mujer> getPersonas() {
		return personas;
	}

	/**
	 * @param personas the personas to set
	 */
	public void setPersonas(List<Mujer> personas) {
		this.personas = personas;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fin == null) ? 0 : fin.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((maxPlazas == null) ? 0 : maxPlazas.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AulaAbierta other = (AulaAbierta) obj;
		if (fin == null) {
			if (other.fin != null)
				return false;
		} else if (!fin.equals(other.fin))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (maxPlazas == null) {
			if (other.maxPlazas != null)
				return false;
		} else if (!maxPlazas.equals(other.maxPlazas))
			return false;
		return true;
	}

}