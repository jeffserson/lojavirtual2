package org.lojavirtual.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.lojavirtual.Cliente;
import org.lojavirtual.repository.Clienterepository;


@FacesConverter(forClass = Cliente.class)
public class ClienteConverter2 implements Converter {

	@Inject
	private Clienterepository clientemy;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.clientemy.porid(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Cliente lancamento = ((Cliente) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}

}
