/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidades.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import uteis.jsf.UteisJsf;

/**
 *
 * @author Cirim
 */
@Named(value = "homeMBean")
@RequestScoped
public class homeMBean implements Serializable {
 
    private Usuario usuarioLogado;
       

    public homeMBean() {
        
    }
    
    @PostConstruct
    public void init() {
         usuarioLogado = (Usuario)UteisJsf.getObjectSession("usuarioLogado");
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    
    
    
    
}
