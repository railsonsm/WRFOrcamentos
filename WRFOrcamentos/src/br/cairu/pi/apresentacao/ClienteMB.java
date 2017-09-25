package br.cairu.pi.apresentacao;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.cairu.pi.DAO.ClienteDAO;
import br.cairu.pi.entidade.Cliente;


@ManagedBean
@ViewScoped
public class ClienteMB {
	private ClienteDAO clienteDAO;
	private Cliente cliente;

	private Integer exibirId;
	private Integer idSelecao;

	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
	}
	
	public String mostrarCliPorId() {
		cliente = getClienteDAO().buscarCliPorId(idSelecao);
		return null;
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
		return "cadastrarCliente.xhtml";
	}
	
	public String excluir() {
		try {
			getClienteDAO().excluir(idSelecao);
			cliente = new Cliente();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
