/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Andressa
 */

@ManagedBean(name = "controlePrincipal")
@RequestScoped
public class ControlePrincipal implements Serializable{
    
    public ControlePrincipal() {
    }
        
    public String home(){
        return "/index?faces-redirect=true";
    }
    
}