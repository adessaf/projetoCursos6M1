/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.AlunoDAO;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Andressa
 */
@ManagedBean(name = "controleLogin")
@SessionScoped
public class ControleLogin implements Serializable{
    
    @EJB
    AlunoDAO<Usuario> dao;
    private Usuario usuarioLogado;
    private String usuario;
    private String senha;

    public ControleLogin() {
    }
    
    public String paginaLogin(){
        return "login?faces-redirect=true";
    }
    
    public String efetuarLogin(){
        if(dao.login(getUsuario(), senha)){
            usuarioLogado = dao.localizarUsuairioPorNome(usuario);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            //capturando o ip remoto
        } else{
            Util.mensagemErro("Usuario ou senha invalidos!");
            return "/login";
        }
        return "/index";
    }
    
    public String efetuarLogout(){
        usuarioLogado = null;
        Util.mensagemInformacao("Logout efetuado com sucesso");
        return "/index";
    }

   
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

   
    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    
    public String getSenha() {
        return senha;
    }

    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
