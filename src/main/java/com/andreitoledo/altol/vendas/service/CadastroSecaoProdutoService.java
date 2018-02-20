package com.andreitoledo.altol.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.altol.vendas.dao.SecaoProdutoDAO;
import com.andreitoledo.altol.vendas.model.cadastros.produto.SecaoProduto;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class CadastroSecaoProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SecaoProdutoDAO secaoProdutoDAO;

	@Transactional
	public void salva(SecaoProduto secaoProduto) throws NegocioException {

		this.secaoProdutoDAO.salvar(secaoProduto);

	}

	@Transactional
	public void excluir(SecaoProduto secaoProduto) throws NegocioException {

		this.secaoProdutoDAO.excluir(secaoProduto);

	}

}
