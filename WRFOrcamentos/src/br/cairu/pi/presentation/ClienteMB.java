package br.cairu.pi.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


import ba.cairu.pi.DAO.ClienteDAO;
import br.cairu.pi.entidade.Cliente;
import br.com.parallel.DAO.UsuarioDAO;
import br.com.parallel.entidade.Usuario;

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
			clienteDAO = new ClienteDAO();
			clienteDAO.salvar(cliente);
			cliente = new Cliente();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}