package br.cairu.pi.apresentacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.cairu.pi.DAO.ClienteDAO;
import br.cairu.pi.entidade.Cliente;
import br.cairu.pi.entidade.Fabricante;


@ManagedBean
@ViewScoped
public class ClienteMB {
	private ClienteDAO clienteDAO;
	private Cliente cliente;
	private Integer exibirId;
	private Integer idSelecao;
	private String nomeCliente;
	private List<Cliente> clientesFiltrados;
	private Integer contadorId;

	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
	}
	
	public String mostrarCliPorId() {
		cliente = getClienteDAO().buscarCliPorId(idSelecao);
		return null;
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
	
	public void destroyWorld() {
		addMessage("System Error", "Please try again later.");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public String editar() {
		try {
			getClienteDAO().editar(cliente);
			cliente = new Cliente();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String salvar() {
		try {
			getClienteDAO().salvar(cliente);
			cliente = new Cliente();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String excluir() {
		try {
			getClienteDAO().excluir(cliente.getIdCliente());
			cliente = new Cliente();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	public Integer getContadorId() {
		return contadorId;
	}

	public void setContadorId(Integer contadorId) {
		this.contadorId = contadorId;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}

	public void setClientesFiltrados(List<Cliente> clientesFiltrados) {
		this.clientesFiltrados = clientesFiltrados;
	}

	public ClienteDAO getClienteDAO() {
		if (clienteDAO == null) {
			clienteDAO = new ClienteDAO();
		}
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getExibirId() {
		return exibirId;
	}

	public void setExibirId(Integer exibirId) {
		this.exibirId = exibirId;
	}


	public Integer getIdSelecao() {
		return idSelecao;
	}

	public void setIdSelecao(Integer idSelecao) {
		this.idSelecao = idSelecao;
	}

}
