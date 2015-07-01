/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.TurmaDAO;
import br.edu.ifsul.modelo.Turmas;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Andressa
 */

@ManagedBean(name = "controleTurma")
@ViewScoped
public class ControleTurma implements Serializable{
    
    @EJB
    private TurmaDAO<Turmas> dao;
    private Turmas objeto;

    public ControleTurma() {
    }
    
    public String listar(){
        return "privado/turma/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Turmas();
    }
    
    public void salvar(){
        try {
            if(objeto.getId() == null){
                dao.persist(objeto);
            } else{
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir: "+e.getMessage());
        }
    }
    
     public void remover(Integer id){
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");            
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: "+e.getMessage());
        }
    }
    
    public void editar(Integer id){
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao editar objeto: "+e.getMessage());
        }
        
    }

    public TurmaDAO<Turmas> getDao() {
        return dao;
    }

    public void setDao(TurmaDAO<Turmas> dao) {
        this.dao = dao;
    }

    public Turmas getObjeto() {
        return objeto;
    }

    public void setObjeto(Turmas objeto) {
        this.objeto = objeto;
    }
    
}
