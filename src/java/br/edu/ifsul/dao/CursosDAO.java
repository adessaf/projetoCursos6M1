/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cursos;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Andressa
 */

@Stateful
public class CursosDAO<T> extends GenericDAO<Cursos> implements Serializable{

    public CursosDAO() {
        
         super();
        //definindo a classe persistence
        super.setPersistentClass(Cursos.class);
        //definindo as ordenações possiveis
        super.getListOrder().add(new Order("id","ID", "="));
        super.getListOrder().add(new Order("nome", "Nome", "like"));
        //definir qual ordenação padrão
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }
    
    
    
}
