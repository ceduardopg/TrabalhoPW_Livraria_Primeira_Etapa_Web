package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Idioma;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Carlos
 */
@Stateful
public class IdiomaDAO<TIPO> extends DAOGenerico<Idioma> implements Serializable {
    
    public IdiomaDAO(){
        super();
        classePersistente = Idioma.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("sigla", "Sigla", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem); 
    }

}
