package br.cairu.pi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.cairu.pi.model.OrcamentoProduto;
import br.cairu.pi.util.JPAUtil;

public class OrcamentoProdutoDAO extends GenericDAO<OrcamentoProduto>{

	public OrcamentoProdutoDAO(Class<OrcamentoProduto> classe) {
		super(OrcamentoProduto.class);
	}

}
