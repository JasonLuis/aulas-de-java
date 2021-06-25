package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MARCA")
public class MarcaModel {

	private long idMarca;
	private String nomeMarca;
	private ProdutoModel produto;

	public MarcaModel() {
	}

	public MarcaModel(long idMarca, String nomeMarca, ProdutoModel produto) {
		super();
		this.idMarca = idMarca;
		this.nomeMarca = nomeMarca;
		this.produto = produto;
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

	@ManyToOne
	@JoinColumn(name = "ID", nullable = true)
	public ProdutoModel getProduto() {
		return produto;
	}

	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return nomeMarca;
	}
	
	

}
