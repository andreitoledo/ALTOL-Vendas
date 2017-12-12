package com.andreitoledo.altol.vendas.controller.cadastros.parametros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.DepartamentoDAO;
import com.andreitoledo.altol.vendas.model.cadastros.parametro.Departamento;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaDepartamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Departamento> departamentos = new ArrayList<>();

	@Inject
	DepartamentoDAO departamentoDAO;

	private Departamento departamentoSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	@PostConstruct
	public void inicializar() {
		departamentos = departamentoDAO.buscarTodos();
	}

	public void excluir() {
		try {
			departamentoDAO.excluir(departamentoSelecionado);
			this.departamentos.remove(departamentoSelecionado);
			
			facesMessages.info("Departamento " 
			+ departamentoSelecionado.getNome() 
			+ " excluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Departamento getDepartamentoSelecionado() {
		return departamentoSelecionado;
	}

	public void setDepartamentoSelecionado(Departamento departamentoSelecionado) {
		this.departamentoSelecionado = departamentoSelecionado;
	}
	
	

}
