package br.cairu.pi.apresentacao;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.cairu.pi.DAO.ClienteDAO;
import br.cairu.pi.DAO.SequenciaClienteDAO;
import br.cairu.pi.entidade.Cliente;
import br.cairu.pi.entidade.SequenciaCliente;


@ManagedBean
@ViewScoped
public class ClienteMB {
	private ClienteDAO clienteDAO;
	private Cliente cliente;
	private SequenciaCliente sequenciaCliente;
	private SequenciaClienteDAO sequenciaClienteDAO;
	private Integer exibirId;
	
	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
		mostraSequencia();
	}
	
	 public void destroyWorld() {
	        addMessage("System Error", "Please try again later.");
	    }
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
	public String salvar() {
		try {
			getClienteDAO().salvar(cliente);
			cliente = new Cliente();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "cadastrarCliente.xhtml";
	}
	
	public String mostraSequencia() {
		sequenciaCliente = new SequenciaCliente();
		sequenciaCliente = getSequenciaClienteDAO().buscaSequencia();
		return null;
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
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public SequenciaCliente getSequenciaCliente() {
		return sequenciaCliente;
	}
	
	public void setSequenciaCliente(SequenciaCliente sequenciaCliente) {
		this.sequenciaCliente = sequenciaCliente;
	}

	public SequenciaClienteDAO getSequenciaClienteDAO() {
		if(sequenciaClienteDAO == null) {
			sequenciaClienteDAO = new SequenciaClienteDAO();
		}
		return sequenciaClienteDAO;
	}

	public void setSequenciaClienteDAO(SequenciaClienteDAO sequenciaClienteDAO) {
		this.sequenciaClienteDAO = sequenciaClienteDAO;
	}

	public Integer getExibirId() {
		return exibirId;
	}

	public void setExibirId(Integer exibirId) {
		this.exibirId = exibirId;
	}
	
	
}
