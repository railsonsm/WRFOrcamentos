package br.cairu.pi.entidade;

import javax.persistence.*;


@Entity
@Table(name= "fabricante")
public class Fabricante {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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

	
}
