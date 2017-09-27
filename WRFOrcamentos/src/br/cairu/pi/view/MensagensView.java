package br.cairu.pi.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class MensagensView {
	public void msgSalvaCli() {
		addMessage("Cliente Adicionado com sucesso", null);
	}
	public void msgEditCli() {
		addMessage("Cliente alterado com sucesso", null);
	}
	public void msgExcluiCli() {
		addMessage("Cliente excluido com sucesso",null);
	}
	
	public void msgSalvaFab() {
		addMessage("Fabricante Adicionado com sucesso", null);
	}
	public void msgEditFab() {
		addMessage("Fabricante alterado com sucesso", null);
	}
	public void msgExcluiFab() {
		addMessage("Fabricante excluido com sucesso",null);
	}
	
	public void msgSalvaProd() {
		addMessage("Produto Adicionado com sucesso", null);
	}
	public void msgEditProd() {
		addMessage("Produto alterado com sucesso", null);
	}
	public void msgExcluiProd() {
		addMessage("Produto excluido com sucesso",null);
	}
	
	public static void msgRelFabPro() {
		erroMessage("Não é possivel excluir o fabricante. O mesmo existe em um cadastro de produto",null);
	}


	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
		
	}
	public static void erroMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
		
	}
	
}
