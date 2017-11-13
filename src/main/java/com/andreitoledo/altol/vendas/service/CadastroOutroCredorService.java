package com.andreitoledo.altol.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.altol.vendas.dao.OutroCredorDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.OutroCredor;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class CadastroOutroCredorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	OutroCredorDAO outroCredorDAO;

	@Transactional
	public void salvar(OutroCredor outroCredor) throws NegocioException {
		if (outroCredor.getNome() == null || outroCredor.getNome().trim().equals("")) {
			throw new NegocioException("O nome do outro credor é obrigatório.");

		}

		this.outroCredorDAO.salvar(outroCredor);
	}

}
