package br.cairu.pi.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.exception.ConstraintViolationException;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import br.cairu.pi.dao.FabricanteDAO;
import br.cairu.pi.model.Fabricante;
import br.cairu.pi.view.MensagensView;

@ManagedBean
@ViewScoped
public class FabricanteMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Fabricante fabricante = new Fabricante();
	private String nomeFabricante;
	private List<Fabricante> fabricantesFiltrados;;

	public String salvar() {
		try {
			MensagensView.SucessoMessage("Fabricante adicionado com sucesso!.", null);
			new FabricanteDAO().salvar(this.fabricante);
			this.fabricante = new Fabricante();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String editar() {
		try {
			MensagensView.SucessoMessage("Fabricante alterado com sucesso!.", null);
			new FabricanteDAO().editar(this.fabricante);
			this.fabricante = new Fabricante();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String excluir() {
		try {
			MensagensView.SucessoMessage("Fabricante removido com sucesso!.", null);
			new FabricanteDAO().excluir(fabricante);
			fabricante = new Fabricante();
		} catch (javax.persistence.RollbackException e) {
			MensagensView.erroMessage("O fabricante não pôde ser excluido! Existe um produto registrado com o mesmo.", null);
		} catch (ConstraintViolationException e) {
			MensagensView.erroMessage("O fabricante não pôde ser excluido! Existe um produto registrado com o mesmo.", null);
		}
		return fabricante.getNome();
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<String, Object>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 420);
		RequestContext.getCurrentInstance().openDialog("selecaoFabricante", opcoes, null);
	}

	
	
	
	
	
	
	
	
	public void pesquisarFabricante() {
		fabricantesFiltrados = new FabricanteDAO().porNomeSemelhante(this.nomeFabricante);
	}

	public void selecionarFabricante(Fabricante fabricante) {
		RequestContext.getCurrentInstance().closeDialog(fabricante);
	}

	public void fabricanteSelecionado(SelectEvent event) {
		Fabricante fabricante = (Fabricante) event.getObject();
		setFabricante(fabricante);
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

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
}
