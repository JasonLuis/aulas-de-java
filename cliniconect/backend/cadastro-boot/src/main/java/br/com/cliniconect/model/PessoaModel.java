package br.com.cliniconect.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name  = "TB_PESSOA")
public class PessoaModel {
	
	private long id;
	private String nome;
	private String sexo;
	private String endereco;
	private String cpf;
	private String celular;
	private String dtNasc;
	private String email;
	
	public PessoaModel() {}

	public PessoaModel(long id,String nome, String sexo, String endereco, String cpf, String celular, String dtNasc,
			String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.endereco = endereco;
		this.cpf = cpf;
		this.celular = celular;
		this.dtNasc = dtNasc;
		this.email = email;
	}
	
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "NOME")
	@NotNull(message = "Nome é obrigatório")
	@Size(min = 2, max = 50, message = "Nome deve ter entre 3 e 40 caracteres")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "SEXO")
	@NotNull(message = "Sexo é obrigatório")
	@Size(min = 8, max = 9, message = "Sexo deve ter entre 8 e 9 caracteres")
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Column(name = "ENDERECO")
	@NotNull(message = "Endereco é obrigatório")
	@Size(min = 5, max = 120, message = "Endereço deve ter entre 5 e 120 caracteres")
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Column(name = "CPF")
	@NotNull(message = "CPF é obrigatório")
	@Size(min = 11, max = 18, message = "CPF deve ter entre 11 digitos")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(name = "CELULAR")
	@NotNull(message = "Celular é obrigatório")
	@Size(min = 10, max = 20, message = "Celular deve ter entre 14 caracteres")
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	@Column(name = "DT_NASCIMENTO")
	@NotNull(message = "Data de Nascimento é obrigatório")
	@Size(min = 2, max = 20, message = "Data de Nascimento deve conter no maximo 15 caracteres")
	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	
	@Column(name = "EMAIL")
	@NotNull(message = "E-mail é obrigatório")
	@Size(min = 15, max = 100, message = "E-mail deve conter de 15 a 100 caracteres")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
