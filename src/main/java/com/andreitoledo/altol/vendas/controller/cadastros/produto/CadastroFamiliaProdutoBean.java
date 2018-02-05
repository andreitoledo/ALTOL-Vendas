package com.andreitoledo.altol.vendas.controller.cadastros.produto;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.model.cadastros.produto.FamiliaProduto;
import com.andreitoledo.altol.vendas.service.CadastroFamiliaProdutoService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroFamiliaProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private FamiliaProduto familiaProduto;

	@Inject
	private CadastroFamiliaProdutoService cadastroFamiliaProdutoService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (familiaProduto == null) {
			limpar();

		}
	}

	private void limpar() {
		this.familiaProduto = new FamiliaProduto();

	}

	public void salvar() {
		try {
			this.cadastroFamiliaProdutoService.salvar(familiaProduto);
			facesMessages.info("Familia Produto salvo com sucesso.");
			
			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public FamiliaProduto getFamiliaProduto() {
		return familiaProduto;
	}

	public void setFamiliaProduto(FamiliaProduto familiaProduto) {
		this.familiaProduto = familiaProduto;
	}

	public boolean isEditando() {
		return this.familiaProduto.getCodigo() != null;
	}

}
