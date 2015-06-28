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
import javax.persistence.ManyToOne;
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
@Table(name = "aluno")
public class Aluno extends Usuario implements Serializable{
    
    @NotEmpty(message = "A escolaridade deve ser informada!")
    @Length(max = 30, message = "A escolaridade não deve ultrapassar {max} caracteres")
    @Column(name = "escolaridade", length = 30, nullable = false)
    private String escolaridade;
    @NotNull(message = "A matricula deve ser informada")
    
    @ManyToOne
    @JoinColumn(name = "matricula", referencedColumnName = "id", nullable = false)
    private Matricula matricula;

    public Aluno() {
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }  
    
    
}
