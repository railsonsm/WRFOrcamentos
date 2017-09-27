package br.cairu.pi.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PadraoView {
	public String voltarInicio() {
		return "/inicio.xhtml";
	}
}
