package br.cairu.pi.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import ba.cairu.pi.DAO.ClienteDAO;
import br.cairu.pi.entidade.Cliente;


@ManagedBean
@SessionScoped
public class ClienteMB {
	private ClienteDAO clienteDAO;
	private Cliente cliente;
	
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
		if(cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String salvar() {
		try {
			//if(cliente.getComplemento().equals("")) { cliente.setComplemento(null);}
			getClienteDAO().salvar(getCliente());
			cliente = new Cliente();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
