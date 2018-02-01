package com.andreitoledo.altol.vendas.controller.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.UsuarioDAO;
import com.andreitoledo.altol.vendas.model.cadastros.Usuario;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// criei a lista para carregar os usuarios na pesquisa
	private List<Usuario> usuarios = new ArrayList<>();

	// permiti acesso a lista
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	// criei a instancia para selecionar o usuario da lita e editar/excluir
	private Usuario usuarioSelecionado;

	// injetei a classe dao
	@Inject
	UsuarioDAO usuarioDAO;

	// injetei a classe mensagem
	@Inject
	private FacesMessages facesMessages;

	// carregar a lista
	@PostConstruct
	public void inicializar() {
		usuarios = usuarioDAO.buscarTodos();
	}

	public void excluir() {
		try {
			usuarioDAO.excluir(usuarioSelecionado); // excluindo do banco
			this.usuarios.remove(usuarioSelecionado); // excluindo da lista na // tela
			
			facesMessages.info("Usuário " + usuarioSelecionado.getNome() + " excluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

}
