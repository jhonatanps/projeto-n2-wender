/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import entidades.Grupo;
import sessionbean.GrupoSBean;


/**
 *
 * @author Cirim
 */
@Named(value = "grupoMBean")
@SessionScoped
public class GrupoMBean implements Serializable{

    

   @EJB
    private GrupoSBean grupoSBean;
   
    public GrupoMBean() {
    }
    
   
    
    private Grupo grupo;
    private List<Grupo> listaGrupo;
    
    private String valorPesquisar;
    
    @PostConstruct
    public void init(){
        this.grupo = new Grupo();
        this.listaGrupo = new ArrayList<>();
                
    }

    
    public void botaoPesquisar() {
        listaGrupo = grupoSBean.pesquisar(valorPesquisar);
    }
    
    public void botaoExcluir() {
        grupoSBean.excluir(grupo);
        listaGrupo.remove(grupo);
    }
    
    public String botaoEditar() {
        return "cadgrupo?faces-redirect=true";
    }
     public String botaoSalvar() throws Exception {
       grupoSBean.salvar(grupo);
        this.grupo = new Grupo();
        return "consGrupo?faces-redirect=true";
    }

    public GrupoSBean getGrupoSBean() {
        return grupoSBean;
    }

    public void setGrupoSBean(GrupoSBean grupoSBean) {
        this.grupoSBean = grupoSBean;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Grupo> getListaGrupo() {
        return listaGrupo;
    }

    public void setListaGrupo(List<Grupo> listaGrupo) {
        this.listaGrupo = listaGrupo;
    }

    public String getValorPesquisar() {
        return valorPesquisar;
    }

    public void setValorPesquisar(String valorPesquisar) {
        this.valorPesquisar = valorPesquisar;
    }

    
    
}
