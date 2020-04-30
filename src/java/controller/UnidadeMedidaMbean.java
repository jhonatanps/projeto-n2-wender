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
import model.entidades.UnidadeMedida;

import model.sessionbean.UnidadeMedidaSBean;


/**
 *
 * @author Cirim
 */
@Named(value = "unidadeMedidaMbean")
@SessionScoped
public class UnidadeMedidaMbean implements Serializable {

    private UnidadeMedida unidadeMedida;
    private String valorPesquisar;
    private List<UnidadeMedida> listaUnidadeMedidas;
  

    @EJB
    private UnidadeMedidaSBean unidadeMedidaSBean;
    

    public UnidadeMedidaMbean() {

    }

    @PostConstruct
    public void init() {
        valorPesquisar= "";
        unidadeMedida = new UnidadeMedida();
        listaUnidadeMedidas = new ArrayList<>();        
        listaUnidadeMedidas = unidadeMedidaSBean.pesquisar("");
        
    }

    public void botaoPesquisar() {
        listaUnidadeMedidas = unidadeMedidaSBean.pesquisar(valorPesquisar);
    }

    public String botaoSalvar() {
        unidadeMedidaSBean.salvar(unidadeMedida);
        unidadeMedida = new UnidadeMedida();
        return "consUnidadeMedida?faces-redirect=true";
    }

    public String botaoEditar() {
        
        return "cadunidadeMedida?faces-redirect=true";
    }

    public void botaoExcluir() {
        unidadeMedidaSBean.excluir(unidadeMedida);
        unidadeMedida = new UnidadeMedida();
        listaUnidadeMedidas.remove(unidadeMedida);
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getValorPesquisar() {
        return valorPesquisar;
    }

    public void setValorPesquisar(String valorPesquisar) {
        this.valorPesquisar = valorPesquisar;
    }

    public List<UnidadeMedida> getListaUnidadeMedidas() {
        return listaUnidadeMedidas;
    }

    public void setListaUnidadeMedidas(List<UnidadeMedida> listaUnidadeMedidas) {
        this.listaUnidadeMedidas = listaUnidadeMedidas;
    }

    public UnidadeMedidaSBean getUnidadeMedidaSBean() {
        return unidadeMedidaSBean;
    }

    public void setUnidadeMedidaSBean(UnidadeMedidaSBean unidadeMedidaSBean) {
        this.unidadeMedidaSBean = unidadeMedidaSBean;
    }

   

    
   

}
