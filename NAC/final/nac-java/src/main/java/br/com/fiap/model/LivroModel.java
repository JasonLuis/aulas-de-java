package br.com.fiap.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

public class LivroModel {
	
	private long id;
	private String titulo;
	private String nomeAutor;
	private String data;
	private double preco;
	private String genero;
	private String sinopse;
	
	public LivroModel() {
		// TODO Auto-generated constructor stub
	}
	
	public LivroModel(long id, String titulo, String nomeAutor, String data, double preco, String genero,
			String sinopse) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.data = data;
		this.preco = preco;
		this.genero = genero;
		this.sinopse = sinopse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Size(min = 5, max = 40, message = "Titulo deve ter no mínimo 5 e no máximo 40 caracteres")
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Size(min = 5, max = 40, message = "Nome do autor deve ter no mínimo 5 e no máximo 40 caracteres")
	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	
	@Size(min = 8, max = 10, message = "Informe uma data valida")
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	@DecimalMin(value = "0.1", message = "Preço deve ser acima de 0.0")
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Size(min = 2, max = 10, message = "Informe o genero")
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Size(min = 10, max = 100, message = "Informe a sinopse")
	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	
	
	
}
