package com.andreitoledo.altol.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.altol.vendas.dao.VendedorDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.Vendedor;
import com.andreitoledo.altol.vendas.util.jpa.Transactional;

public class CadastroVendedorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private VendedorDAO vendedorDAO;

	@Transactional
	public void salvar(Vendedor vendedor) throws NegocioException {
		
		if (vendedor.getFuncionario() == null) {
			throw new NegocioException("O funcionário é obrigatório.");

		}

		this.vendedorDAO.salvar(vendedor);

	}

}
