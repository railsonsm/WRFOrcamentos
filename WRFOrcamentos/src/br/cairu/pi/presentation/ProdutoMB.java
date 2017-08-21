package br.cairu.pi.presentation;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ba.cairu.pi.DAO.FabricanteDAO;
import ba.cairu.pi.DAO.ProdutoDAO;
import br.cairu.pi.entidade.Fabricante;
import br.cairu.pi.entidade.Produto;

@ManagedBean
@ViewScoped
public class ProdutoMB {
	private FabricanteDAO fabricanteDAO;
	private Fabricante fabricante;
	private Produto produto;
	private ProdutoDAO produtoDAO;
	private Integer idSelecao;
	
	public String buscarFabricPorId() {
		try {
			fabricante = getFabricanteDAO().buscarFabricPorId(idSelecao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostConstruct
	public void init() {
		this.fabricante =  new Fabricante();
		this.produto = new Produto();
	}
	
	public String salvar() {
		try {
			fabricante.setIdFabricante(idSelecao);
			produto.setFabricante(fabricante);
			getProdutoDAO().salvar(produto);
			fabricante =  new Fabricante();
			produto = new Produto();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public FabricanteDAO getFabricanteDAO() {
		if (fabricanteDAO == null) {
			fabricanteDAO = new FabricanteDAO();
		}
		return fabricanteDAO;
	}

	public void setFabricanteDAO(FabricanteDAO fabricanteDAO) {
		this.fabricanteDAO = fabricanteDAO;
	}

	public ProdutoDAO getProdutoDAO() {
		if (produtoDAO == null) {
			produtoDAO = new ProdutoDAO();
		}
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Integer getIdSelecao() {
		return idSelecao;
	}
	
	public void setIdSelecao(Integer idSelecao) {
		this.idSelecao = idSelecao;
	}

	
}
