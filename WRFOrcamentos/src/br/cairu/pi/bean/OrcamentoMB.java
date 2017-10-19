package br.cairu.pi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.cairu.pi.dao.FabricanteDAO;
import br.cairu.pi.dao.OrcamentoDAO;
import br.cairu.pi.dao.OrcamentoProdutoDAO;
import br.cairu.pi.model.Cliente;
import br.cairu.pi.model.Fabricante;
import br.cairu.pi.model.Orcamento;
import br.cairu.pi.model.OrcamentoProduto;
import br.cairu.pi.model.Produto;
import br.cairu.pi.view.MensagensView;

@ManagedBean
@SessionScoped
public class OrcamentoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente = new Cliente();
	private Fabricante fabricante = new Fabricante();
	private Orcamento orcamento = new Orcamento();
	private Produto produto = new Produto();
	private OrcamentoProduto orcamentoProduto = new OrcamentoProduto();
	private Integer CodDoOrcamento;
	private boolean disableitens = true;
	private List<OrcamentoProduto> orcamentoProdutos = new ArrayList<OrcamentoProduto>();
	private double valorTotal = 0.0;
	private boolean requiredProd = true;
	private boolean disablesalvar = true;
	private double mostraFrete;
	private List<Produto> produtosFiltrados;
	private String descricaoProduto;
	private Integer idBuscaFabric;
	
	public String salvarOrcamento() {
		try {
			if (orcamentoProdutos.isEmpty()) {
				MensagensView.erroMessage("Insira Pelo menos um produto", null);
			} else {
				orcamento.setValorOrcamento(valorTotal);
				orcamento.setCliente(cliente);
				orcamento.setFabricante(fabricante);
				new OrcamentoDAO().salvar(orcamento);
				for (OrcamentoProduto op : orcamentoProdutos) {
					new OrcamentoProdutoDAO().salvar(op);
				}
				MensagensView.SucessoMessage("Orcamento adicionado com sucesso", null);
				fimDoOrcamento();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void fimDoOrcamento() {
		this.orcamento = new Orcamento();
		this.produto = new Produto();
		this.orcamentoProduto = new OrcamentoProduto();
		this.fabricante = new Fabricante();
		this.orcamentoProdutos = new ArrayList<OrcamentoProduto>();
		this.cliente = new Cliente();
		requiredProd = true;
		valorTotal = 0.0;
	}

	public void listaDeItens() {
		try {
			valorTotal = valorTotal + orcamentoProduto.getValorUnitario();
			for (int i = 0; i < orcamentoProdutos.size(); i++) {
				if (orcamentoProdutos.get(i).getProduto().getIdProduto().equals(produto.getIdProduto())) {
					MensagensView.erroMessage("Produto já consta no orçamento", null);
					this.produto = new Produto();
					this.orcamento = new Orcamento();
					this.orcamentoProduto = new OrcamentoProduto();
					this.disableitens = true;
					return;
				}
			}
			orcamentoProduto.setProduto(produto);
			orcamento.setIdOrcamento(CodDoOrcamento);
			orcamentoProduto.setOrcamento(orcamento);
			if (orcamentoProduto.getValorUnitario() <= 0.0) {
				MensagensView.erroMessage("Valor unitário não pode ser zero(0.0)", null);
			} else {
				orcamentoProdutos.add(orcamentoProduto);
				this.orcamentoProduto = new OrcamentoProduto();
				this.produto = new Produto();
				this.orcamento = new Orcamento();
				this.disableitens = true;
			}		
			if (!orcamentoProdutos.isEmpty()) {
				requiredProd = false;
				disablesalvar = false;
			}
		} catch (NullPointerException e) {
			MensagensView.erroMessage("Insira o frete e pelo menos um produto", null);
		}

	}

	public void removeItenLista(OrcamentoProduto op) {
		if(!orcamentoProdutos.isEmpty()) {
			orcamentoProdutos.remove(op);
			valorTotal = valorTotal - op.getValorUnitario();
			checaLista();
		}
	}
	public void checaLista() {
		if(orcamentoProdutos.isEmpty()) {
			disablesalvar = true;
		}
	}

	public void calculaValorProduto(AjaxBehaviorEvent evento) {
		if (orcamentoProduto.getValorNoOrc() > produto.getValortabela()) {
			MensagensView.erroMessage("Valor orçado não pode ser maior que o de tabela", "erro!");
		} else {
			orcamentoProduto.setValorUnitario(orcamentoProduto.getValorNoOrc() * orcamentoProduto.getQuantidade());
		}
	}

	public void mostrarCodOrcamento(ComponentSystemEvent event) {
		try {
			orcamento = new Orcamento();
			CodDoOrcamento = new OrcamentoDAO().mostrarCodOrcamento();
			System.out.println("RESULTADO" + orcamento);
		} catch (NullPointerException e) {
			CodDoOrcamento = 1;
		}
	}

	public void selecionarFabricante(Fabricante fabricante) {
		RequestContext.getCurrentInstance().closeDialog(fabricante);
	}

	public void pesquisarProduto() {
		produtosFiltrados = new OrcamentoDAO().buscaProdutoFabric(this.descricaoProduto, idBuscaFabric);
		if(produtosFiltrados.isEmpty()) {
			MensagensView.erroMessage("nenhum produto encontrado com essa descricao", null);
		}
	}

	public void produtoSelecionado(SelectEvent event) {
		Produto produto = (Produto) event.getObject();
		setProduto(produto);
		this.disableitens = false;
	}

	public void clienteSelecionado(SelectEvent event) {
		Cliente cliente = (Cliente) event.getObject();
		setCliente(cliente);
		
	}

	public void fabricanteSelecionado(SelectEvent event) {
		//FacesContext context = FacesContext.getCurrentInstance();
		//context.getExternalContext().getFlash().entrySet();
		Fabricante fabricante = (Fabricante) event.getObject();
		setFabricante(fabricante);
		setIdBuscaFabric(this.fabricante.getIdFabricante());
		this.orcamentoProdutos = new ArrayList<OrcamentoProduto>();
		this.valorTotal = 0.0;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public Produto getProduto() {
		return produto;
	}

	public OrcamentoProduto getOrcamentoProduto() {
		return orcamentoProduto;
	}

	public Integer getCodDoOrcamento() {
		return CodDoOrcamento;
	}

	public boolean isDisableitens() {
		return disableitens;
	}

	public List<OrcamentoProduto> getOrcamentoProdutos() {
		return orcamentoProdutos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public boolean isRequiredProd() {
		return requiredProd;
	}

	public double getMostraFrete() {
		return mostraFrete;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public Integer getIdBuscaFabric() {
		return idBuscaFabric;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setOrcamentoProduto(OrcamentoProduto orcamentoProduto) {
		this.orcamentoProduto = orcamentoProduto;
	}

	public void setCodDoOrcamento(Integer codDoOrcamento) {
		CodDoOrcamento = codDoOrcamento;
	}

	public void setDisableitens(boolean disableitens) {
		this.disableitens = disableitens;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setRequiredProd(boolean requiredProd) {
		this.requiredProd = requiredProd;
	}

	public void setMostraFrete(double mostraFrete) {
		this.mostraFrete = mostraFrete;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public void setIdBuscaFabric(Integer idBuscaFabric) {
		this.idBuscaFabric = idBuscaFabric;
	}

	public boolean isDisablesalvar() {
		return disablesalvar;
	}

	public void setDisablesalvar(boolean disablesalvar) {
		this.disablesalvar = disablesalvar;
	}
	
}
