package com.andreitoledo.altol.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.altol.vendas.dao.FuncionarioDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.Funcionario;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class CadastroFuncionarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioDAO funcionarioDAO;

	@Transactional
	public void salvar(Funcionario funcionario) throws NegocioException {	

		this.funcionarioDAO.salvar(funcionario);

	}

}
