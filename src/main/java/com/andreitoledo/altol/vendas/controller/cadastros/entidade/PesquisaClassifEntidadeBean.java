package com.andreitoledo.altol.vendas.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.altol.vendas.dao.ClassifEntidadeDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.ClassifEntidade;
import com.andreitoledo.altol.vendas.service.NegocioException;
import com.andreitoledo.altol.vendas.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaClassifEntidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ClassifEntidadeDAO classifEntidadeDAO;

	private List<ClassifEntidade> classifEntidades = new ArrayList<>();

	private ClassifEntidade classifEntidadeSelecionado;
	
	@Inject
	private FacesMessages facesMessages;

	public List<ClassifEntidade> getClassifEntidades() {
		return classifEntidades;
	}

	@PostConstruct
	public void inicializar() {
		classifEntidades = classifEntidadeDAO.buscarTodos();
	}

	public void excluir() {
		try {
			classifEntidadeDAO.excluir(classifEntidadeSelecionado);
			this.classifEntidades.remove(classifEntidadeSelecionado);
			facesMessages.info("Classificação "
					+ classifEntidadeSelecionado.getNome()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public ClassifEntidade getClassifEntidadeSelecionado() {
		return classifEntidadeSelecionado;
	}

	public void setClassifEntidadeSelecionado(
			ClassifEntidade classifEntidadeSelecionado) {
		this.classifEntidadeSelecionado = classifEntidadeSelecionado;
	}

}
