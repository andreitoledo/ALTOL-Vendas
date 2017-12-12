package com.andreitoledo.altol.vendas.controller.cadastros.parametros;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.model.cadastros.parametro.Departamento;
import com.andreitoledo.altol.vendas.service.CadastroDepartamentoService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroDepartamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Departamento departamento;

	@Inject
	private CadastroDepartamentoService cadastroDepartamentoService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (this.departamento == null) {
			limpar();
		}
	}

	public void limpar() {
		this.departamento = new Departamento();
	}

	public void salvar() {
		try {
			cadastroDepartamentoService.salvar(departamento);
			facesMessages.info("Departamento salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public boolean isEditando() {
		return this.departamento.getCodigo() != null;
	}

}
