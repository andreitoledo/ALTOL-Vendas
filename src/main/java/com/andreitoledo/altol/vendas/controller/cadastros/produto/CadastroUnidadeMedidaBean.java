package com.andreitoledo.altol.vendas.controller.cadastros.produto;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.model.cadastros.produto.UnidadeMedida;
import com.andreitoledo.altol.vendas.service.CadastroUnidadeMedidaService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroUnidadeMedidaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private UnidadeMedida unidadeMedida;

	@Inject
	private CadastroUnidadeMedidaService cadastroUnidadeMedidaService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (this.unidadeMedida == null) {
			limpar();

		}
	}

	private void limpar() {
		this.unidadeMedida = new UnidadeMedida();

	}

	public void salvar() {
		try {
			cadastroUnidadeMedidaService.salvar(unidadeMedida);
			facesMessages.info("Unidade de medida salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public boolean isEditando() {
		return this.unidadeMedida.getCodigo() != null;
	}

}
