package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Autor;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Carlos
 */
@Stateful
public class AutorDAO<TIPO> extends DAOGenerico<Autor> implements Serializable {
    
    public AutorDAO(){
        super();
        classePersistente = Autor.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("bibliografia", "Bibliografia", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);  
    }

}
