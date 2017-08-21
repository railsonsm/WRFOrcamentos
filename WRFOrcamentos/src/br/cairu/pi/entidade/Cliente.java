package br.cairu.pi.entidade;

import javax.persistence.*;


@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer idCliente;
	
	@Column(name="nome", nullable=false) //Nullable = NOT NULL
	private String nome;
	
	@Column(name="nomeFantasia", nullable=false)
	private String nomeFantasia;
	
	@Column(name="cnpj", nullable=false)
	private String cnpj;
	
	@Column(name="cep", nullable=false)
	private String cep;
	
	@Column(name="rua", nullable=false)
	private String rua;
	
	@Column(name="numero", nullable=false)
	private Integer numero;
	
	@Column(name="complemento", nullable=false)
	private String complemento;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="telefone", nullable=false)
	private String telefone;
	
	@Column(name="celular",  nullable=false)
	private String celular;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
}
