package com.andreitoledo.altol.vendas.controller.cadastros.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.hibernate.HibernateUnidadeMedidaDAO;
import com.andreitoledo.altol.vendas.model.cadastros.produto.UnidadeMedida;
import com.andreitoledo.altol.vendas.service.CadastroUnidadeMedidaService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaUnidadeMedidaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<UnidadeMedida> unidadesMedidas = new ArrayList<>();

	public List<UnidadeMedida> getUnidadesMedidas() {
		return unidadesMedidas;
	}

	@Inject
	HibernateUnidadeMedidaDAO hibernateUnidadeMedidaDAO;

	@Inject
	CadastroUnidadeMedidaService cadastroUnidadeMedidaService;

	private UnidadeMedida unidadeMedidaSelecionado;

	@Inject
	private FacesMessages facesMessages;

	@PostConstruct
	public void inicializar() {
		this.unidadesMedidas = hibernateUnidadeMedidaDAO.buscarTodos();

	}
	
	public void excluir(Long id){
		try {
			this.cadastroUnidadeMedidaService.excluir(id);
			facesMessages.info("Unidade de medida excluído com sucesso.");
			
			
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}	
		
		inicializar();
		
	}			


	public UnidadeMedida getUnidadeMedidaSelecionado() {
		return unidadeMedidaSelecionado;
	}

	public void setUnidadeMedidaSelecionado(UnidadeMedida unidadeMedidaSelecionado) {
		this.unidadeMedidaSelecionado = unidadeMedidaSelecionado;
	}

}
