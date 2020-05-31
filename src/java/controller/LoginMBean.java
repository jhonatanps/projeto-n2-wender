/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import sessionbean.LoginSBean;
import entidades.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import uteis.jsf.UteisJsf;

/**
 *
 * @author Cirim
 */
@Named(value = "loginMBean")
@SessionScoped
public class LoginMBean implements Serializable{
    
    private String userName = "";
    private String senha = "";
    
    
    private Usuario usuario = new Usuario();
    
    @EJB
    private LoginSBean loginSBean;
    
    public LoginMBean() {

    }
    
    public String logar() {
        try {
            this.usuario = loginSBean.logar(this.userName, this.senha);
            if (this.usuario != null) {
                UteisJsf.setObjectSession("usuarioLogado", this.usuario);
                return "home";
            }
            UteisJsf.addMensagemInfo("Usuario ou senha invalidos.", "");
        } catch (Exception ex) {
            UteisJsf.addMensagemInfo(ex.getMessage(), "");
        }
        this.usuario = new Usuario();
        this.userName = "";
        this.senha = "";
        return null;
    }
    
    public String sair() {
        UteisJsf.removeObjectSession("usuarioLogado");        
        return "index";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
