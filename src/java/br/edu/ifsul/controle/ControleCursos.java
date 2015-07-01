package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CursosDAO;
import br.edu.ifsul.dao.DisciplinaDAO;
import br.edu.ifsul.modelo.Cursos;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.util.Util;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "controleCursos")
@ViewScoped
public class ControleCursos implements Serializable {

    @EJB
    private CursosDAO<Cursos> dao;
    private Cursos objeto;
    @EJB
    private DisciplinaDAO<Disciplina> daoDisciplina;
    private Disciplina disciplina;

    public ControleCursos() {
    }

    public String listar() {
        return "privado/cursos/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Cursos();
    }

    public CursosDAO<Cursos> getDao() {
        return dao;
    }

    public void setDao(CursosDAO<Cursos> dao) {
        this.dao = dao;
    }

    public Cursos getObjeto() {
        return objeto;
    }

    public void setObjeto(Cursos objeto) {
        this.objeto = objeto;
    }

    public DisciplinaDAO<Disciplina> getDaoDisciplina() {
        return daoDisciplina;
    }

    public void setDaoDisciplina(DisciplinaDAO<Disciplina> daoDisciplina) {
        this.daoDisciplina = daoDisciplina;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir: " + e.getMessage());
        }
    }

    public void editar(Integer id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + e.getMessage());
        }
    }

    public void remover(Integer id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: " + e.getMessage());
        }
    }

    
    public void adicionarDisciplina() {
        objeto.adicionarDisciplina(disciplina);
        Util.mensagemInformacao("Disciplina adicionada com sucesso");
    }

    public void removerDisciplina(Disciplina obj) {
        objeto.removerDisciplina(obj);
        Util.mensagemInformacao("Disciplina removida com sucesso");
    }
}