package br.cairu.pi.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
	 * public List<Produto> buscaProdutoFabric(String descricaoProduto, int
	 * idFabricante) { List<Produto> listaProdutos = new ArrayList<Produto>(); try {
	 * listaProdutos = getSessao()
	 * .createQuery("from Produto where descricao like :descricao and idFabricante = :idFabricante"
	 * ,Produto.class) .setParameter("descricao", "%" + descricaoProduto +
	 * "%").setParameter("idFabricante", idFabricante) .getResultList();
	 * 
	 * } catch (NullPointerException e) {
	 * MensagensView.erroMessage("Selecione o fabricante primeiro", null); } return
	 * listaProdutos; }
	 */

	/*
	 //Trigger adiciona nome do cliente na tabela orcamento
	 delimiter %% 
      create trigger tg_nomecliente_orcamento after insert on
	  orcamentoproduto for each row begin declare nomeDoCliente varchar(40);
	  
	  select distinct(c.cli_nome) from cliente c join orcamento o join orcamentoproduto
	  op on o.idCliente = c.idCliente and op.idOrcamento = o.idOrcamento where
	  op.idOrcamento = new.idOrcamento into nomeDoCliente;
	  
	 update orcamento set orc_nomeCliente = nomeDoCliente where idOrcamento =
	 new.idOrcamento; end %%
	 */

	public List<Produto> buscaProdutoFabric(String descricao, Integer idFabricante) {
		try {
			CriteriaBuilder cb = getSessao().getCriteriaBuilder();
			CriteriaQuery<Produto> c = cb.createQuery(Produto.class);
			Root<Produto> produto = c.from(Produto.class);
			Fetch<Produto, Fabricante> fabricante = produto.fetch("fabricante");
			// Predicate and = cb.and(cb.equal((Expression<?>) fabricante, idFabricante));
			// c.where(cb.like(produto.<String>get("descricao"), "%" +
			// descricao.replaceAll(" ", "%") + "%"), and);
			c.where(cb.and((cb.equal((Expression<?>) fabricante, idFabricante)),
					(cb.like(produto.<String>get("descricao"), "%" + descricao.replaceAll(" ", "%") + "%"))));
			TypedQuery<Produto> q = getSessao().createQuery(c);
			return q.getResultList();
		} finally {
			getSessao().close();
		}
	}

	public int mostrarCodOrcamento() {
		Integer resultado = (Integer) getSessao().createQuery("select max(o.idOrcamento+1)  from Orcamento o")
				.getSingleResult();
		getSessao().close();
		return (int) resultado;

	}

	@SuppressWarnings({ "unchecked", "unused" })
	public List<OrcamentoProduto> buscaItensOrcamentos(Integer id) {
		try {
			// Criteria crit = null;
			CriteriaBuilder cb = getSessao().getCriteriaBuilder();
			CriteriaQuery<OrcamentoProduto> c = cb.createQuery(OrcamentoProduto.class);
			// crit.createAlias("OrcamentoProduto", "teste");
			Root<OrcamentoProduto> orcamentoProduto = c.from(OrcamentoProduto.class);
			Fetch<OrcamentoProduto, Produto> produto = orcamentoProduto.fetch("produto");
			Fetch<OrcamentoProduto, Orcamento> orcamentos = orcamentoProduto.fetch("orcamento");
			Fetch<Orcamento, Fabricante> fabricante = orcamentos.fetch("fabricante");
			Fetch<Orcamento, Cliente> cliente = orcamentos.fetch("cliente");
			// Join<OrcamentoProduto, Produto> produtos = orcamentoProduto.join("produto");
			// Join<OrcamentoProduto, Orcamento> orcamentos =
			// orcamentoProduto.join("orcamento");
			// orcamentoProduto.fetch("produto");
			// orcamentoProduto.fetch("orcamento");
			c.where(cb.equal((Expression<Orcamento>) orcamentos, id));
			TypedQuery<OrcamentoProduto> q = getSessao().createQuery(c);
			return q.getResultList();
		} catch (NullPointerException e) {
			 MensagensView.erroMessage("Selecione o fabricante primeiro", null);
			 return null;
		}finally {
			getSessao().close();
		}
	}

	@SuppressWarnings("unused")
	public List<Orcamento> buscaOrcamentosPorData(Date dataInicio, Date dataFim, String nomeCliente) {
		CriteriaBuilder cb = getSessao().getCriteriaBuilder();
		CriteriaQuery<Orcamento> c = cb.createQuery(Orcamento.class);
		Root<Orcamento> orcamento = c.from(Orcamento.class);
		Fetch<Orcamento, Fabricante> fabricante = orcamento.fetch("fabricante");
		Fetch<Orcamento, Cliente> cliente = orcamento.fetch("cliente");
		// ParameterExpression<Date> d = cb.parameter(Date.class);
		// Predicate or = cb
		// .or(cb.like(orcamento.<String>get("nomeCliente"), "%" +
		// nomeCliente.replaceAll(" ", "%") + "%"));
		if(nomeCliente == null || nomeCliente == "") {
			c.where(cb.and(cb.like(orcamento.<String>get("nomeCliente"), "%" + nomeCliente.replaceAll(" ", "%") + "%"),
					(cb.between(orcamento.<Date>get("dataorcamento"), dataInicio, dataFim))));
		}else {
			c.where(cb.or(cb.like(orcamento.<String>get("nomeCliente"), "%" + nomeCliente.replaceAll(" ", "%") + "%"),
					(cb.between(orcamento.<Date>get("dataorcamento"), dataInicio, dataFim))));
		}		
		TypedQuery<Orcamento> q = getSessao().createQuery(c);
		return q.getResultList();
	}
}
