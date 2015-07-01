/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Andressa
 */

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable{
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotEmpty(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ultrapassar {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "cargaHoraria", length = 2, nullable = false)
    @NotNull(message = "A carga Horária da disciplina deve ser informada!")
    private Integer cargaHoraria;
    
    @ManyToMany
    @JoinTable(name = "cursosDisciplinas", 
            //joinColumn se refere a coluna que armazena o id desta entidade
            joinColumns = @JoinColumn(name = "cursos", referencedColumnName = "id"), 
            //inverseJoinColumn se refere a coluna que armazena o id da entidade do outro lado da relação
            inverseJoinColumns = @JoinColumn (name = "disciplina", referencedColumnName = "id"))
    private List<Cursos> cursosDisciplina = new ArrayList<>();
    
    public Disciplina() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    } 

    public List<Cursos> getCursosDisciplina() {
        return cursosDisciplina;
    }

    public void setCursosDisciplina(List<Cursos> cursosDisciplina) {
        this.cursosDisciplina = cursosDisciplina;
    }

    
    
}
