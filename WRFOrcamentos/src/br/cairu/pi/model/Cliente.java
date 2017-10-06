package br.cairu.pi.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "cliente")
//@SequenceGenerator(name = "cli_seq", sequenceName= "cliente_sequencia", initialValue=1, allocationSize = 1)
public class Cliente  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cli_seq")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@Column(nullable=false)
	private String cidade;
	
	@Column(nullable=false)
	private String estado;
	
	@Column(nullable=false)
	private String telefone1;
	
	@Column(nullable=false)
	private String telefone2;
	
	@Column(nullable=false)
	private String celular1;
	
	@Column(nullable=false)
	private String celular2;
	
	@Column(nullable=false)
	private String contatoEng;
	
	@Column(nullable=false)
	private String emailEng;
	
	@Column(nullable=false)
	private String contatoSupr;
	
	@Column(nullable=false)
	private String emailSupr;

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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getCelular1() {
		return celular1;
	}

	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}

	public String getCelular2() {
		return celular2;
	}

	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}

	public String getContatoEng() {
		return contatoEng;
	}

	public void setContatoEng(String contatoEng) {
		this.contatoEng = contatoEng;
	}

	public String getEmailEng() {
		return emailEng;
	}

	public void setEmailEng(String emailEng) {
		this.emailEng = emailEng;
	}

	public String getContatoSupr() {
		return contatoSupr;
	}

	public void setContatoSupr(String contatoSupr) {
		this.contatoSupr = contatoSupr;
	}

	public String getEmailSupr() {
		return emailSupr;
	}

	public void setEmailSupr(String emailSupr) {
		this.emailSupr = emailSupr;
	}
	
	
	
}
