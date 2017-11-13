package br.cairu.pi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "produto")
//@SequenceGenerator(name= "Prod_seq", sequenceName="produto_sequencia", initialValue = 1, allocationSize = 1)
public class Produto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Prod_seq")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProduto;

	@Column(name = "prod_codOriginal")
	private String codOriginal;
		
	@Column(name ="prod_descricao", nullable = false)
	private String descricao;
	
	@Column(name ="prod_unidade", nullable = false)
	private String unidade;
	
	@Column(name ="prod_qtdembalagem", nullable = false)
	private Double qtdembalagem;
	
	@Column(name ="prod_tamanho", nullable = false)
	private String tamanho;
	
	@Column(name = "prod_peso")
	private String peso;
	
	@Column(name = "prod_ambiente")
	private String ambiente;	
	
	@Column(name = "prod_valortabela", nullable = false)
	private Double valortabela;

	@JoinColumn(name = "idFabricante", referencedColumnName = "idFabricante",  foreignKey = @ForeignKey(name = "fk_fabricante"), nullable=false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Fabricante fabricante;
	
	@OneToMany(mappedBy="produto", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrcamentoProduto> orcamentoProdutos;

	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "OrcamentoProduto",
				joinColumns= {@JoinColumn(name = "idOrcamento"),}, 
				inverseJoinColumns={@JoinColumn(name="idProduto" )})
	private List<Orcamento> orcamentos;*/

	public List<OrcamentoProduto> getOrcamentoProdutos() {
		return orcamentoProdutos;
	}

	public void setOrcamentoProdutos(List<OrcamentoProduto> orcamentoProdutos) {
		this.orcamentoProdutos = orcamentoProdutos;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public Double getValortabela() {
		return valortabela;
	}

	public void setValortabela(Double valortabela) {
		this.valortabela = valortabela;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
/*
	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}*/
	
	public Double getQtdembalagem() {
		return qtdembalagem;
	}

	public String getCodOriginal() {
		return codOriginal;
	}

	public void setCodOriginal(String codOriginal) {
		this.codOriginal = codOriginal;
	}

	public void setQtdembalagem(Double qtdembalagem) {
		this.qtdembalagem = qtdembalagem;
	}
		
}
