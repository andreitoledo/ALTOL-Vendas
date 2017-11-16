package com.andreitoledo.altol.vendas.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.model.cadastros.entidade.Funcionario;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.TipoLogradouro;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.TipoSexo;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.TipoTelefone;
import com.andreitoledo.altol.vendas.service.CadastroFuncionarioService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionario;

	@Inject
	private CadastroFuncionarioService cadastroFuncionarioService;

	private List<TipoSexo> sexos;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (funcionario == null) {
			limpar();

		}

		this.sexos = Arrays.asList(TipoSexo.values());
	}

	public void limpar() {
		this.funcionario = new Funcionario();
	}

	public void salvar() {
		try {
			this.cadastroFuncionarioService.salvar(funcionario);
			facesMessages.info("Funcionário salvo com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

		limpar();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<TipoSexo> getSexos() {
		return sexos;
	}

	/* enuns */
	public TipoLogradouro[] getTipoLogradouros() {
		return TipoLogradouro.values();
	}

	public TipoTelefone[] getTipoTelefones() {
		return TipoTelefone.values();

	}

	public boolean isEditando() {
		return this.funcionario.getCodigo() != null;
	}

}
