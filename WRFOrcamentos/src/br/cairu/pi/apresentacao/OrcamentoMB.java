package br.cairu.pi.apresentacao;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.cairu.pi.DAO.ClienteDAO;
import br.cairu.pi.DAO.FabricanteDAO;
import br.cairu.pi.DAO.OrcamentoDAO;
import br.cairu.pi.entidade.Cliente;
import br.cairu.pi.entidade.Fabricante;
import br.cairu.pi.entidade.Orcamento;

@ManagedBean
@ViewScoped
public class OrcamentoMB {
	private Cliente cliente;
	private Fabricante fabricante;
	private Orcamento orcamento;
	private OrcamentoDAO orcamentoDAO;
	private ClienteDAO  clienteDAO;
	private FabricanteDAO fabricanteDAO;
	
	@PostConstruct
	public void init() {
		this.cliente = new  Cliente();
		this.fabricante = new Fabricante();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	public OrcamentoDAO getOrcamentoDAO() {
		return orcamentoDAO;
	}
	public void setOrcamentoDAO(OrcamentoDAO orcamentoDAO) {
		this.orcamentoDAO = orcamentoDAO;
	}
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	public FabricanteDAO getFabricanteDAO() {
		return fabricanteDAO;
	}
	public void setFabricanteDAO(FabricanteDAO fabricanteDAO) {
		this.fabricanteDAO = fabricanteDAO;
	}
}
