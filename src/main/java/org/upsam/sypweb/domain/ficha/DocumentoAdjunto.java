package org.upsam.sypweb.domain.ficha;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class DocumentoAdjunto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 35)
	private String tipo;

	private String descripcion;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(columnDefinition = "BYTEA")
	private byte[] documento;
	
	@ManyToOne
	private Ficha ficha;

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
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	 * @return the documento
	 */
	public byte[] getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	/**
	 * @return the ficha
	 */
	public Ficha getFicha() {
		return ficha;
	}

	/**
	 * @param ficha the ficha to set
	 */
	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

}