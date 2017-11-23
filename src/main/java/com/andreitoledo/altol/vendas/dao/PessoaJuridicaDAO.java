package com.andreitoledo.altol.vendas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.altol.vendas.model.cadastros.entidade.PessoaJuridica;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class PessoaJuridicaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public PessoaJuridica buscarPeloCodigo(Long codigo) {
		return manager.find(PessoaJuridica.class, codigo);

	}

	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> buscarTodos() {
		return manager.createNamedQuery("PessoaJuridica.buscarTodos").getResultList();
	}

	public void salvar(PessoaJuridica pessoaJuridica) {
		manager.merge(pessoaJuridica);
	}

	@Transactional
	public void excluir(PessoaJuridica pessoaJuridica) throws NegocioException {
		pessoaJuridica = buscarPeloCodigo(pessoaJuridica.getCodigo());
		try {
			manager.remove(pessoaJuridica);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Esta pessoa juridica não pode ser excluído.");

		}

	}

	public List<PessoaJuridica> porNomeSemelhante(String nome) {

		return manager.createQuery("from PessoaJuridica where nome like :nome", PessoaJuridica.class)
				.setParameter("nome", "%" + nome + "%").getResultList();
	}

}
