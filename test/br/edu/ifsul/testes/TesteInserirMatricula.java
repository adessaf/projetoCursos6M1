/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Matricula;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Andressa
 */
public class TesteInserirMatricula {
    
    EntityManagerFactory emf;
    EntityManager em ;
    
    public TesteInserirMatricula() {
    }
    
    @Before
    public void setUp() {
         emf = Persistence.createEntityManagerFactory("Cursos6M1PULocal");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void testar() {
        boolean exception = false;
        try {
            Matricula obj = new Matricula();
            obj.setNumero("2321234");
            obj.setData(Calendar.getInstance());
            obj.setValor(34.40);
            obj.setAtivo(false);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
