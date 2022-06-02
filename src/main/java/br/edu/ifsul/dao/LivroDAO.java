package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Livro;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Carlos
 */
@Stateful
public class LivroDAO<TIPO> extends DAOGenerico<Livro> implements Serializable {
    
    public LivroDAO(){
        super();
        classePersistente = Livro.class;
    }

}
