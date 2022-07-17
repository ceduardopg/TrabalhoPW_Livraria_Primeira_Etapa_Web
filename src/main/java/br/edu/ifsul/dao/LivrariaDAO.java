package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Livraria;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Carlos
 */
@Stateful
public class LivrariaDAO<TIPO> extends DAOGenerico<Livraria> implements Serializable {
    
    public LivrariaDAO(){
        super();
        classePersistente = Livraria.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("site", "Site", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);  
    }
    
    @Override
    public Livraria getObjectByID(Object id) throws Exception {
        Livraria obj = em.find(Livraria.class, id);
       obj.getCatalogos().size();
        return obj;
    }    
    
    public List<Livraria> getListaObjetosCompleta(){
        String jpql = "select distinct l from Livraria l left join fetch l.catalogos order by l.id";
        return em.createQuery(jpql).getResultList();
    }


}
