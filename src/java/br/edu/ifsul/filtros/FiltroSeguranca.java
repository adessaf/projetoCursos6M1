/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.filtros;

import br.edu.ifsul.controle.ControleLogin;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andressa
 */
@WebFilter(urlPatterns = "/privado/*")
public class FiltroSeguranca implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //Capturando a requisição e a resposta em um HttpServlet
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //Capturando a sessão
        HttpSession sessao = httpRequest.getSession();
        //Capturando o caminho do contexto de reuisição
        String contextPath = httpRequest.getContextPath();
        //Capturando controleLogin da sessão
        ControleLogin controleLogin = (ControleLogin) sessao.getAttribute("controleLogin");
        //Verificando se o usuario esta logado
        if(controleLogin == null || controleLogin.getUsuarioLogado() == null){
            //caso nao esteja redireciona login
            httpResponse.sendRedirect(contextPath + "/login.xhtml");
        }
        //processa a requisição
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
       
    }
    
}
