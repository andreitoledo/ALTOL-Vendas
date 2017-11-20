package com.andreitoledo.altol.vendas.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.VendedorDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.Vendedor;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaVendedorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Vendedor> vendedores = new ArrayList<>();

	private Vendedor vendedorSelecionado;

	@Inject
	VendedorDAO vendedorDAO;

	@Inject
	private FacesMessages facesMessages;

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	@PostConstruct
	public void inicializar() {
		vendedores = vendedorDAO.buscarTodos();

	}

	public void excluir() {
		try {
			vendedorDAO.excluir(vendedorSelecionado);
			this.vendedores.remove(vendedorSelecionado);			
			facesMessages.info("Vendedor " 
					+ vendedorSelecionado.getNome() 
					+ " excluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Vendedor getVendedorSelecionado() {
		return vendedorSelecionado;
	}

	public void setVendedorSelecionado(Vendedor vendedorSelecionado) {
		this.vendedorSelecionado = vendedorSelecionado;
	}
	
	

}
