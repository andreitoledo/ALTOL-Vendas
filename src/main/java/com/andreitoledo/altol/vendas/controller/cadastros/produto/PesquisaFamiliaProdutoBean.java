package com.andreitoledo.altol.vendas.controller.cadastros.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.FamiliaProdutoDAO;
import com.andreitoledo.altol.vendas.model.cadastros.produto.FamiliaProduto;
import com.andreitoledo.altol.vendas.service.CadastroFamiliaProdutoService;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaFamiliaProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<FamiliaProduto> familiaProdutos = new ArrayList<>();
	
	public List<FamiliaProduto> getFamiliaProdutos() {
		return familiaProdutos;
	}
	
	@Inject
	FamiliaProdutoDAO familiaProdutoDAO;
	
	private FamiliaProduto familiaProdutoSelecionado;
	
	@Inject
	CadastroFamiliaProdutoService cadastroFamiliaProdutoService;
	
	@Inject
	private FacesMessages facesMessages;
	
	@PostConstruct
	public void inicializar(){
		this.familiaProdutos = familiaProdutoDAO.buscarTodos();		
	}	
	
	public void excluir(){
		try {			
			cadastroFamiliaProdutoService.excluir(familiaProdutoSelecionado);
			this.familiaProdutos.remove(familiaProdutoSelecionado);
			
			facesMessages.info("Familia produto " 
			+ familiaProdutoSelecionado.getDescricao() 
			+ " excluído com sucesso." );
			
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public FamiliaProduto getFamiliaProdutoSelecionado() {
		return familiaProdutoSelecionado;
	}

	public void setFamiliaProdutoSelecionado(FamiliaProduto familiaProdutoSelecionado) {
		this.familiaProdutoSelecionado = familiaProdutoSelecionado;
	}

	
	
}
