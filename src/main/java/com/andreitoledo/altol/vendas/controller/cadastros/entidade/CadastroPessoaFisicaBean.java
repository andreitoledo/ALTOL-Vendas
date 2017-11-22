package com.andreitoledo.altol.vendas.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.ClassifEntidadeDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.ClassifEntidade;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.PessoaFisica;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.TipoEstadoCivil;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.TipoLogradouro;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.TipoSexo;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.TipoTelefone;
import com.andreitoledo.altol.vendas.service.CadastroPessoaFisicaService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroPessoaFisicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PessoaFisica pessoaFisica;

	@Inject
	private CadastroPessoaFisicaService cadastroPessoaFisicaService;

	private List<TipoSexo> sexos;

	private List<ClassifEntidade> classifEntidades;

	@Inject
	private ClassifEntidadeDAO classifEntidadeDAO;

	@Inject
	private FacesMessages facesmessages;

	public void inicializar() {
		if (pessoaFisica == null) {
			limpar();
		}

		this.sexos = Arrays.asList(TipoSexo.values());
		this.classifEntidades = this.classifEntidadeDAO.buscarTodos();
	}

	public void limpar() {
		this.pessoaFisica = new PessoaFisica();
	}

	public void salvar() {
		try {
			this.cadastroPessoaFisicaService.salvar(pessoaFisica);
			facesmessages.info("Pessoa Fisica salvo com sucesso !");

		} catch (NegocioException e) {
			facesmessages.error(e.getMessage());

		}

		limpar();
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public List<ClassifEntidade> getClassifEntidades() {
		return classifEntidades;
	}

	public List<TipoSexo> getSexos() {
		return sexos;
	}

	public TipoEstadoCivil[] getTipoEstadoCivils() {
		return TipoEstadoCivil.values();
	}

	public TipoLogradouro[] getTipoLogradouros() {
		return TipoLogradouro.values();
	}

	public TipoTelefone[] getTipoTelefones() {
		return TipoTelefone.values();
	}

	public boolean isEditando() {
		return this.pessoaFisica.getCodigo() != null;
	}

}
