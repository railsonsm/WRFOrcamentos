package br.cairu.pi.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import br.cairu.pi.dao.ClienteDAO;
import br.cairu.pi.model.Cliente;
import br.cairu.pi.view.MensagensView;


@ManagedBean
@ViewScoped
public class ClienteMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ClienteDAO clienteDAO;
	private Cliente cliente;
	private Integer exibirId;
	private Integer idSelecao;
	private String nomeCliente;
	private List<Cliente> clientesFiltrados;
	private Integer contadorId;
	private MensagensView clienteview;

	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
		this.clienteview = new MensagensView();
	}
	
	public void clienteSelecionado(SelectEvent event) {
		Cliente cliente = (Cliente) event.getObject();
		setCliente(cliente);
	}
	
	public String editar() {
		try {
			getClienteDAO().editar(cliente);
			cliente = new Cliente();
			clienteview.msgEditCli();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String salvar() {
		try {
			getClienteDAO().salvar(cliente);
			cliente = new Cliente();
			clienteview.msgSalvaCli();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String excluir() {
		try {
			getClienteDAO().excluir(cliente.getIdCliente());
			cliente = new Cliente();
			clienteview.msgExcluiCli();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	public MensagensView getClienteview() {
		return clienteview;
	}

	public void setClienteview(MensagensView clienteview) {
		this.clienteview = clienteview;
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