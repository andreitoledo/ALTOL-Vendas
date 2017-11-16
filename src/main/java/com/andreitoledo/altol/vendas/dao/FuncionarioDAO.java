package com.andreitoledo.altol.vendas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.altol.vendas.model.cadastros.entidade.Funcionario;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class FuncionarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Funcionario buscarPelocodigo(Long codigo) {
		return manager.find(Funcionario.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarTodos() {
		return manager.createQuery("Select f from Funcionario f").getResultList();
	}
	
	public void salvar(Funcionario funcionario){
		manager.merge(funcionario);
	}
	

	@Transactional
	public void excluir(Funcionario funcionario) throws NegocioException {
		funcionario = buscarPelocodigo(funcionario.getCodigo());
		try {
			manager.remove(funcionario);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Funcionário não pode ser excluído.");

		}
	}

}
