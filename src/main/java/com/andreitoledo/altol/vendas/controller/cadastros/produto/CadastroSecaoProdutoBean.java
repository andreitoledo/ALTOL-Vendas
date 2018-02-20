package com.andreitoledo.altol.vendas.controller.cadastros.produto;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.model.cadastros.produto.SecaoProduto;
import com.andreitoledo.altol.vendas.service.CadastroSecaoProdutoService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroSecaoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private SecaoProduto secaoProduto;

	@Inject
	private CadastroSecaoProdutoService cadastroSecaoProdutoService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (this.secaoProduto == null) {

			limpar();

		}
	}

	private void limpar() {
		this.secaoProduto = new SecaoProduto();

	}

	public void salvar() {
		try {
			cadastroSecaoProdutoService.salva(secaoProduto);
			facesMessages.info("Seção produto salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public SecaoProduto getSecaoProduto() {
		return secaoProduto;
	}

	public void setSecaoProduto(SecaoProduto secaoProduto) {
		this.secaoProduto = secaoProduto;
	}

	public boolean isEditando() {
		return this.secaoProduto.getCodigo() != null;
	}

}
