package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MARCA")
public class MarcaModel {
	
	private long idMarca;
	private String nomeMarca;
	
	public MarcaModel() {}

	public MarcaModel(long idMarca, String nomeMarca) {
		super();
		this.idMarca = idMarca;
		this.nomeMarca = nomeMarca;
	}

	@Id
	@Column(name = "ID_MARCA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARCA_SEQ")
	@SequenceGenerator(name = "MARCA_SEQ", sequenceName = "MARCA_SEQ", allocationSize = 1)
	public long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(long idMarca) {
		this.idMarca = idMarca;
	}

	@Column(name = "NOME_MARCA")
	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

}
