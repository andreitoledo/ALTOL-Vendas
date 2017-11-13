package com.andreitoledo.altol.vendas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.altol.vendas.model.cadastros.entidade.OutroCredor;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class OutroCredorDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public OutroCredor buscarPeloCodigo(Long codigo) {
		return manager.find(OutroCredor.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<OutroCredor> buscarTodos() {
		return manager.createQuery("select oc from OutroCredor oc").getResultList();
	}

	public void salvar(OutroCredor outroCredor) {
		manager.merge(outroCredor);
	}

	@Transactional
	public void excluir(OutroCredor outroCredor) throws NegocioException {
		outroCredor = buscarPeloCodigo(outroCredor.getCodigo());
		try {
			manager.remove(outroCredor);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Este outro credor não pode ser excluído.");

		}

	}

}
