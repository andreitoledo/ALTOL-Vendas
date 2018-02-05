package com.andreitoledo.altol.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.altol.vendas.dao.FamiliaProdutoDAO;
import com.andreitoledo.altol.vendas.model.cadastros.produto.FamiliaProduto;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class CadastroFamiliaProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FamiliaProdutoDAO familiaProdutoDAO;

	@Transactional
	public void salvar(FamiliaProduto familiaProduto) throws NegocioException {

		this.familiaProdutoDAO.salvar(familiaProduto);

	}

	@Transactional
	public void excluir(FamiliaProduto familiaProduto) throws NegocioException {

		this.familiaProdutoDAO.excluir(familiaProduto);

	}

}
