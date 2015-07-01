/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Andressa
 */

@Entity
@Table(name = "turmas")
public class Turmas implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_turmas", sequenceName = "seq_turmas_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_turmas", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotEmpty(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ultrapassar {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de inicio deve ser informada")
    @Column(name = "dataInicio", nullable = false)
    private Calendar dataInicio;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de término deve ser informada")
    @Column(name = "dataFim", nullable = false)
    private Calendar dataFim;
    
    @Column(name = "numVagas", nullable = false)
    @NotNull(message = "O numero de vagas deve ser informada!")
    private Integer numVagas;
    
    public Turmas() {
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

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getNumVagas() {
        return numVagas;
    }

    public void setNumVagas(Integer numVagas) {
        this.numVagas = numVagas;
    }   
    
}
