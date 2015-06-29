/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andressa
 */

@Entity
@Table(name = "matricula")
public class Matricula implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "numero", nullable = false)
    @NotNull(message = "O numero da matricula deve ser informada!")
    private String numero;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada")
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @Column(name = "valor", nullable = false)
    @NotNull(message = "O valor da matricula deve ser informada!")
    private Double valor;
    
    @NotNull(message = "O ativo deve ser informado")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    public Matricula() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Matricula other = (Matricula) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    } 

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    
    
    
}
