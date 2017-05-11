package org.lojavirtual.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.lojavirtual.Cliente;
import org.lojavirtual.Produto;
import org.lojavirtual.Usuario;
import org.lojavirtual.repository.Clienterepository;
import org.lojavirtual.repository.Produtorepository;
import org.lojavirtual.repository.Usuariorepository;


@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	@Inject
	private Usuariorepository  produtorepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.produtorepository.porid(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Usuario lancamento = ((Usuario) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}

}
