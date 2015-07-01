/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Professor;
import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.persistence.Query;

/**
 *
 * @author Andressa
 */

@Stateful
public class ProfessorDAO<T> extends GenericDAO<Professor> implements Serializable{

    public ProfessorDAO() {
        
        super();
        //definindo a classe persistence
        super.setPersistentClass(Professor.class);
        //definindo as ordenações possiveis
        super.getListOrder().add(new Order("id","ID", "="));
        super.getListOrder().add(new Order("nome", "Nome", "like"));
        //definir qual ordenação padrão
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }
    
    public Usuario getObjetctById(Integer id){
        Usuario obj = super.getEm().find(Usuario.class, id);
        obj.getNome();
        return obj;
    }
    
    public Boolean login(String usuario, String senha){
        Query query = super.getEm().createQuery("from Usuario where upper(login) = :usuario and upper(senha) = :senha");
        query.setParameter("usuario", usuario.toUpperCase());
        query.setParameter("senha", senha.toUpperCase());
        
        if(!query.getResultList().isEmpty()){
            return true;
        } else{
            return false;
        }
    }
    
    public Usuario localizarUsuairioPorNome(String usuario){
        Usuario obj = (Usuario) super.getEm().createQuery("from Usuario where upper(login) = :usuario").setParameter("usuario", usuario.toUpperCase()).getSingleResult();
        obj.getNome();
        return obj;
    }
    
}
