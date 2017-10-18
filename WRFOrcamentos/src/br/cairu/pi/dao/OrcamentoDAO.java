package br.cairu.pi.dao;

import java.util.List;

import javax.faces.event.ComponentSystemEvent;

import br.cairu.pi.model.Orcamento;
import br.cairu.pi.model.Produto;

public class OrcamentoDAO extends GenericDAO<Orcamento> {

	public OrcamentoDAO() {
		super(Orcamento.class);
	}

	public List<Produto> porNomeSemelhante(String descricaoProduto, int idFabricante) {
		return getSessao().createQuery("from Produto where descricao like :descricao and idFabricante = :idFabricante", Produto.class)
				.setParameter("descricao", "%" + descricaoProduto + "%")
				.setParameter("idFabricante", idFabricante)
				.getResultList();
	}

	
	public int mostrarCodOrcamento() {
		Integer resultado = (Integer) getSessao().createQuery("select max(o.idOrcamento+1)  from Orcamento o").getSingleResult();
		System.out.println("query" + resultado);
		return (int) resultado;	
	}

}
