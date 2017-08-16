package br.cairu.pi.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ba.cairu.pi.DAO.FabricanteDAO;
import br.cairu.pi.entidade.Fabricante;

@ManagedBean
@ViewScoped
public class FabricanteMB {
	private Fabricante fabricante;
	private FabricanteDAO fabricanteDAO;
	
	public Fabricante getFabricante() {
		if(fabricante == null) {
			fabricante = new Fabricante();
		}
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
	
	public String salvar() {
		try {
			getFabricanteDAO().salvar(getFabricante());
			fabricante = new Fabricante();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
