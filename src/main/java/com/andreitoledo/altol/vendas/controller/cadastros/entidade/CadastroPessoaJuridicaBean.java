package com.andreitoledo.altol.vendas.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.ClassifEntidadeDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.ClassifEntidade;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.PessoaJuridica;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.TipoLogradouro;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.TipoTelefone;
import com.andreitoledo.altol.vendas.service.CadastroPessoaJuridicaService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroPessoaJuridicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPessoaJuridicaService cadastroPessoaJuridicaService;

	private PessoaJuridica pessoaJuridica;

	private List<ClassifEntidade> classifEntidades;

	@Inject
	private ClassifEntidadeDAO classifEntidadeDAO;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (pessoaJuridica == null) {
			limpar();
		}

		this.classifEntidades = this.classifEntidadeDAO.buscarTodos();

	}

	public void limpar() {
		this.pessoaJuridica = new PessoaJuridica();
	}

	public void salvar() {
		try {
			this.cadastroPessoaJuridicaService.salvar(pessoaJuridica);
			facesMessages.info("Pessoa Juridica salvo com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

		limpar();
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public List<ClassifEntidade> getClassifEntidades() {
		return classifEntidades;
	}	

	public TipoLogradouro[] getTipoLogradouros() {
		return TipoLogradouro.values();
	}

	public TipoTelefone[] getTipoTelefones() {
		return TipoTelefone.values();
	}

	public boolean isEditando() {
		return this.pessoaJuridica.getCodigo() != null;
	}

}
