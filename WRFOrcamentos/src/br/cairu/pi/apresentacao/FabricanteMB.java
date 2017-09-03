package br.cairu.pi.apresentacao;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.cairu.pi.DAO.FabricanteDAO;
import br.cairu.pi.DAO.SequenciaFabricanteDAO;
import br.cairu.pi.entidade.Fabricante;
import br.cairu.pi.entidade.SequenciaFabricante;

@ManagedBean
@ViewScoped
public class FabricanteMB {
	private Fabricante fabricante;
	private FabricanteDAO fabricanteDAO;
	private SequenciaFabricante sequenciaFabricante;
	private SequenciaFabricanteDAO sequenciaFabricanteDAO;
	
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
		mostraSequencia();
	}
	
	public String mostraSequencia() {
		sequenciaFabricante = new SequenciaFabricante();
		sequenciaFabricante = getSequenciaFabricanteDAO().buscaSequencia();
		return null;
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

	public SequenciaFabricante getSequenciaFabricante() {
		return sequenciaFabricante;
	}

	public void setSequenciaFabricante(SequenciaFabricante sequenciaFabricante) {
		this.sequenciaFabricante = sequenciaFabricante;
	}

	public SequenciaFabricanteDAO getSequenciaFabricanteDAO() {
		if(sequenciaFabricanteDAO == null) {
			sequenciaFabricanteDAO = new SequenciaFabricanteDAO();
		}
		return sequenciaFabricanteDAO;
	}

	public void setSequenciaFabricanteDAO(SequenciaFabricanteDAO sequenciaFabricanteDAO) {
		this.sequenciaFabricanteDAO = sequenciaFabricanteDAO;
	}
	
	
	
}
