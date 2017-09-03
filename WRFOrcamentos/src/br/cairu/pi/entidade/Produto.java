package br.cairu.pi.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "produto")
@SequenceGenerator(name= "Prod_seq", sequenceName="produto_sequencia", initialValue = 1, allocationSize = 1)
public class Produto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Prod_seq")
	private Integer idProduto;

	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Integer unidade;
	
	@Column(nullable = false)
	private Integer qtdembalagem;
	
	@Column(nullable = false)
	private String tamanho;
	
	@Column(nullable = false)
	private String peso;
	
	@Column(nullable = false)
	private Double fretecif;
	
	@Column(nullable = false)
	private Double fretefob;
	
	@Column(nullable = false)
	private String ambiente;	

	@JoinColumn(name = "idFabricante", referencedColumnName = "idFabricante",  foreignKey = @ForeignKey(name = "fk_fabricante"), nullable=false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Fabricante fabricante;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "OrcamentoProduto",
				joinColumns= {@JoinColumn(name = "idOrcamento"),}, 
				inverseJoinColumns={@JoinColumn(name="idProduto" )})
	private List<Orcamento> orcamentos;

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

	public Integer getUnidade() {
		return unidade;
	}

	public void setUnidade(Integer unidade) {
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

	public Double getFretecif() {
		return fretecif;
	}

	public void setFretecif(Double fretecif) {
		this.fretecif = fretecif;
	}

	public Double getFretefob() {
		return fretefob;
	}

	public void setFretefob(Double fretefob) {
		this.fretefob = fretefob;
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

	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public Integer getQtdembalagem() {
		return qtdembalagem;
	}

	public void setQtdembalagem(Integer qtdembalagem) {
		this.qtdembalagem = qtdembalagem;
	}

		
}
