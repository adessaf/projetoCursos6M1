/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluno;
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
public class TesteInserirAluno {
    
    EntityManagerFactory emf;
    EntityManager em ;

    public TesteInserirAluno() {
    }
    
    
    
    @Before
    public void setUp() {
        
        emf = Persistence.createEntityManagerFactory("Cursos6M1PULocal");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testar(){
        boolean exception = false ;
        try{
            Aluno obj = new Aluno();
            Matricula mat = em.find(Matricula.class,1);
            obj.setNome("Nome");
            obj.setNascimento(Calendar.getInstance());
            obj.setEndereco("Rua da pirir");
            obj.setLogin("mari");
            obj.setSenha("12345");
            obj.setTelefone("33233432");
            obj.setEscolaridade("Ensino Medio");
            obj.setMatricula(mat);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
