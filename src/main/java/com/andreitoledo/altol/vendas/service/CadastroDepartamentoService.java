package com.andreitoledo.altol.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.altol.vendas.dao.DepartamentoDAO;
import com.andreitoledo.altol.vendas.model.cadastros.parametro.Departamento;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class CadastroDepartamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DepartamentoDAO departamentoDAO;

	@Transactional
	public void salvar(Departamento departamento) throws NegocioException {

		this.departamentoDAO.salvar(departamento);

	}

}
