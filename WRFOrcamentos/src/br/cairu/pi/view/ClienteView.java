package br.cairu.pi.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.cairu.pi.dao.ClienteDAO;
import br.cairu.pi.model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteView {
	private Cliente cliente;
	private List<Cliente> clientesFiltrados;
	private ClienteDAO clienteDAO;
	private String nomeCliente;
	
	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
	}
	
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<String, Object>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 420);
		RequestContext.getCurrentInstance().openDialog("selecaoCliente", opcoes, null);
	}
	
	public void clienteSelecionado(SelectEvent event) {
		Cliente cliente = (Cliente) event.getObject();
		setCliente(cliente);
	}
	
	public void pesquisarCliente() {
		clientesFiltrados = getClienteDAO().porNomeSemelhante(nomeCliente);
	}
	
	public void selecionarCliente(Cliente cliente) {
		RequestContext.getCurrentInstance().closeDialog(cliente);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}

	public void setClientesFiltrados(List<Cliente> clientesFiltrados) {
		this.clientesFiltrados = clientesFiltrados;
	}

	public ClienteDAO getClienteDAO() {
		if(clienteDAO == null) {
			clienteDAO = new ClienteDAO();
		}
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
}
