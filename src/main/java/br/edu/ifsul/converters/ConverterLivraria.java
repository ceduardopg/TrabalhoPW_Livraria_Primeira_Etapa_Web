package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Livraria;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Named(value = "converterLivraria")
@RequestScoped
public class ConverterLivraria implements Serializable, Converter{

    @PersistenceContext(unitName = "LivrariaWebPU")
    private EntityManager em;
    
    // da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Livraria.class, Integer.parseInt(string));
    }

    // converte da objeto para tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null){
            return null;
        }
        Livraria obj = (Livraria) t;
        return obj.getId().toString();
    }

}
