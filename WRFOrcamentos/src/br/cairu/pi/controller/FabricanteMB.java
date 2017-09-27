package br.cairu.pi.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import br.cairu.pi.model.Fabricante;
import br.cairu.pi.repository.FabricanteDAO;
import br.cairu.pi.view.MensagensView;

@ManagedBean
@ViewScoped
public class FabricanteMB {
	private Fabricante fabricante;
	private FabricanteDAO fabricanteDAO;
	private String nomeFabricante;
	private List<Fabricante> fabricantesFiltrados; 
	private Integer idSelecao;
	private MensagensView confirmacaoView;
	
	
	@PostConstruct
	public void init() {
		this.fabricante = new Fabricante();
		this.confirmacaoView = new MensagensView();
	}
	
	public void fabricanteSelecionado(SelectEvent event) {
		Fabricante fabricante = (Fabricante) event.getObject();
		setFabricante(fabricante);
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
	
	@SuppressWarnings("finally")
	public String excluir(){
		try {
			getFabricanteDAO().excluir(fabricante.getIdFabricante());
			fabricante = new Fabricante();
			confirmacaoView.msgExcluiFab();
		}catch (javax.persistence.RollbackException e) {
			 MensagensView.msgRelFabPro();
		}catch (javax.persistence.PersistenceException e) {
		 System.out.println("Objeto relariocionado");
		 fabricante = new  Fabricante();
		 }finally {
			return null;
		}
	}
	
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
		
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

	public MensagensView getConfirmacaoView() {
		return confirmacaoView;
	}

	public void setConfirmacaoView(MensagensView confirmacaoView) {
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
