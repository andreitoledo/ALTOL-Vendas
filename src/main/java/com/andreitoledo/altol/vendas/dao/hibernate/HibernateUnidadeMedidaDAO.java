package com.andreitoledo.altol.vendas.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import com.andreitoledo.altol.vendas.dao.UnidadeMedidaDAO;
import com.andreitoledo.altol.vendas.model.cadastros.produto.UnidadeMedida;

public class HibernateUnidadeMedidaDAO extends HibernateGenericDAO<UnidadeMedida, Long>
		implements UnidadeMedidaDAO, Serializable {

	private static final long serialVersionUID = 1L;

	/* deixo buscas especificas, que não podem ser genéricas */

	@SuppressWarnings("unchecked")
	public List<UnidadeMedida> buscarTodos() {
		return getEntityManager().createQuery("Select um from UnidadeMedida um").getResultList();
	}

}
