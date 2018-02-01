package com.andreitoledo.altol.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.altol.vendas.dao.UsuarioDAO;
import com.andreitoledo.altol.vendas.model.cadastros.Usuario;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Transactional
	public void salvar(Usuario usuario) throws NegocioException {

		this.usuarioDAO.salvar(usuario);

	}

}
