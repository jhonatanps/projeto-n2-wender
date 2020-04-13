/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import model.entidades.Usuario;

/**
 *
 * @author Cirim
 */
@Named(value = "usuarioMBean")
@SessionScoped
public class UsuarioMBean implements Serializable {

    /**
     * Creates a new instance of UsuarioMBean
     */
    public UsuarioMBean() {
    }

    private Usuario usuario;
    private List<Usuario> listaUsuario;

    private String valorPesquisar;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.listaUsuario = new ArrayList<>();

    }

    public void botaoPesquisar() {

    }

    public void botaoExcluir() {

    }

    public void botaoEditar() {

    }
    public String botaoSalvar() {
        listaUsuario.add(usuario);
        usuario = new Usuario();
        return "consUsuario?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public String getValorPesquisar() {
        return valorPesquisar;
    }

    public void setValorPesquisar(String valorPesquisar) {
        this.valorPesquisar = valorPesquisar;
    }


}
