package br.cairu.pi.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import br.cairu.pi.dao.ProdutoDAO;
import br.cairu.pi.model.Fabricante;
import br.cairu.pi.model.Produto;
import br.cairu.pi.view.MensagensView;

@ManagedBean
@ViewScoped
public class ProdutoMB {
	private Fabricante fabricante = new Fabricante();
	private Produto produto = new Produto();
	private Integer idSelecao;
	private List<Produto> produtosFiltrados;
	private String descricaoProduto;
	
	
		
	public String salvar() {
		try {		
			produto.setFabricante(fabricante);
			new ProdutoDAO().salvar(this.produto);
			this.fabricante =  new Fabricante();
			this.produto = new Produto();	
			MensagensView.SucessoMessage("Produto adicionado com sucesso!.", null);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public String editar() {
		new ProdutoDAO().editar(produto);
		this.produto = new Produto();
		this.fabricante = new Fabricante();
		MensagensView.SucessoMessage("Produto alterado com sucesso!.", null);
		return null;
	}
	
	public String excluir() {
		new ProdutoDAO().excluir(produto);
		this.produto = new Produto();
		MensagensView.SucessoMessage("Produto removido com sucesso!.", null);
		return null;
	}
	
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<String, Object>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 420);
		RequestContext.getCurrentInstance().openDialog("selecaoProduto", opcoes, null);
	}
	
	public void selecionarProduto(Produto produto) {
		RequestContext.getCurrentInstance().closeDialog(produto);
	}

	public void pesquisarProduto() {
		produtosFiltrados = new ProdutoDAO().porNomeSemelhante(this.descricaoProduto);
	}

	

	public void produtoSelecionado(SelectEvent event) {
		Produto produto = (Produto) event.getObject();
		setProduto(produto);
		fabricante = produto.getFabricante();
	}
	
	public void fabricanteSelecionado(SelectEvent event) {
		Fabricante fabricante = (Fabricante) event.getObject();
		setFabricante(fabricante);
		produto.setFabricante(fabricante);
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

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

}
