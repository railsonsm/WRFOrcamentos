package br.cairu.pi.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.cairu.pi.dao.UsuarioDAO;
import br.cairu.pi.model.Usuario;
import br.cairu.pi.view.MensagensView;

@ManagedBean
@ViewScoped
public class LoginMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();
	private UsuarioDAO usuarioDAO;
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "/login?faces-redirect=true";
	}
	
	public String efetuaLogin() {
		boolean existe = new UsuarioDAO().existe(this.usuario);
		FacesContext context = FacesContext.getCurrentInstance();
		if(existe) {	
			System.out.println("USUARIO " +usuario.getNome());
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "/inicio?faces-redirect=true";
		}
		context.getExternalContext().getFlash().setKeepMessages(true);
		MensagensView.erroMessage("Usuário e/ou senha não encontrado", null);
		
		return "/login?faces-redirect=true";	
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}		
	
}
