package com.andreitoledo.altol.vendas.controller.cadastros.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.SecaoProdutoDAO;
import com.andreitoledo.altol.vendas.model.cadastros.produto.SecaoProduto;
import com.andreitoledo.altol.vendas.service.CadastroSecaoProdutoService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaSecaoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<SecaoProduto> secaoProdutos = new ArrayList<>();

	public List<SecaoProduto> getSecaoProdutos() {
		return secaoProdutos;
	}

	@Inject
	SecaoProdutoDAO secaoProdutoDAO;

	@Inject
	private CadastroSecaoProdutoService cadastroSecaoProdutoService;

	private SecaoProduto secaoProdutoSelecionado;

	@Inject
	private FacesMessages facesMessages;

	@PostConstruct
	public void inicializar() {
		this.secaoProdutos = secaoProdutoDAO.buscarTodos();

	}

	public void excluir() {
		try {
			cadastroSecaoProdutoService.excluir(secaoProdutoSelecionado);
			this.secaoProdutos.remove(secaoProdutoSelecionado);
			facesMessages.info("Seção Produto " + secaoProdutoSelecionado.getDescricao() + " excluído com sucesso");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public SecaoProduto getSecaoProdutoSelecionado() {
		return secaoProdutoSelecionado;
	}

	public void setSecaoProdutoSelecionado(SecaoProduto secaoProdutoSelecionado) {
		this.secaoProdutoSelecionado = secaoProdutoSelecionado;
	}

}
