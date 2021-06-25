package br.com.fiap.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "TB_LOJA")
public class LojaModel {
	
	private int idLoja;
	private String nomeLoja;
	private List<ProdutoModel> produtos;
	
	public LojaModel() {
		// TODO Auto-generated constructor stub
	}

	public LojaModel(int idLoja, String nomeLoja, List<ProdutoModel> produtos) {
		super();
		this.idLoja = idLoja;
		this.produtos = produtos;
	}
	
	@Id
	@Column(name = "ID_LOJA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOJA_SEQ")
	@SequenceGenerator(name = "LOJA_SEQ", sequenceName = "LOJA_SEQ", allocationSize = 1)
	public int getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(int idLoja) {
		this.idLoja = idLoja;
	}
	
	@Column(name = "NOME_LOJA")
	@NotNull(message = "Nome obrigatorio")
	@Size(min = 2, max = 50, message = "Nome deve ser entre 2 e 40 caracteres")
	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	
	@ManyToMany(mappedBy = "lojas")
	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}
	
	
	
	
}
