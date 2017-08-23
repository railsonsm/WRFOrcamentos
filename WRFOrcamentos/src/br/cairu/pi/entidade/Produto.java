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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idProduto;

	@Column
	private String descricao;
	@Column
	private Double valortabela;

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

	public Double getValortabela() {
		return valortabela;
	}

	public void setValortabela(Double valortabela) {
		this.valortabela = valortabela;
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
	
	 
}
