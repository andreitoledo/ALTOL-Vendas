package com.andreitoledo.altol.vendas.controller.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.DepartamentoDAO;
import com.andreitoledo.altol.vendas.model.cadastros.Usuario;
import com.andreitoledo.altol.vendas.model.cadastros.parametro.Departamento;
import com.andreitoledo.altol.vendas.service.CadastroUsuarioService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	@Inject
	private CadastroUsuarioService cadastroUsuarioService;

	private List<Departamento> departamentos;

	@Inject
	private DepartamentoDAO departamentoDAO;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (this.usuario == null) {
			limpar();
		}

		this.departamentos = this.departamentoDAO.buscarTodos();

	}

	private void limpar() {
		this.usuario = new Usuario();

	}

	public void salvar() {
		try {
			this.cadastroUsuarioService.salvar(usuario);
			facesMessages.info("Usuário salvo com sucesso.");
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			facesMessages.error("Erro desconhecido. Contatar o administrador.");
		}

		limpar();

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public boolean isEditando() {
		return this.usuario.getCodigo() != null;
	}

}
