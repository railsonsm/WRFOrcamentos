package br.cairu.pi.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.cairu.pi.dao.OrcamentoDAO;
import br.cairu.pi.model.Cliente;
import br.cairu.pi.model.Fabricante;
import br.cairu.pi.model.Orcamento;
import br.cairu.pi.model.OrcamentoProduto;
import br.cairu.pi.model.Produto;
import br.cairu.pi.report.Relatorio;
import br.cairu.pi.view.MensagensView;

@ManagedBean(name = "consultaMB")
@ViewScoped
public class ConsultaOrcamentoMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente = new Cliente();
	private Fabricante fabricante = new Fabricante();
	private Orcamento orcamento = new Orcamento();
	private Produto produto = new Produto();
	private OrcamentoProduto orcamentoProduto = new OrcamentoProduto();
	private List<OrcamentoProduto> consultaOrcamentos;
	private List<Orcamento> orcamentosFiltrados;
	private Integer idSelecionado;
	private double valorOrcamento;
	private int limitaLista;
	private String nomeCliente;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio = new Date() ;
	@Temporal(TemporalType.DATE)
	private Date dataFim =  new Date();

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

	public void buscaOrcProData() {
		orcamentosFiltrados = new OrcamentoDAO().buscaOrcamentosPorData(dataInicio, dataFim, nomeCliente);
		if (orcamentosFiltrados.isEmpty()) {
			MensagensView.erroMessage("Nenhum oçamento encontrado dentro deste periodo", null);
		}
	}

	public void orcamentoSelecionado(SelectEvent event) {
		Orcamento orcamento = (Orcamento) event.getObject();
		setOrcamento(orcamento);
		consultaOrcamentos = new OrcamentoDAO().buscaItensOrcamentos(orcamento.getIdOrcamento());
		valorOrcamento =  consultaOrcamentos.get(0).getOrcamento().getValorOrcamento();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void emitirRelatorio() {
		Relatorio relatorio = new Relatorio();
		
		HashMap<String, Object> parametro = new HashMap<String, Object>();
		parametro.put("o.idOrcamento", orcamento.getIdOrcamento());
		relatorio.getRelatorio(parametro);
		
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public int getLimitaLista() {
		return limitaLista;
	}

	public void setLimitaLista(int limitaLista) {
		this.limitaLista = limitaLista;
	}

	public double getValorOrcamento() {
		return valorOrcamento;
	}

	public void setValorOrcamento(double valorOrcamento) {
		this.valorOrcamento = valorOrcamento;
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

	public List<OrcamentoProduto> getConsultaOrcamentos() {
		return consultaOrcamentos;
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

	public void setConsultaOrcamentos(List<OrcamentoProduto> consultaOrcamentos) {
		this.consultaOrcamentos = consultaOrcamentos;
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
