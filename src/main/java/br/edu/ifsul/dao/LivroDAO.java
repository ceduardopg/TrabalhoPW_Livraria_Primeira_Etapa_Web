package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
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
        listaOrdem.add(new Ordem("isbn", "ISBN", "like"));
        listaOrdem.add(new Ordem("titulo", "Titulo", "like"));
        listaOrdem.add(new Ordem("resumo", "Resumo", "like"));
        listaOrdem.add(new Ordem("editora", "Editora", "like"));
        listaOrdem.add(new Ordem("data_publicacao", "Publicação", "like"));
        listaOrdem.add(new Ordem("codigo_barras", "Codigo de Barras", "like"));
        listaOrdem.add(new Ordem("numero_paginas", "Paginas", "="));
        listaOrdem.add(new Ordem("ativo", "Ativo", "="));
        listaOrdem.add(new Ordem("data_cadastro", "Cadastro", "like"));
        listaOrdem.add(new Ordem("valor", "Valor", "="));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem); 
    }

}
