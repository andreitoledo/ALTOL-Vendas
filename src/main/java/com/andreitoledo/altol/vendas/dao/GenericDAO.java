package com.andreitoledo.altol.vendas.dao;

import java.io.Serializable;

public interface GenericDAO<T, ID extends Serializable> {

	/* interface com os metodos genericos */

	public T buscarPeloCodigo(ID id);

	public void salvar(T entidade);

	public void excluir(ID id);

}
