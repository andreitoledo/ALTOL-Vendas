package com.andreitoledo.altol.vendas.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.FuncionarioDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.Funcionario;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.Vendedor;
import com.andreitoledo.altol.vendas.service.CadastroVendedorService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroVendedorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Vendedor vendedor;

	@Inject
	private CadastroVendedorService cadastroVendedorService;

	private List<Funcionario> funcionarios;

	@Inject
	private FuncionarioDAO FuncionarioDAO;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (vendedor == null) {
			limpar();

		}

		this.funcionarios = this.FuncionarioDAO.buscarTodos();
	}

	public void limpar() {
		this.vendedor = new Vendedor();
	}

	public void salvar() {
		try {
			this.cadastroVendedorService.salvar(vendedor);
			facesMessages.info("Vendedor salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public boolean isEditando() {
		return this.vendedor.getCodigo() != null;
	}

}
