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
	@Id
	private Integer idOrcamento;
	@Id 
	private Integer idProduto;
	
	@Column 
	private Double valorOrcado;
	
	@JoinColumn(name = "idProduto", referencedColumnName = "idProduto",  foreignKey = @ForeignKey(name = "fk_Produto"), nullable=false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Produto produto;
	
	@JoinColumn(name = "idOrcamento", referencedColumnName = "idOrcamento",  foreignKey = @ForeignKey(name = "fk_Orcamento"), nullable=false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Orcamento orcamento;

	public Integer getIdOcamento() {
		return idOrcamento;
	}

	public void setIdOcamento(Integer idOcamento) {
		this.idOrcamento = idOcamento;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Double getValororcamento() {
		return valorOrcado;
	}

	public void setValororcamento(Double valororcamento) {
		this.valorOrcado = valororcamento;
	}

	public Produto getProduto() {
		return produto;
	}

	public Integer getIdOrcamento() {
		return idOrcamento;
	}

	public Double getValorOrcado() {
		return valorOrcado;
	}

	public void setIdOrcamento(Integer idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public void setValorOrcado(Double valorOrcado) {
		this.valorOrcado = valorOrcado;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	
}
