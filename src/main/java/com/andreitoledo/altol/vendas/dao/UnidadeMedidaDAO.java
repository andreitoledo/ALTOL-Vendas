package com.andreitoledo.altol.vendas.dao;

import java.util.List;

import com.andreitoledo.altol.vendas.model.cadastros.produto.UnidadeMedida;

public interface UnidadeMedidaDAO extends GenericDAO<UnidadeMedida, Long>{	
	
	/*interface para os metodos não genericos*/
	
	public List<UnidadeMedida> buscarTodos();
	
	
}
