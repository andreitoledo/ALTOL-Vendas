package com.andreitoledo.altol.vendas.controller.cadastros.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.model.cadastros.entidade.OutroCredor;
import com.andreitoledo.altol.vendas.service.CadastroOutroCredorService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroOutroCredorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private OutroCredor outroCredor;

	@Inject
	private CadastroOutroCredorService CadastroOutroCredorService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (outroCredor == null) {
			limpar();
		}
	}

	public void limpar() {
		this.outroCredor = new OutroCredor();

	}

	public void salvar() {
		try {
			this.CadastroOutroCredorService.salvar(outroCredor);
			facesMessages.info("Outro credor salvo com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

		limpar();
	}

	public OutroCredor getOutroCredor() {
		return outroCredor;
	}

	public void setOutroCredor(OutroCredor outroCredor) {
		this.outroCredor = outroCredor;
	}

	public boolean isEditando() {
		return this.outroCredor.getCodigo() != null;
	}

}
