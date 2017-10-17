package br.cairu.pi.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
// @SequenceGenerator(name = "orc_seq", sequenceName = "orcamento_sequencia",
// initialValue =1,allocationSize =1)
public class Orcamento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrcamento;
	
	@Column(nullable = false)
	private Double valorOrcamento;

	private String formaPagamento;

	@Column(nullable = false)
	private String prazoEntrega;

	@Column(nullable = false)
	private String frete;

	@Temporal(TemporalType.DATE)
	private Date dataorcamento;

	private String obra;

	/*
	 * @ManyToMany(mappedBy="orcamentos", cascade = CascadeType.ALL) private
	 * List<Produto> produtos;
	 */

	@JoinColumn(name = "idFabricante", referencedColumnName = "idFabricante", foreignKey = @ForeignKey(name = "fk_fabricante_orc"), nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Fabricante fabricante;

	@JoinColumn(name = "idCliente", referencedColumnName = "idCliente", foreignKey = @ForeignKey(name = "fk_cliente"), nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;

	public Integer getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(Integer idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public Double getValorOrcamento() {
		return valorOrcamento;
	}

	public void setValorOrcamento(Double valorOrcamento) {
		this.valorOrcamento = valorOrcamento;
	}
	/*
	 * public List<Produto> getProdutos() { return produtos; }
	 * 
	 * public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
	 */

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public String getPrazoEntrega() {
		return prazoEntrega;
	}

	public String getFrete() {
		return frete;
	}

	public String getObra() {
		return obra;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public void setPrazoEntrega(String prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public void setFrete(String frete) {
		this.frete = frete;
	}

	public Date getDataorcamento() {
		return dataorcamento;
	}

	public void setDataorcamento(Date dataorcamento) {
		this.dataorcamento = dataorcamento;
	}

	public void setObra(String obra) {
		this.obra = obra;
	}

}