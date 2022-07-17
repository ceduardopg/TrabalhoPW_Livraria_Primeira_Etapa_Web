package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Formato;
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
@Named(value = "converterFormato")
@RequestScoped
public class ConverterFormato implements Serializable, Converter{

    @PersistenceContext(unitName = "LivrariaWebPU")
    private EntityManager em;
    
    // da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Formato.class, Integer.parseInt(string));
    }

    // converte da objeto para tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null){
            return null;
        }
        Formato obj = (Formato) t;
        return obj.getId().toString();
    }

}
