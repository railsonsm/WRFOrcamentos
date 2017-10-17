package br.cairu.pi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrcamentoProduto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Id
	//private Integer idOrcamento;
	//@Id 
	//private Integer idProduto;
	
	@Column(nullable=false)
	private int quantidade;
	
	@Column(nullable=false)
	private double valorNoOrc;
	
	@Column(nullable=false)
	private double valorUnitario;
	
	@Id
	@JoinColumn(name = "idProduto", referencedColumnName = "idProduto",  foreignKey = @ForeignKey(name = "fk_Produto"), nullable=false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Produto produto;
	
	@Id 
	@JoinColumn(name = "idOrcamento", referencedColumnName = "idOrcamento",  foreignKey = @ForeignKey(name = "fk_Orcamento"), nullable=false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Orcamento orcamento;

	public int getQuantidade() {
		return quantidade;
	}

	public double getValorNoOrc() {
		return valorNoOrc;
	}

	public Produto getProduto() {
		return produto;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setValorNoOrc(double valorNoOrc) {
		this.valorNoOrc = valorNoOrc;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	
	
	
	
	
}
