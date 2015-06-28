/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.DisciplinaDAO;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Andressa
 */

@ManagedBean(name = "controleDisciplina")
@ViewScoped
public class ControleDisciplina implements Serializable{
    
    @EJB
    private DisciplinaDAO<Disciplina> dao;
    private Disciplina objeto;

    public ControleDisciplina() {
    }
    
     public String listar(){
        return "estado/listar";
    }
    
    public void novo(){
        objeto = new Disciplina();
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

    public DisciplinaDAO<Disciplina> getDao() {
        return dao;
    }

    public void setDao(DisciplinaDAO<Disciplina> dao) {
        this.dao = dao;
    }

    public Disciplina getObjeto() {
        return objeto;
    }

    public void setObjeto(Disciplina objeto) {
        this.objeto = objeto;
    }

    
    
    
}
