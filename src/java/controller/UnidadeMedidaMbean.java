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
import entidades.UnidadeMedida;

import sessionbean.UnidadeMedidaSBean;
import uteis.jsf.UteisJsf;


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

    public void botaoSalvar() {
        try{
        unidadeMedidaSBean.salvar(unidadeMedida);
        unidadeMedida = new UnidadeMedida();
        UteisJsf.addMensagemInfo("Salvar:", "Unidade de Medida salva com sucesso.");
       // return "consUnidadeMedida?faces-redirect=true";
        }catch(Exception ex){
            UteisJsf.addMensagemErro("Erro ao Salvar", ex.getMessage());
        }
    }
    
    public String botaoNavPesquisar(){
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
