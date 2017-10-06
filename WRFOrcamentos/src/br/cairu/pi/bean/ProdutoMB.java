package br.cairu.pi.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.cairu.pi.dao.FabricanteDAO;
import br.cairu.pi.dao.ProdutoDAO;
import br.cairu.pi.model.Fabricante;
import br.cairu.pi.model.Produto;
import br.cairu.pi.view.MensagensView;

@ManagedBean
@ViewScoped
public class ProdutoMB {
	private FabricanteDAO fabricanteDAO;
	private Fabricante fabricante;
	private Produto produto;
	private ProdutoDAO produtoDAO;
	private Integer idSelecao;
	private List<Fabricante> fabricantesFiltrados;
	private String nomeFabricante;
	private MensagensView confirmacaoView;
	
	@PostConstruct
	public void init() {
		this.fabricante =  new Fabricante();
		this.produto = new Produto();
		this.confirmacaoView = new MensagensView();	
	}
	
	public void fabricanteSelecionado(SelectEvent event) {
		Fabricante fabricante = (Fabricante) event.getObject();
		setFabricante(fabricante);
	}
		
	public String salvar() {
		try {			
			//fabricante.setIdFabricante(idSelecao);
			produto.setFabricante(fabricante);
			getProdutoDAO().salvar(produto);
			fabricante =  new Fabricante();
			produto = new Produto();	
			confirmacaoView.msgSalvaProd();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	
	
	public MensagensView getConfirmacaoView() {
		return confirmacaoView;
	}

	public void setConfirmacaoView(MensagensView confirmacaoView) {
		this.confirmacaoView = confirmacaoView;
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

	public List<Fabricante> getFabricantesFiltrados() {
		return fabricantesFiltrados;
	}

	public void setFabricantesFiltrados(List<Fabricante> fabricantesFiltrados) {
		this.fabricantesFiltrados = fabricantesFiltrados;
	}

	public String getNomeFabricante() {
		return nomeFabricante;
	}

	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}

		
}
