package com.andreitoledo.altol.vendas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.altol.vendas.model.cadastros.produto.FamiliaProduto;
import com.andreitoledo.altol.vendas.service.NegocioException;

public class FamiliaProdutoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public FamiliaProduto buscarPeloCodigo(Long codigo) {
		return manager.find(FamiliaProduto.class, codigo);

	}

	@SuppressWarnings("unchecked")
	public List<FamiliaProduto> buscarTodos() {
		return manager.createQuery("select fm from FamiliaProduto fm").getResultList();
	}

	public void salvar(FamiliaProduto familiaProduto) {
		manager.merge(familiaProduto);

	}

	public void excluir(FamiliaProduto familiaProduto) throws NegocioException {
		familiaProduto = buscarPeloCodigo(familiaProduto.getCodigo());

		try {
			manager.remove(familiaProduto);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Família de produto não pode ser excluído.");

		}
	}

}
