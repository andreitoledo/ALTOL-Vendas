package com.andreitoledo.altol.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.altol.vendas.dao.PessoaJuridicaDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.PessoaJuridica;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class CadastroPessoaJuridicaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;

	@Transactional
	public void salvar(PessoaJuridica pessoaJuridica) throws NegocioException {

		this.pessoaJuridicaDAO.salvar(pessoaJuridica);

	}

}
