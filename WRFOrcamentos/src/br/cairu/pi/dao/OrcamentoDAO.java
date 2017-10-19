package br.cairu.pi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ComponentSystemEvent;
import javax.persistence.NoResultException;

import br.cairu.pi.model.Orcamento;
import br.cairu.pi.model.Produto;
import br.cairu.pi.view.MensagensView;

public class OrcamentoDAO extends GenericDAO<Orcamento> {

	public OrcamentoDAO() {
		super(Orcamento.class);
	}

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
	}

	public int mostrarCodOrcamento() {
		Integer resultado = (Integer) getSessao().createQuery("select max(o.idOrcamento+1)  from Orcamento o")
				.getSingleResult();
		System.out.println("query" + resultado);
		return (int) resultado;
	}

}
