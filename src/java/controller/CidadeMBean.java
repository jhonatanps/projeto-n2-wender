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
import model.entidades.Cidade;
import model.sessionbean.CidadeSBean;


/**
 *
 * @author Cirim
 */
@Named(value = "cidadeMBean")
@SessionScoped
public class CidadeMBean implements Serializable{

    

   @EJB
    private CidadeSBean cidadeSBean;
   
    public CidadeMBean() {
    }
    
   
    
    private Cidade cidade;
    private List<Cidade> listaCidade;
    
    private String valorPesquisar;
    
    @PostConstruct
    public void init(){
        this.cidade = new Cidade();
        this.listaCidade = new ArrayList<>();
                
    }

    
    public void botaoPesquisar() {
        listaCidade = cidadeSBean.pesquisar(valorPesquisar);
    }
    
    public void botaoExcluir() {
        cidadeSBean.excluir(cidade);
        listaCidade.remove(cidade);
    }
    
    public String botaoEditar() {
        return "cadcidade?faces-redirect=true";
    }
     public String botaoSalvar() {
       cidadeSBean.salvar(cidade);
        this.cidade = new Cidade();
        return "consCidade?faces-redirect=true";
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getListaCidade() {
        return listaCidade;
    }

    public void setListaCidade(List<Cidade> listaCidade) {
        this.listaCidade = listaCidade;
    }

   

    public String getValorPesquisar() {
        return valorPesquisar;
    }

    public void setValorPesquisar(String valorPesquisar) {
        this.valorPesquisar = valorPesquisar;
    }
    
}
