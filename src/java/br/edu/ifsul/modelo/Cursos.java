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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "cursos")
public class Cursos implements Serializable{
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_cursos", sequenceName = "seq_cursos_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cursos", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotEmpty(message = "O nome deve ser informado!")
    @Length(max = 50, message = "O nome não deve ultrapassar {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotEmpty(message = "A descrição deve ser informada!")
    @Length(max = 100, message = "A descrição deve ter até {max} caracteres")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    
    @Column(name = "cargaHoraria", nullable = false)
    @NotNull(message = "A carga horária total deve ser informada!")
    private Integer cargaHoraria;
    
    @Column(name = "valor", nullable = false)
    @NotNull(message = "O valor deve ser informado!")
    private Double valor;
    
   @ManyToMany
    @JoinTable(name = "cursosDisciplinas", 
            //joinColumn se refere a coluna que armazena o id desta entidade
            joinColumns = @JoinColumn(name = "cursos", referencedColumnName = "id"), 
            //inverseJoinColumn se refere a coluna que armazena o id da entidade do outro lado da relação
            inverseJoinColumns = @JoinColumn (name = "disciplina", referencedColumnName = "id"))
    private List<Disciplina> cursosDisciplina = new ArrayList<>();

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Disciplina> getCursosDisciplina() {
        return cursosDisciplina;
    }

    public void setCursosDisciplina(List<Disciplina> cursosDisciplina) {
        this.cursosDisciplina = cursosDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Cursos other = (Cursos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
        
}
