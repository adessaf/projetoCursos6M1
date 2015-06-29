/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Andressa
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "professor")
public class Professor extends Usuario implements Serializable{
    
    @NotEmpty(message = "A formação deve ser informada!")
    @Length(max = 30, message = "A formação não deve ultrapassar {max} caracteres")
    @Column(name = "formacao", length = 30, nullable = false)
    private String formacao;
    
    @NotEmpty(message = "A área de interesse deve ser informada!")
    @Length(max = 30, message = "A de interesse deve ser informada não deve ultrapassar {max} caracteres")
    @Column(name = "escolaridade", length = 30, nullable = false)
    private String areaInteresse;
    
    @NotNull(message="A disciplina deve ser informada")
    @ManyToOne
    @JoinColumn(name="disciplina", referencedColumnName = "id", nullable = false)
    private Disciplina disciplina;
    
    @ManyToMany
    @JoinTable(name = "turmasProfessores", 
            //joinColumn se refere a coluna que armazena o id desta entidade
            joinColumns = @JoinColumn(name = "professor", referencedColumnName = "id"), 
            //inverseJoinColumn se refere a coluna que armazena o id da entidade do outro lado da relação
            inverseJoinColumns = @JoinColumn (name = "turmas", referencedColumnName = "id"))
    private List<Turmas> turmasProfessores = new ArrayList<>();

    public Professor() {
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getAreaInteresse() {
        return areaInteresse;
    }

    public void setAreaInteresse(String areaInteresse) {
        this.areaInteresse = areaInteresse;
    }

   
    public List<Turmas> getTurmasProfessores() {
        return turmasProfessores;
    }

    public void setTurmasProfessores(List<Turmas> turmasProfessores) {
        this.turmasProfessores = turmasProfessores;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    

      
}
