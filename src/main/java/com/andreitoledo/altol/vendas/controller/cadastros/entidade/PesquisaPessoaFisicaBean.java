package com.andreitoledo.altol.vendas.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.PessoaFisicaDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.PessoaFisica;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaPessoaFisicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	PessoaFisicaDAO pessoaFisicaDAO;

	private List<PessoaFisica> pessoasFisicas = new ArrayList<>();

	private PessoaFisica pessoaFisicaSelecionado;
	
	@Inject
	private FacesMessages facesMessages;

	public List<PessoaFisica> getPessoasFisicas() {
		return pessoasFisicas;
	}

	@PostConstruct
	public void inicializar() {
		pessoasFisicas = pessoaFisicaDAO.buscarTodos();
	}

	public void excluir() {
		try {
			pessoaFisicaDAO.excluir(pessoaFisicaSelecionado);
			this.pessoasFisicas.remove(pessoaFisicaSelecionado);
			facesMessages.info("Pessoa Fisica "
					+ pessoaFisicaSelecionado.getNome()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public PessoaFisica getPessoaFisicaSelecionado() {
		return pessoaFisicaSelecionado;
	}

	public void setPessoaFisicaSelecionado(PessoaFisica pessoaFisicaSelecionado) {
		this.pessoaFisicaSelecionado = pessoaFisicaSelecionado;
	}
}
