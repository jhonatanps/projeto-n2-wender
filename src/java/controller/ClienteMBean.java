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
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.entidades.Cliente;

/**
 *
 * @author Cirim
 */
@Named(value = "clienteMBean")
@SessionScoped
public class ClienteMBean implements Serializable{

    

    /**
     * Creates a new instance of ClienteMBean
     */
    public ClienteMBean() {
    }
    
   
    
    private Cliente cliente;
    private List<Cliente> listaCliente;
    
    private String valorPesquisar;
    
    @PostConstruct
    public void init(){
        this.cliente = new Cliente();
        this.listaCliente = new ArrayList<>();
                
    }

    
    public void botaoPesquisar() {
        
    }
    
    public void botaoExcluir() {
        
    }
    
    public void botaoEditar() {
        
    }
     public String botaoSalvar() {
        this.listaCliente.add(cliente);
        this.cliente = new Cliente();
        return "consCliente?faces-redirect=true";
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
    
}
