package br.cairu.pi.dao;

import javax.faces.event.ComponentSystemEvent;

import br.cairu.pi.model.Orcamento;

public class OrcamentoDAO extends GenericDAO<Orcamento> {

	public OrcamentoDAO(Class<Orcamento> classe) {
		super(Orcamento.class);
	}

	public int mostrarCodOrcamento() {
		Integer resultado = (Integer) getSessao().createQuery("select max(o.idOrcamento+1)  from Orcamento o").getSingleResult();
		System.out.println("query" + resultado);
		return (int) resultado;	
	}

}
