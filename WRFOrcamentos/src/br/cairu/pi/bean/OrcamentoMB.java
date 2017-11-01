package br.cairu.pi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

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
	private Integer codDoOrcamento;
	private boolean disableitens = true;
	private List<OrcamentoProduto> orcamentoProdutos = new ArrayList<OrcamentoProduto>();
	private double valorTotal = 0.0;
	private boolean requiredProd = true;
	private boolean disablesalvar = true;
	private List<Produto> produtosFiltrados;
	private String descricaoProduto;
	private Integer idBuscaFabric;
	

	@PostConstruct
	public void init() {
		mostrarCodOrcamento();
	}
	
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

	// ITENS ORCAMENTO
	public void listaDeItens() {
		try {
			
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
			orcamento.setIdOrcamento(codDoOrcamento);
			orcamentoProduto.setOrcamento(orcamento);
			if (orcamentoProduto.getValorUnitario() <= 0.0) {
				MensagensView.erroMessage("Valor unitário não pode ser menor ou igual a zero(0.0)", null);
			} else {
				valorTotal = valorTotal + orcamentoProduto.getValorUnitario();
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
			MensagensView.erroMessage("Insira pelo menos um produto", null);
		}

	}


	// REMOVE DA LISTA E CHECA SE ESTA VAZIA
	public void removeItenLista(OrcamentoProduto op) {
		if (!orcamentoProdutos.isEmpty()) {
			orcamentoProdutos.remove(op);
			valorTotal = valorTotal - op.getValorUnitario();
			checaLista();
		}
	}

	public void checaLista() {
		if (orcamentoProdutos.isEmpty()) {
			disablesalvar = true;
		}
	}

	// CALCULA O VALOR UNITARIO DO PRODUTO
	public void calculaValorProduto(AjaxBehaviorEvent evento) {
		if (orcamentoProduto.getValorNoOrc() > produto.getValortabela()) {
			MensagensView.erroMessage("Valor orçado não pode ser maior que o de tabela", "erro!");
		} else {
			orcamentoProduto.setValorUnitario(orcamentoProduto.getValorNoOrc() * orcamentoProduto.getQuantidade());
		}
	}

	// CODIGO FICTICIO DE ORMCAMENTO
	public void mostrarCodOrcamento() {
		try {
			orcamento = new Orcamento();
			codDoOrcamento = new OrcamentoDAO().mostrarCodOrcamento();
			System.out.println("RESULTADO" + orcamento);
		} catch (NullPointerException e) {
			codDoOrcamento = 1;
		}
	}

	// SELECIONA E BUSCA PRODUTO NA CAIXA DE DIALOGO
	public void selecionarFabricante(Fabricante fabricante) {
		RequestContext.getCurrentInstance().closeDialog(fabricante);
	}

	public void pesquisarProduto() {
		try {
			if(idBuscaFabric == null) {
				MensagensView.erroMessage("Selecione primeiro o fabricante", null);
			}else {
				produtosFiltrados = new OrcamentoDAO().buscaProdutoFabric(this.descricaoProduto, this.idBuscaFabric);
				if (produtosFiltrados.isEmpty()) {
					MensagensView.erroMessage("Nenhum produto encontrado com essa descrição", null);
				}
			}			
		} catch (NullPointerException e) {
			MensagensView.erroMessage("Selecione primeiro o fabricante", null);
		}
	}

	
	// ITENS SELECIONADOS
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
		Fabricante fabricante = (Fabricante) event.getObject();
		setFabricante(fabricante);
		setIdBuscaFabric(this.fabricante.getIdFabricante());
		this.orcamentoProdutos = new ArrayList<OrcamentoProduto>();
		this.produtosFiltrados = new ArrayList<Produto>();
		this.produto = new Produto();
		this.disableitens = true;
		this.valorTotal = 0.0;
		this.disablesalvar = true;
	}

	
	
	public void fimDoOrcamento() {
		this.orcamento = new Orcamento();
		this.produto = new Produto();
		this.orcamentoProduto = new OrcamentoProduto();
		this.fabricante = new Fabricante();
		this.orcamentoProdutos = new ArrayList<OrcamentoProduto>();
		this.produtosFiltrados = new ArrayList<Produto>();
		this.cliente = new Cliente();
		this.disablesalvar = true;
		idBuscaFabric = null;
		requiredProd = true;
		valorTotal = 0.0;
		mostrarCodOrcamento();
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
		return codDoOrcamento;
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
		this.codDoOrcamento = codDoOrcamento;
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

	public void setOrcamentoProdutos(List<OrcamentoProduto> orcamentoProdutos) {
		this.orcamentoProdutos = orcamentoProdutos;
	}

	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

}
