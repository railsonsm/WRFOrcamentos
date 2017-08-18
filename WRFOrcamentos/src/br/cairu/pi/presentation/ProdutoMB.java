package br.cairu.pi.presentation;

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
	
	public FabricanteDAO getFabricanteDAO() {
		if(fabricanteDAO == null) {
			fabricanteDAO = new FabricanteDAO();
		}
		return fabricanteDAO;
	}
	public void setFabricanteDAO(FabricanteDAO fabricanteDAO) {
		this.fabricanteDAO = fabricanteDAO;
	}
	public Fabricante getFabricante() {
		if(fabricante == null) {
			fabricante = new Fabricante();
		}
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	public Produto getProduto() {
		if(produto == null) {
			produto = new Produto();
		}
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public ProdutoDAO getProdutoDAO() {
		if(produtoDAO == null)
		{
			produtoDAO = new ProdutoDAO();
		}
		return produtoDAO;
	}
	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}
		
	public Integer getIdSelecao() {
		return idSelecao;
	}
	public void setIdSelecao(Integer idSelecao) {
		this.idSelecao = idSelecao;
	}
	
	public String buscarFabricPorId() {
		try {
			getFabricante();
			getFabricanteDAO().buscarFabricanteporId(idSelecao); 
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return fabricante.getNome();
	}
	
	public String salvar() {
		try {
			//fabricante =  new Fabricante();
			//produto = new Produto();
			getFabricante().setIdFabricante(idSelecao);
			getProduto().setFabricante(getFabricante());
			getProdutoDAO().salvar(getProduto());
			fabricante =  new Fabricante();
			produto = new Produto();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	
}
