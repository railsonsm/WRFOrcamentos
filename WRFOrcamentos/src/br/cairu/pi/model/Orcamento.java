package br.cairu.pi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name = "orc_valorOrcamento", nullable = false)
	private Double valorOrcamento;
	
	@Column(name = "orc_formaPagamento", nullable = false)
	private String formaPagamento;
	
	@Column(name = "orc_nomeCliente")
	private String nomeCliente;

	@Column(name = "orc_prazoEntrega", nullable = false)
	private String prazoEntrega;

	@Column(name = "orc_frete", nullable = false)
	private String frete;

	@Temporal(TemporalType.DATE)
	@Column(name = "orc_dataorcamento", nullable = false)
	private Date dataorcamento;

	@Column(name = "orc_obra")
	private String obra;

	/*
	 * @ManyToMany(mappedBy="orcamentos", cascade = CascadeType.ALL) private
	 * List<Produto> produtos;
	 */

	@JoinColumn(name = "idFabricante", referencedColumnName = "idFabricante", foreignKey = @ForeignKey(name = "fk_fabricante_orc"), nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Fabricante fabricante;

	@JoinColumn(name = "idCliente", referencedColumnName = "idCliente", foreignKey = @ForeignKey(name = "fk_cliente"), nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@OneToMany(mappedBy="orcamento", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrcamentoProduto> orcamentoProdutos;

	
	public List<OrcamentoProduto> getOrcamentoProdutos() {
		return orcamentoProdutos;
	}

	public void setOrcamentoProdutos(List<OrcamentoProduto> orcamentoProdutos) {
		this.orcamentoProdutos = orcamentoProdutos;
	}
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

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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