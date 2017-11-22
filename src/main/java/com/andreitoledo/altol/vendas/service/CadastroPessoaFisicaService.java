package com.andreitoledo.altol.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.altol.vendas.dao.PessoaFisicaDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.PessoaFisica;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class CadastroPessoaFisicaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaFisicaDAO pessoaFisicaDAO;

	@Transactional
	public void salvar(PessoaFisica pessoaFisica) throws NegocioException {

		if (pessoaFisica.getNomeFantasia() == null || pessoaFisica.getNomeFantasia().trim().equals("")) {
			throw new NegocioException("O nome fantasia é obrigatório.");

		}

		this.pessoaFisicaDAO.salvar(pessoaFisica);

	}

}