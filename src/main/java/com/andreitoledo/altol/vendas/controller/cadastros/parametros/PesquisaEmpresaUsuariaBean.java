package com.andreitoledo.altol.vendas.controller.cadastros.parametros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.EmpresaUsuariaDAO;
import com.andreitoledo.altol.vendas.model.cadastros.parametro.EmpresaUsuaria;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaEmpresaUsuariaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<EmpresaUsuaria> empresasUsuarias = new ArrayList<>();

	public List<EmpresaUsuaria> getEmpresasUsuarias() {
		return empresasUsuarias;
	}

	@Inject
	EmpresaUsuariaDAO empresaUsuariaDAO;

	private EmpresaUsuaria empresaUsuariaSelecionado;

	@Inject
	private FacesMessages facesMessages;

	@PostConstruct
	public void inicializar() {
		empresasUsuarias = empresaUsuariaDAO.buscarTodos();

	}

	public void excluir() {
		try {
			empresaUsuariaDAO.excluir(empresaUsuariaSelecionado);
			this.empresasUsuarias.remove(empresaUsuariaSelecionado);
			facesMessages.info("Empresa usuária " 
			+ empresaUsuariaSelecionado.getNome() 
			+ " - " 
			+ empresaUsuariaSelecionado.getFilial() 
			+ " excluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public EmpresaUsuaria getEmpresaUsuariaSelecionado() {
		return empresaUsuariaSelecionado;
	}

	public void setEmpresaUsuariaSelecionado(EmpresaUsuaria empresaUsuariaSelecionado) {
		this.empresaUsuariaSelecionado = empresaUsuariaSelecionado;
	}

}
