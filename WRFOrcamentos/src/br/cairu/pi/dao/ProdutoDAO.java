package br.cairu.pi.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.cairu.pi.model.Produto;
import br.cairu.pi.util.JPAUtil;

public class ProdutoDAO extends GenericDAO<Produto>{
	public ProdutoDAO(Class<Produto> classe) {
		super(Produto.class);
		// TODO Auto-generated constructor stub
	}

	public Produto mostraProdutoPorId(Integer idProduto) {
        return getSessao().createQuery("select p from Produto p  where p.idProduto = :idProduto", Produto.class).
        setParameter("idProduto", idProduto).getSingleResult();

	}
	
	public List<Produto> porNomeSemelhante(String descricaoProduto) {
		return getSessao().createQuery("from Produto where descricao like :descricao", Produto.class)
				.setParameter("descricao", "%" + descricaoProduto + "%")
				.getResultList();
	}

	
}
