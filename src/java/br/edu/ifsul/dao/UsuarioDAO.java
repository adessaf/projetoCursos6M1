/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Andressa
 */

@Stateful
public class UsuarioDAO<T> extends GenericDAO<Usuario> implements Serializable{

    public UsuarioDAO() {
        
        
        
    }
    
    
}
