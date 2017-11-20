package com.andreitoledo.altol.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.altol.vendas.dao.ClassifEntidadeDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.ClassifEntidade;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class CadastroClassifEntidadeService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClassifEntidadeDAO classifEntidadeDAO;
	
	@Transactional
	public void salvar(ClassifEntidade classifEntidade) throws NegocioException{
		
		this.classifEntidadeDAO.salvar(classifEntidade);
		
	}

}
