package br.cairu.pi.apresentacao;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.cairu.pi.DAO.FabricanteDAO;
import br.cairu.pi.entidade.Fabricante;

@ManagedBean
@ViewScoped
public class FabricanteMB {
	private Fabricante fabricante;
	private FabricanteDAO fabricanteDAO;
	
	public String salvar() {
		try {
			getFabricanteDAO().salvar(fabricante);
			fabricante = new Fabricante();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostConstruct
	public void init() {
		this.fabricante = new Fabricante();
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
	
	
}
