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
import javax.ejb.EJB;
import entidades.Fornecedor;
import sessionbean.FornecedorSBean;





/**
 *
 * @author Cirim
 */
@Named(value = "fornecedorMBean")
@SessionScoped
public class FornecedorMBean implements Serializable {

  
    @EJB
    private FornecedorSBean fornecedorSBean;
    
    public FornecedorMBean() {
    }

    private Fornecedor fornecedor;
    private List<Fornecedor> listaFornecedor;
    
  

    private String valorPesquisar;

  
    
    @PostConstruct
    public void init(){
        inicioFormularioCadastro();
        valorPesquisar = "";
        this.fornecedor = new Fornecedor();
        this.listaFornecedor = new ArrayList<>();

    }
    private void inicioFormularioCadastro(){
        listaFornecedor = fornecedorSBean.pesquisar("");
            
    }
     public String botaoNovo() {
        inicioFormularioCadastro();
        return "cadfornecedor?faces-redirect=true";
    }

    public void botaoPesquisar() {
       listaFornecedor = fornecedorSBean.pesquisar(valorPesquisar);
    }

    public void botaoExcluir() {
       fornecedorSBean.excluir(fornecedor);
       listaFornecedor.remove(fornecedor);
    }

    public String botaoEditar() {

        return "cadfornecedor?faces-redirect=true";
    }

    public String botaoSalvar() {
        System.out.println("salvar fornecedor" + fornecedor.getNome());
        this.fornecedorSBean.salvar(fornecedor);
        fornecedor = new Fornecedor();
        return "consFornecedor?faces-redirect=true";
    }

    public FornecedorSBean getFornecedorSBean() {
        return fornecedorSBean;
    }

    public void setFornecedorSBean(FornecedorSBean fornecedorSBean) {
        this.fornecedorSBean = fornecedorSBean;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

    public String getValorPesquisar() {
        return valorPesquisar;
    }

    public void setValorPesquisar(String valorPesquisar) {
        this.valorPesquisar = valorPesquisar;
    }


   


}
