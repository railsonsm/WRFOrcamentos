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
	
	@Column(name="rua", nullable=false)
	private String rua;
	
	@Column(name="numero", nullable=false)
	private Integer numero;
	
	@Column(name="complemento", nullable=false)
	private String complemento;

	public Integer getCodigo() {
		return idCliente;
	}

	public void setCodigo(Integer codigo) {
		this.idCliente = codigo;
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
	
	
}
