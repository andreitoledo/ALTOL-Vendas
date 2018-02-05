package com.andreitoledo.altol.vendas.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.andreitoledo.altol.vendas.dao.GenericDAO;

public class HibernateGenericDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	/* adiciono os metodos genericos aqui */

	@Inject
	private EntityManager manager;

	private Class<T> classeEntidade;

	@SuppressWarnings("unchecked")
	public HibernateGenericDAO() {
		this.classeEntidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public T buscarPeloCodigo(ID id) {
		return manager.find(classeEntidade, id);
	}

	@Override
	public void salvar(T entidade) {
		manager.merge(entidade);

	}

	@Override
	public void excluir(ID id) {
		T entidade = buscarPeloCodigo(id);
		manager.remove(entidade);

	}

	protected EntityManager getEntityManager() {
		return manager;
	}

}
