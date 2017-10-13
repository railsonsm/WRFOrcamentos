package br.cairu.pi.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.event.SelectEvent;

import br.cairu.pi.dao.OrcamentoDAO;
import br.cairu.pi.model.Cliente;
import br.cairu.pi.model.Fabricante;
import br.cairu.pi.model.Orcamento;
import br.cairu.pi.model.Produto;

@ManagedBean
@ViewScoped
public class OrcamentoMB {
	private Cliente cliente = new Cliente();
	private Fabricante fabricante = new Fabricante();
	private Orcamento orcamento = new Orcamento();
	private Produto produto = new Produto();
	private Integer CodDoOrcamento;
	private boolean disabled = false;
	private String itensOrcamento = "";
	private boolean disabledsalvar = true;

	@PostConstruct
	public void init() {
		mostrarCodOrcamento();
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

	public void instancia() {
		this.cliente = new Cliente();
		this.fabricante = new Fabricante();
	}
	
	public void iniciaOrcamento() {
		this.itensOrcamento = "/WEB-INF/restrito/itensOrcamento.xhtml"; 
		this.disabled = true;
		this.disabledsalvar = false;
	}

	
	public String salvar() {
		orcamento.setCliente(cliente);
		orcamento.setFabricante(fabricante);
		new OrcamentoDAO(Orcamento.class).salvar(this.orcamento);
		return null;
	}

	public void clienteSelecionado(SelectEvent event) {
		Cliente cliente = (Cliente) event.getObject();
		setCliente(cliente);
	}

	public void fabricanteSelecionado(SelectEvent event) {
		Fabricante fabricante = (Fabricante) event.getObject();
		setFabricante(fabricante);
	}
	
	

	
	public boolean isDisabledsalvar() {
		return disabledsalvar;
	}

	public void setDisabledsalvar(boolean disabledsalvar) {
		this.disabledsalvar = disabledsalvar;
	}

	public String getItensOrcamento() {
		return itensOrcamento;
	}

	public void setItensOrcamento(String itensOrcamento) {
		this.itensOrcamento = itensOrcamento;
	}

	public String getitensOrcamento() {
		return itensOrcamento;
	}

	public void setitensOrcamento(String itens) {
		this.itensOrcamento = itens;
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

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getCodDoOrcamento() {
		return CodDoOrcamento;
	}

	public void setCodDoOrcamento(Integer codDoOrcamento) {
		CodDoOrcamento = codDoOrcamento;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

}
