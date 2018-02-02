package com.andreitoledo.altol.vendas.controller.cadastros.parametros;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.PessoaJuridicaDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.PessoaJuridica;
import com.andreitoledo.altol.vendas.model.cadastros.parametro.EmpresaUsuaria;
import com.andreitoledo.altol.vendas.service.CadastroEmpresaUsuariaService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroEmpresaUsuariaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private EmpresaUsuaria empresaUsuaria;

	@Inject
	private CadastroEmpresaUsuariaService cadastroEmpresaUsuariaService;	
	
	private List<PessoaJuridica> pessoasJuridicas;
	
	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (this.empresaUsuaria == null) {
			limpar();
		}
		
		this.pessoasJuridicas = pessoaJuridicaDAO.buscarTodos();
	}

	private void limpar() {
		this.empresaUsuaria = new EmpresaUsuaria();		
	}

	public void salvar() {
		try {
			cadastroEmpresaUsuariaService.salvar(empresaUsuaria);
			facesMessages.info("Empresa usuária salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public EmpresaUsuaria getEmpresaUsuaria() {
		return empresaUsuaria;
	}

	public void setEmpresaUsuaria(EmpresaUsuaria empresaUsuaria) {
		this.empresaUsuaria = empresaUsuaria;
	}	
	

	public List<PessoaJuridica> getPessoasJuridicas() {
		return pessoasJuridicas;
	}
	

	public boolean isEditando() {
		return this.empresaUsuaria.getCodigo() != null;
	}
	
	

}
