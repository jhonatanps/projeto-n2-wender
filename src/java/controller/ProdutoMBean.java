/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.entidades.Produto;
import model.sessionbean.ProdutoSBean;
import uteis.UnidadeMedida;

/**
 *
 * @author Cirim
 */
@Named(value = "produtoMBean")
@SessionScoped
public class ProdutoMBean implements Serializable{


@EJB
private ProdutoSBean produtoSBean;

   
    public  ProdutoMBean() {
    }
    
  
    
    private Produto produto;
    private List<Produto> listaProduto;
    private List<UnidadeMedida> listaUnidadeMedida;
    
    private String valorPesquisar;
    
    
    @PostConstruct
    public void init(){
        this.produto = new Produto();
        this.listaProduto = new ArrayList<>();
        listaUnidadeMedida = Arrays.asList(UnidadeMedida.values());
    }
     public String botaoSalvar() {
         produtoSBean.salvar(produto);
        produto = new Produto();
        return "consProdutos?faces-redirect=true";
    }

    
    public void botaoPesquisar() {
       listaProduto = produtoSBean.pesquisar(valorPesquisar);
    }
    
    public void botaoExcluir() {
        produtoSBean.excluir(produto);
    }
    
    public String botaoEditar() {
       return "cadprodutos?faces-redirect=true";  
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public String getValorPesquisar() {
        return valorPesquisar;
    }

    public void setValorPesquisar(String valorPesquisar) {
        this.valorPesquisar = valorPesquisar;
    }

    public List<UnidadeMedida> getListaUnidadeMedida() {
        return listaUnidadeMedida;
    }

    public void setListaUnidadeMedida(List<UnidadeMedida> listaUnidadeMedida) {
        this.listaUnidadeMedida = listaUnidadeMedida;
    }
    
    
}
