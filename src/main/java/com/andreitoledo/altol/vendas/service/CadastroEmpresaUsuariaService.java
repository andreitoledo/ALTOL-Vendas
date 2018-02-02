package com.andreitoledo.altol.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.altol.vendas.dao.EmpresaUsuariaDAO;
import com.andreitoledo.altol.vendas.model.cadastros.parametro.EmpresaUsuaria;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;


public class CadastroEmpresaUsuariaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaUsuariaDAO empresaUsuariaDAO;

	@Transactional
	public void salvar(EmpresaUsuaria empresaUsuaria) throws NegocioException {

		/* regras de restrições */

		this.empresaUsuariaDAO.salvar(empresaUsuaria);

	}

}
