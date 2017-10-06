package br.cairu.pi.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name= "fabricante")
//@SequenceGenerator(name = "fac_seq", sequenceName="fabricante_sequencia", initialValue = 1, allocationSize = 1)
public class Fabricante implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator =  "fac_seq")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idFabricante;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(nullable = false)
	private String nomefantasia;
	
	@Column(nullable = false)
	private String cnpj;
	
	@Column(nullable = false)
	private String rua;
	
	@Column(nullable = false)
	private String complemento;
	
	@Column(nullable = false)
	private Integer numero;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private String estado;
	
	@Column(nullable = false)
	private String telefone1;
	
	@Column(nullable = false)
	private String telefone2;
	
	@Column(nullable = false)	
	private String celular1;
	
	@Column(nullable = false)	
	private String celular2;
	
	@Column(nullable = false)	
	private String contatoComer;
	
	@Column(nullable = false)
	private String emailComer;
	
	@Column(nullable = false)	
	private String contatoTec;
	
	@Column(nullable = false)
	private String emailTec;

	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String cep;
	
	public Integer getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Integer idFabricante) {
		this.idFabricante = idFabricante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomefantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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

	public String getContatoComer() {
		return contatoComer;
	}

	public void setContatoComer(String contatoComer) {
		this.contatoComer = contatoComer;
	}

	public String getEmailComer() {
		return emailComer;
	}

	public void setEmailComer(String emailComer) {
		this.emailComer = emailComer;
	}

	public String getContatoTec() {
		return contatoTec;
	}

	public void setContatoTec(String contatoTec) {
		this.contatoTec = contatoTec;
	}

	public String getEmailTec() {
		return emailTec;
	}

	public void setEmailTec(String emailTec) {
		this.emailTec = emailTec;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
		
	
}
