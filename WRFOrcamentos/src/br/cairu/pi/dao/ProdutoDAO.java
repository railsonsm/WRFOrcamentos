package br.cairu.pi.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Root;

import br.cairu.pi.model.Fabricante;
import br.cairu.pi.model.Orcamento;
import br.cairu.pi.model.OrcamentoProduto;
import br.cairu.pi.model.Produto;
import br.cairu.pi.util.JPAUtil;

public class ProdutoDAO extends GenericDAO<Produto>{
	public ProdutoDAO() {
		super(Produto.class);
	}

	public Produto mostraProdutoPorId(Integer idProduto) {
        return getSessao().createQuery("select p from Produto p  where p.idProduto = :idProduto", Produto.class).
        setParameter("idProduto", idProduto).getSingleResult();

	}
	/*
	public List<Produto> porNomeSemelhante(String descricaoProduto) {
		return getSessao().createQuery("from Produto where descricao like :descricao", Produto.class)
				.setParameter("descricao", "%" + descricaoProduto + "%")
				.getResultList();
	
	}*/
	
	public List<Produto> porNomeSemelhante(String descricao) {  
		try {
			CriteriaBuilder cb = getSessao().getCriteriaBuilder();  
		    CriteriaQuery<Produto> c = cb.createQuery(Produto.class);  
		    Root<Produto> produto = c.from(Produto.class);  
		    Fetch<Produto, Fabricante> fabricante = produto.fetch("fabricante");
		    c.where(cb.like(produto.<String> get("descricao"), "%" + descricao.replaceAll(" ", "%") + "%"));
		    TypedQuery<Produto> q = getSessao().createQuery(c);   
		    return q.getResultList();  
		}finally {
			 getSessao().close();
		} 
	} 

	
}
