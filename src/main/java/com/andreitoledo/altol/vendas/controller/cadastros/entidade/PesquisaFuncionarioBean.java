package com.andreitoledo.altol.vendas.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.FuncionarioDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.Funcionario;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	FuncionarioDAO funcionarioDAO;

	private List<Funcionario> funcionarios = new ArrayList<>();

	private Funcionario funcionarioSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	@PostConstruct
	public void inicializar() {
		funcionarios = funcionarioDAO.buscarTodos();
	}

	public void excluir() {
		try {
			funcionarioDAO.excluir(funcionarioSelecionado);
			this.funcionarios.remove(funcionarioSelecionado);

		} catch (Exception e) {
			facesMessages.error(e.getMessage());

		}

	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

}
