/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidades.Grupo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import entidades.Produto;
import entidades.UnidadeMedida;
import sessionbean.GrupoSBean;
import sessionbean.ProdutoSBean;
import sessionbean.UnidadeMedidaSBean;
import uteis.jsf.GrupoConverter;
import uteis.jsf.UnidadeMedidaConverter;


/**
 *
 * @author Cirim
 */
@Named(value = "produtoMBean")
@SessionScoped
public class ProdutoMBean implements Serializable {

    @EJB
    private ProdutoSBean produtoSBean;
    @EJB
    private UnidadeMedidaSBean unidadeMedidaSBean;
    
    @EJB
    private GrupoSBean grupoSBean;

    public ProdutoMBean() {
    }

    private Produto produto;
    private String valorPesquisar;
    private List<Produto> listaProduto;
    private List<UnidadeMedida> listaUnidadeMedida;
    private List<Grupo> listaGrupo;
    
    private UnidadeMedidaConverter unidadeMedidaConverter;
    private GrupoConverter grupoConverter;


    @PostConstruct
    public void init() {
        valorPesquisar = "";
        this.produto = new Produto();
        this.listaProduto = new ArrayList<>();
        this.inicioFormularioCadastro();
        
    }
    private void inicioFormularioCadastro(){
        listaUnidadeMedida = unidadeMedidaSBean.pesquisar("");
        unidadeMedidaConverter = new UnidadeMedidaConverter();
        unidadeMedidaConverter.setUnidadeMedidaSBean(unidadeMedidaSBean);
        
        listaGrupo = grupoSBean.pesquisar("");
        grupoConverter = new GrupoConverter();
        grupoConverter.setGrupoSBean(grupoSBean);
    }

    public String botaoSalvar() {
        produtoSBean.salvar(produto);
        produto = new Produto();
        this.inicioFormularioCadastro();
        return "consProdutos?faces-redirect=true";
    }
    public String botaoNovo(){
        inicioFormularioCadastro();
        return "cadprodutos?faces-redirect=true";
    }

    public void botaoPesquisar() {
        listaProduto = produtoSBean.pesquisar(valorPesquisar);
    }

    public void botaoExcluir() {
        produtoSBean.excluir(produto);
        listaProduto.remove(produto);
    }

    public String botaoEditar() {
        this.inicioFormularioCadastro();
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

    public ProdutoSBean getProdutoSBean() {
        return produtoSBean;
    }

    public void setProdutoSBean(ProdutoSBean produtoSBean) {
        this.produtoSBean = produtoSBean;
    }

    public UnidadeMedidaSBean getUnidadeMedidaSBean() {
        return unidadeMedidaSBean;
    }

    public void setUnidadeMedidaSBean(UnidadeMedidaSBean unidadeMedidaSBean) {
        this.unidadeMedidaSBean = unidadeMedidaSBean;
    }

    public List<UnidadeMedida> getListaUnidadeMedida() {
        return listaUnidadeMedida;
    }

    public void setListaUnidadeMedida(List<UnidadeMedida> listaUnidadeMedida) {
        this.listaUnidadeMedida = listaUnidadeMedida;
    }


    public UnidadeMedidaConverter getUnidadeMedidaConverter() {
        return unidadeMedidaConverter;
    }

    public void setUnidadeMedidaConverter(UnidadeMedidaConverter unidadeMedidaConverter) {
        this.unidadeMedidaConverter = unidadeMedidaConverter;
    }

    public GrupoSBean getGrupoSBean() {
        return grupoSBean;
    }

    public void setGrupoSBean(GrupoSBean grupoSBean) {
        this.grupoSBean = grupoSBean;
    }

    public GrupoConverter getGrupoConverter() {
        return grupoConverter;
    }

    public void setGrupoConverter(GrupoConverter grupoConverter) {
        this.grupoConverter = grupoConverter;
    }

    

    public List<Grupo> getListaGrupo() {
        return listaGrupo;
    }

    public void setListaGrupo(List<Grupo> listaGrupo) {
        this.listaGrupo = listaGrupo;
    }
    
    

}
