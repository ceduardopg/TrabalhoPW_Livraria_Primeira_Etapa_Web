package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.persistence.Query;

/**
 *
 * @author Carlos
 */
@Stateful
public class UsuarioDAO<TIPO> extends DAOGenerico<Usuario> implements Serializable {
    
    public UsuarioDAO(){
        super();
        classePersistente = Usuario.class;
        listaOrdem.add(new Ordem("nome_usuario", "Nome de Usuário", "like"));
        listaOrdem.add(new Ordem("senha", "Senha", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);  
    }
        
    @Override
    public Usuario getObjectByID(Object id) throws Exception {
        Usuario obj = em.find(Usuario.class, id);
        // uso para evitar o erro de lazy inicialization exception
        obj.getPermissoes().size();
        return obj;
    }     
    
    public boolean verificaUnicidadeNomeUsuario(String nomeUsuario) throws Exception {
        String jpql = "from Usuario where nomeUsuario = :pNomeUsuario";
        Query query = em.createQuery(jpql);
        query.setParameter("pNomeUsuario", nomeUsuario);
        if (query.getResultList().size() > 0){
            return false;
        } else {
            return true;
        }
    }    

}
