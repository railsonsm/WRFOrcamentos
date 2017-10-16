package br.cairu.pi.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

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
@ViewScoped
public class OrcamentoMB {
	private Cliente cliente = new Cliente();
	private Fabricante fabricante = new Fabricante();
	private Orcamento orcamento = new Orcamento();
	private Produto produto = new Produto();
	private OrcamentoProduto orcamentoProduto = new OrcamentoProduto();
	private Integer CodDoOrcamento;
	private boolean disabledInitOrc = false;
	private String itensOrcamento = "";
	private boolean disabledsalvar = true;
	private boolean disableitens = true;
	private List<OrcamentoProduto> orcamentoProdutos = new ArrayList<OrcamentoProduto>();
	private double valorTotal;

	@PostConstruct
	public void init() {
		mostrarCodOrcamento();
	}

	public String salvarOrcamento() {
		try {
			orcamento.setValorOrcamento(valorTotal);
			orcamento.setCliente(cliente);
			orcamento.setFabricante(fabricante);
			new OrcamentoDAO(Orcamento.class).salvar(orcamento);
			salvarOrcamentoProdutos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String salvarOrcamentoProdutos() {
		try {
			for (int i = 0; i<orcamentoProdutos.size(); i++) {
				new OrcamentoProdutoDAO(OrcamentoProduto.class).salvar(orcamentoProdutos.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void listaDeItens() {
		orcamentoProduto.setIdProduto(produto.getIdProduto());
		orcamentoProduto.setIdOrcamento(CodDoOrcamento);
		orcamentoProduto.setProduto(produto);
		orcamentoProduto.setOrcamento(orcamento);
		orcamentoProdutos.add(orcamentoProduto);
		this.orcamentoProduto = new OrcamentoProduto();
		this.produto = new Produto();
		this.disableitens = true;
	}

	public void calculaValorProduto(AjaxBehaviorEvent evento) {
		if (orcamentoProduto.getValorNoOrc() > produto.getValortabela()) {
			MensagensView.erroMessage("Valor orçado não pode ser maior que o de tabela", "erro!");
		} else {
			orcamentoProduto.setValorUnitario(orcamentoProduto.getValorNoOrc() * orcamentoProduto.getQuantidade());
			valorTotal = valorTotal + orcamentoProduto.getValorNoOrc();
		}
	}

	public void iniciaOrcamento() {
		this.itensOrcamento = "/WEB-INF/restrito/itensOrcamento.xhtml";
		this.disabledInitOrc = true;
		this.disabledsalvar = false;
	}

	public void mostrarCodOrcamento() {
		try {
			orcamento = new Orcamento();
			CodDoOrcamento = new OrcamentoDAO(Orcamento.class).mostrarCodOrcamento();
			System.out.println("RESULTADO" + orcamento);
		} catch (NullPointerException e) {
			CodDoOrcamento = 1;
		}
	}

	public void clienteSelecionado(SelectEvent event) {
		Cliente cliente = (Cliente) event.getObject();
		setCliente(cliente);
	}

	public void fabricanteSelecionado(SelectEvent event) {
		Fabricante fabricante = (Fabricante) event.getObject();
		setFabricante(fabricante);
	}

	public void produtoSelecionado(SelectEvent event) {
		Produto produto = (Produto) event.getObject();
		setProduto(produto);
		this.disableitens = false;
	}

	public List<OrcamentoProduto> getOrcamentoProdutos() {
		return orcamentoProdutos;
	}

	public void setOrcamentoProdutos(List<OrcamentoProduto> orcamentoProdutos) {
		this.orcamentoProdutos = orcamentoProdutos;
	}

	public boolean isDisableitens() {
		return disableitens;
	}

	public void setDisableitens(boolean disableitens) {
		this.disableitens = disableitens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public boolean isDisabledInitOrc() {
		return disabledInitOrc;
	}

	public String getItensOrcamento() {
		return itensOrcamento;
	}

	public boolean isDisabledsalvar() {
		return disabledsalvar;
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

	public void setDisabledInitOrc(boolean disabledInitOrc) {
		this.disabledInitOrc = disabledInitOrc;
	}

	public void setItensOrcamento(String itensOrcamento) {
		this.itensOrcamento = itensOrcamento;
	}

	public void setDisabledsalvar(boolean disabledsalvar) {
		this.disabledsalvar = disabledsalvar;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
