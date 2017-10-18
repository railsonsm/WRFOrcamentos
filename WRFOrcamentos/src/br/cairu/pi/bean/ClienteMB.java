package br.cairu.pi.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import br.cairu.pi.dao.ClienteDAO;
import br.cairu.pi.model.Cliente;
import br.cairu.pi.view.MensagensView;

@ManagedBean
@ViewScoped
public class ClienteMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente = new Cliente();
	private String nomeCliente;
	private List<Cliente> clientesFiltrados;
	
	public String editar() {
		try {
			new ClienteDAO().editar(this.cliente);
			this.cliente = new Cliente();
			MensagensView.SucessoMessage("Cliente alterado com sucesso!.", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String salvar() {
		try {
			new ClienteDAO().salvar(this.cliente);
			this.cliente = new Cliente();
			MensagensView.SucessoMessage("Cliente adicionado com sucesso!.", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String excluir() {
		try {
			new ClienteDAO().excluir(cliente);
			this.cliente = new Cliente();
			MensagensView.SucessoMessage("Cliente removido com sucesso!.", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		clientesFiltrados = new ClienteDAO().porNomeSemelhante(nomeCliente);
	}
	
	public void selecionarCliente(Cliente cliente) {
		RequestContext.getCurrentInstance().closeDialog(cliente);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public void setClientesFiltrados(List<Cliente> clientesFiltrados) {
		this.clientesFiltrados = clientesFiltrados;
	}
	
	

}
