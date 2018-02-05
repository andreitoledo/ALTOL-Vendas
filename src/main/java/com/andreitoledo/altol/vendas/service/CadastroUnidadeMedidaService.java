package com.andreitoledo.altol.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.altol.vendas.dao.UnidadeMedidaDAO;
import com.andreitoledo.altol.vendas.model.cadastros.produto.UnidadeMedida;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class CadastroUnidadeMedidaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UnidadeMedidaDAO unidadeMedidaDAO;

	@Transactional
	public void salvar(UnidadeMedida unidadeMedida) throws NegocioException {
		this.unidadeMedidaDAO.salvar(unidadeMedida);
	}
	
	@Transactional
	public void excluir(Long id) throws NegocioException {
		this.unidadeMedidaDAO.excluir(id);
	}	

}
