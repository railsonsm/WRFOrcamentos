package br.cairu.pi.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "fabricante")
public class Fabricante {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(nullable = false)
	private String nomefantasia;
	
	@Column(nullable = false)
	private String rua;
	
	@Column(nullable = false)
	private String complemento;
	
	@Column(nullable = false)
	private int numero;
	
	@Column(nullable = false)
	private double valortabela;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getValortabela() {
		return valortabela;
	}

	public void setValortabela(double valortabela) {
		this.valortabela = valortabela;
	}
	
	
}
