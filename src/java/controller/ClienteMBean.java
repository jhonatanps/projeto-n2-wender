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
import model.entidades.Cidade;
import model.entidades.Cliente;
import model.sessionbean.CidadeSBean;
import model.sessionbean.ClienteSBean;
import uteis.jsf.CidadeConverter;



/**
 *
 * @author Cirim
 */
@Named(value = "clienteMBean")
@SessionScoped
public class ClienteMBean implements Serializable {

    @EJB
    private ClienteSBean clienteSBean;
    @EJB
    private CidadeSBean cidadeSBean;

    public ClienteMBean() {
    }

    private Cliente cliente;
    private List<Cliente> listaCliente;
    
    private List<Cidade> listaCidade;

    private String valorPesquisar;

    private CidadeConverter cidadeConverter;
    
    @PostConstruct
    public void init() {
        this.inicioFormularioCadastro();
        valorPesquisar = "";
        this.cliente = new Cliente();
        this.listaCliente = new ArrayList<>();

    }
    private void inicioFormularioCadastro(){
        listaCidade = cidadeSBean.pesquisar("");
        cidadeConverter = new CidadeConverter();
        cidadeConverter.setCidadeSBean(cidadeSBean);
    }
     public String botaoNovo(){
        inicioFormularioCadastro();
        return "cadcliente?faces-redirect=true";
    }

    public void botaoPesquisar() {
       listaCliente = clienteSBean.pesquisar(valorPesquisar);
    }

    public void botaoExcluir() {
       clienteSBean.excluir(cliente);
       listaCliente.remove(cliente);
    }

    public String botaoEditar() {

        return "cadcliente?faces-redirect=true";
    }

    public String botaoSalvar() {
        System.out.println("salvar cliente" + cliente.getNome());
        this.clienteSBean.salvar(cliente);
        cliente = new Cliente();
        return "consCliente?faces-redirect=true";
    }


    public ClienteSBean getClienteSBean() {
        return clienteSBean;
    }

    public void setClienteSBean(ClienteSBean clienteSBean) {
        this.clienteSBean = clienteSBean;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public String getValorPesquisar() {
        return valorPesquisar;
    }

    public void setValorPesquisar(String valorPesquisar) {
        this.valorPesquisar = valorPesquisar;
    }

    public CidadeSBean getCidadeSBean() {
        return cidadeSBean;
    }

    public void setCidadeSBean(CidadeSBean cidadeSBean) {
        this.cidadeSBean = cidadeSBean;
    }

    public CidadeConverter getCidadeConverter() {
        return cidadeConverter;
    }

    public void setCidadeConverter(CidadeConverter cidadeConverter) {
        this.cidadeConverter = cidadeConverter;
    }

    public List<Cidade> getListaCidade() {
        return listaCidade;
    }

    public void setListaCidade(List<Cidade> listaCidade) {
        this.listaCidade = listaCidade;
    }



}
