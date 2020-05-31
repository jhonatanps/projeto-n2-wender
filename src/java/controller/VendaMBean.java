/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import entidades.Venda;
import sessionbean.ClienteSBean;
import sessionbean.ProdutoSBean;
import sessionbean.VendaSBean;
import uteis.jsf.UteisJsf;


/**
 *
 * @author Cirim
 */
@Named(value = "vendaMBean")
@SessionScoped
public class VendaMBean implements Serializable {
    
    
    @EJB
    private VendaSBean vendaSBean;
    @EJB
    private ProdutoSBean produtoSBean;
    @EJB
    private ClienteSBean clienteSBean;

    private Venda venda;
 
    
    private List<Venda> listaVenda;
    
    private String valorPesquisar;
   
    
    public VendaMBean(){
        
    }


    @PostConstruct
    public void init() {
        
        
    }
    

    public void botaoSalvar() throws Exception {
        try{
        this.vendaSBean.salvar(this.venda);
        UteisJsf.addMensagemInfo("Salva com sucesso.", "");
        this.venda = new Venda();
        }catch(Exception ex){
        UteisJsf.addMensagemErro("Erro ao Salvar. ", ex.getMessage());
      }
    }
    
    public String botaoNovo(){
        this.venda = new Venda();
        return "null";
    }

    public void botaoPesquisar() {
       
    }

    public void botaoExcluir() {
        try{
            this.vendaSBean.excluir(this.venda);
            UteisJsf.addMensagemInfo("Excluir com sucesso.", "");
        }catch (Exception ex) {
            UteisJsf.addMensagemErro("Erro ao excluir", ex.getMessage());
        }
    }

    public String botaoEditar() {
       
        return "null";
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Venda> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(List<Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }

    public String getValorPesquisar() {
        return valorPesquisar;
    }

    public void setValorPesquisar(String valorPesquisar) {
        this.valorPesquisar = valorPesquisar;
    }

   
    

}
