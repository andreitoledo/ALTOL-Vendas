package com.andreitoledo.altol.vendas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.altol.vendas.model.cadastros.parametro.Departamento;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class DepartamentoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Departamento buscarPeloCodigo(Long codigo) {
		return manager.find(Departamento.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Departamento> buscarTodos() {
		return manager.createQuery("Select d from Departamento d").getResultList();
	}

	public void salvar(Departamento departamento){
		manager.merge(departamento);
		
	}

	@Transactional
	public void excluir(Departamento departamento) throws NegocioException {
		departamento = buscarPeloCodigo(departamento.getCodigo());

		try {
			manager.remove(departamento);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Este departamento não pode ser excluído.");

		}

	}

}
