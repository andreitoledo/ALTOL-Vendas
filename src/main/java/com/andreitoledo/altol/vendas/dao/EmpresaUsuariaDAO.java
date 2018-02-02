package com.andreitoledo.altol.vendas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.altol.vendas.model.cadastros.parametro.EmpresaUsuaria;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class EmpresaUsuariaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public EmpresaUsuaria buscarPeloCodigo(Long codigo) {
		return manager.find(EmpresaUsuaria.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<EmpresaUsuaria> buscarTodos() {
		return manager.createQuery("select eu from EmpresaUsuaria eu").getResultList();
	}

	public void salvar(EmpresaUsuaria empresaUsuaria) {
		manager.merge(empresaUsuaria);
	}

	@Transactional
	public void excluir(EmpresaUsuaria empresaUsuaria) throws NegocioException {

		empresaUsuaria = buscarPeloCodigo(empresaUsuaria.getCodigo());

		try {
			manager.remove(empresaUsuaria);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Esta empresa usuária não pode ser excluída.");

		}

	}

}
