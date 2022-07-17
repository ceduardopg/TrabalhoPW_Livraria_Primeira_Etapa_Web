package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Formato;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Carlos
 */
@Stateful
public class FormatoDAO<TIPO> extends DAOGenerico<Formato> implements Serializable {
    
    public FormatoDAO(){
        super();
        classePersistente = Formato.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);  
    }

}
