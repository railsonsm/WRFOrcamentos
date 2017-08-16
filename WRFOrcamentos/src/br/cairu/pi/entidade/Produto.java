package br.cairu.pi.entidade;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idProduto;

	@Column
	private String descricao;
	@Column
	private Double valortabela;

	@JoinColumn(name = "idFabricante", referencedColumnName = "idFabricante")
	@ManyToOne(fetch = FetchType.EAGER)
	private Fabricante fabricante;

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
	
	
}
