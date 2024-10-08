package com.andreitoledo.altol.vendas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.altol.vendas.dao.FuncionarioDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.Funcionario;

@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConverter implements Converter {

	@Inject
	private FuncionarioDAO funcionarioDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Funcionario retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.funcionarioDAO.buscarPelocodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Long codigo = ((Funcionario) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
