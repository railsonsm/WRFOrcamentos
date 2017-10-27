package br.cairu.pi.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.cairu.pi.dao.OrcamentoDAO;
import br.cairu.pi.dao.ProdutoDAO;
import br.cairu.pi.model.Cliente;
import br.cairu.pi.model.Fabricante;
import br.cairu.pi.model.Orcamento;
import br.cairu.pi.model.OrcamentoProduto;
import br.cairu.pi.model.Produto;
import br.cairu.pi.view.MensagensView;

@ManagedBean(name = "consultaMB")
@ViewScoped
public class ConsultaOrcamentoMB {
	private Cliente cliente = new Cliente();
	private Fabricante fabricante = new Fabricante();
	private Orcamento orcamento = new Orcamento();
	private Produto produto = new Produto();
	private OrcamentoProduto orcamentoProduto = new OrcamentoProduto();
	private List<OrcamentoProduto> consultaOrcamento;
	private List<Orcamento> orcamentosFiltrados;
	private Integer idSelecionado;
	private double frete = 0.0;

	public void consultaOrcamento() {
		consultaOrcamento = new OrcamentoDAO().buscaItensOrcamentos(idSelecionado);
		mostraFrete();
	}

	private void mostraFrete() {
		try {
			for (int i = 0; i <= 1; i++) {
				if (consultaOrcamento.get(0).getOrcamento().getFrete().equals("FOB")) {
					this.frete = 50.00;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			MensagensView.erroMessage("Orcamento não encontrado", null);
		}

	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<String, Object>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 420);
		RequestContext.getCurrentInstance().openDialog("selecaoOrcamento", opcoes, null);
	}

	public void selecionarOrcamento(Orcamento orcamento) {
		RequestContext.getCurrentInstance().closeDialog(orcamento);
	}

	public void pesquisarProduto() {
		orcamentosFiltrados = new ProdutoDAO().porNomeSemelhante(this.descricaoProduto);
		if (orcamentosFiltrados.isEmpty()) {
			MensagensView.erroMessage("Nenhum oçamento encontrado dentro deste periodo", null);
		}
	}

	public void produtoSelecionado(SelectEvent event) {
		Orcamento orcamento = (Orcamento) event.getObject();
		setOrcamento(orcamento);
	}

	public double getFrete() {
		return frete;
	}

	public void setFrete(double frete) {
		this.frete = frete;
	}

	public Integer getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(Integer idSelecionado) {
		this.idSelecionado = idSelecionado;
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

	public OrcamentoProduto getOrcamentoProduto() {
		return orcamentoProduto;
	}

	public List<OrcamentoProduto> getConsultaOrcamento() {
		return consultaOrcamento;
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

	public void setOrcamentoProduto(OrcamentoProduto orcamentoProduto) {
		this.orcamentoProduto = orcamentoProduto;
	}

	public List<Orcamento> getOrcamentosFiltrados() {
		return orcamentosFiltrados;
	}

	public void setConsultaOrcamento(List<OrcamentoProduto> consultaOrcamento) {
		this.consultaOrcamento = consultaOrcamento;
	}

	public void setOrcamentosFiltrados(List<Orcamento> orcamentosFiltrados) {
		this.orcamentosFiltrados = orcamentosFiltrados;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
