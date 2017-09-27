package br.cairu.pi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.cairu.pi.model.Fabricante;
import br.cairu.pi.repository.FabricanteDAO;
import br.cairu.pi.view.ConfirmacaoView;

@ManagedBean
@ViewScoped
public class FabricanteMB {
	private Fabricante fabricante;
	private FabricanteDAO fabricanteDAO;
	private String nomeFabricante;
	private List<Fabricante> fabricantesFiltrados; 
	private Integer idSelecao;
	private ConfirmacaoView confirmacaoView;
	
	
	@PostConstruct
	public void init() {
		this.fabricante = new Fabricante();
		this.confirmacaoView = new ConfirmacaoView();
	}
	
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<String, Object>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 420);
		RequestContext.getCurrentInstance().openDialog("selecaoFabricante", opcoes, null);
	}
	
	public void fabricanteSelecionado(SelectEvent event) {
		Fabricante fabricante = (Fabricante) event.getObject();
		setFabricante(fabricante);
	}
	
	public void pesquisarFabricante() {
		fabricantesFiltrados = getFabricanteDAO().porNomeSemelhante(nomeFabricante);
	}
	
	public void selecionarFabricante(Fabricante fabricante) {
		RequestContext.getCurrentInstance().closeDialog(fabricante);
	}
	
	public String salvar() {
		try {
			getFabricanteDAO().salvar(fabricante);
			fabricante = new Fabricante();
			confirmacaoView.msgSalvaFab();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String editar() {
		try {
			getFabricanteDAO().editar(fabricante);
			fabricante = new Fabricante();
			confirmacaoView.msgEditFab();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String excluir() {
		try {
			getFabricanteDAO().excluir(fabricante.getIdFabricante());
			fabricante = new Fabricante();
			confirmacaoView.msgExcluiFab();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public String mostraFabricPorId() {
		try {
			fabricante = getFabricanteDAO().buscarFabricPorId(idSelecao);
			System.out.println("Railson" + idSelecao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	public String getNomeFabricante() {
		return nomeFabricante;
	}

	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}

	public List<Fabricante> getFabricantesFiltrados() {
		return fabricantesFiltrados;
	}

	public void setFabricantesFiltrados(List<Fabricante> fabricantesFiltrados) {
		this.fabricantesFiltrados = fabricantesFiltrados;
	}

	public ConfirmacaoView getConfirmacaoView() {
		return confirmacaoView;
	}

	public void setConfirmacaoView(ConfirmacaoView confirmacaoView) {
		this.confirmacaoView = confirmacaoView;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	public FabricanteDAO getFabricanteDAO() {
		if(fabricanteDAO == null) {
			fabricanteDAO = new FabricanteDAO();
		}
		return fabricanteDAO;
	}
	public void setFabricanteDAO(FabricanteDAO fabricanteDAO) {
		this.fabricanteDAO = fabricanteDAO;
	}


	public Integer getIdSelecao() {
		return idSelecao;
	}

	public void setIdSelecao(Integer idSelecao) {
		this.idSelecao = idSelecao;
	}
	
	
	
}
