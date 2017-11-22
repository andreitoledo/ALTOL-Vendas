package com.andreitoledo.altol.vendas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.altol.vendas.dao.PessoaFisicaDAO;
import com.andreitoledo.altol.vendas.model.cadastros.entidade.PessoaFisica;

@FacesConverter(forClass = PessoaFisica.class)
public class PessoaFisicaConverter implements Converter {

	@Inject
	private PessoaFisicaDAO pessoaFisicaDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		PessoaFisica retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.pessoaFisicaDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Long codigo = ((PessoaFisica) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
