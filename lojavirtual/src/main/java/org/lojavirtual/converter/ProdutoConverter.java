package org.lojavirtual.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.lojavirtual.Cliente;
import org.lojavirtual.Produto;
import org.lojavirtual.repository.Clienterepository;
import org.lojavirtual.repository.Produtorepository;


@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

	@Inject
	private Produtorepository  produtorepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.produtorepository.porid(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Produto lancamento = ((Produto) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		return "";
	}

}
