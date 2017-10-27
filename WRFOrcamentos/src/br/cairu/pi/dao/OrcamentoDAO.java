package br.cairu.pi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ComponentSystemEvent;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;

import br.cairu.pi.model.Cliente;
import br.cairu.pi.model.Fabricante;
import br.cairu.pi.model.Orcamento;
import br.cairu.pi.model.OrcamentoProduto;
import br.cairu.pi.model.Produto;
import br.cairu.pi.view.MensagensView;

public class OrcamentoDAO extends GenericDAO<Orcamento> {

	public OrcamentoDAO() {
		super(Orcamento.class);
	}
	
	/*
	public List<Produto> buscaProdutoFabric(String descricaoProduto, int idFabricante) {
		List<Produto> listaProdutos = new ArrayList<Produto>();
		try {
			listaProdutos = getSessao()
					.createQuery("from Produto where descricao like :descricao and idFabricante = :idFabricante",Produto.class)
					.setParameter("descricao", "%" + descricaoProduto + "%").setParameter("idFabricante", idFabricante)
					.getResultList();

		} catch (NullPointerException e) {
			MensagensView.erroMessage("Selecione o fabricante primeiro", null);
		}
		return listaProdutos;
	}*/
	

	@SuppressWarnings("unchecked")
	public List<Produto> buscaProdutoFabric(String descricao, Integer idFabricante) {  
		try {
			CriteriaBuilder cb = getSessao().getCriteriaBuilder();  
		    CriteriaQuery<Produto> c = cb.createQuery(Produto.class);  
		    Root<Produto> produto = c.from(Produto.class);  
		    Fetch<Produto, Fabricante> fabricante = produto.fetch("fabricante");
		    Predicate and = cb.and(cb.equal((Expression<?>) fabricante , idFabricante));
		    c.where(cb.like(produto.<String> get("descricao"), "%" + descricao.replaceAll(" ", "%") + "%"),and);		    
		    TypedQuery<Produto> q = getSessao().createQuery(c);   
		    return q.getResultList();  
		}finally {
			 getSessao().close();
		} 
	} 

	public int mostrarCodOrcamento() {
		Integer resultado = (Integer) getSessao().createQuery("select max(o.idOrcamento+1)  from Orcamento o")
				.getSingleResult();
		System.out.println("query" + resultado);
		getSessao().close();
		return (int) resultado;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<OrcamentoProduto> buscaItensOrcamentos(Integer id) {  
		try {	
			//Criteria crit = null;
			CriteriaBuilder cb = getSessao().getCriteriaBuilder(); 
		    CriteriaQuery<OrcamentoProduto> c = cb.createQuery(OrcamentoProduto.class);   
		   // crit.createAlias("OrcamentoProduto", "teste");
		    Root<OrcamentoProduto> orcamentoProduto = c.from(OrcamentoProduto.class);		    
		    Fetch<OrcamentoProduto, Produto> produto = orcamentoProduto.fetch("produto");
		    Fetch<OrcamentoProduto, Orcamento> orcamentos = orcamentoProduto.fetch("orcamento");
		    Fetch<Orcamento, Fabricante> fabricante = orcamentos.fetch("fabricante");
		    Fetch<Orcamento, Cliente> cliente = orcamentos.fetch("cliente");
		    //Join<OrcamentoProduto, Produto> produtos = orcamentoProduto.join("produto");
		    //Join<OrcamentoProduto, Orcamento> orcamentos = orcamentoProduto.join("orcamento"); 
		    //orcamentoProduto.fetch("produto");
		    //orcamentoProduto.fetch("orcamento");
		    c.where(cb.equal((Expression<Orcamento>) orcamentos, id));
		    TypedQuery<OrcamentoProduto> q = getSessao().createQuery(c);
		    return q.getResultList();  
		}finally {
			 getSessao().close();
		} 
	}  
	
	public List<Orcamento> buscaOrcamentos(Integer id) {  
	    CriteriaBuilder cb = getSessao().getCriteriaBuilder();  
	    CriteriaQuery<Orcamento> c = cb.createQuery(Orcamento.class);  
	    Root<Orcamento> orcamento = c.from(Orcamento.class);  
	    Join<Orcamento, Fabricante> fabricante = orcamento.join("fabricante");  
	    Join<Orcamento, Cliente> cliente = orcamento.join("cliente");  
	    c.where(cb.equal(orcamento, id));
	    TypedQuery<Orcamento> q = getSessao().createQuery(c);   
	    return q.getResultList();  
	}  

}
