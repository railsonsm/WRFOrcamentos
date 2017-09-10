package br.cairu.pi.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Teste {
	private boolean campos;

	public boolean isCampos() {
		return campos;
	}

	
	
	public void setCampos(boolean campos) {
		this.campos = campos;
	}
	public boolean getCampos() {
		return campos;
	}


	public boolean testeCampos(boolean teste) {
		setCampos(false);
		teste = getCampos();
		System.out.println("RAILSON" + campos);
		return teste;
	
		
	}
}
