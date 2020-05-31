/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entidades.Grupo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entidades.Produto;


/**
 *
 * @author Cirim
 */
@Stateless
public class ProdutoSBean {

    @PersistenceContext(unitName = "Sige-bootstrapPU")
    EntityManager em;
    
    public void salvar(Produto produto){
       em.merge(produto); 
    }
    
    public void excluir(Produto produto){
        em.remove(em.find(Produto.class,produto.getId()));
    }
    
    public Produto pesquisar(Long id){
        return em.find(Produto.class, id);
    }
    
    public List<Produto> pesquisar(String nome){
      List<Produto> listaProduto;
      Query consulta = em.createNamedQuery("Produto.findByName");
      consulta.setParameter("nome", nome + "%");
      listaProduto = consulta.getResultList();
      return listaProduto;
    }
    
    public List<Produto> pesquisar(Grupo grupo){
      List<Produto> listaProduto;
      Query consulta = em.createNamedQuery("Produto.findByGrupo");
      consulta.setParameter("grupo", grupo + "%");
      listaProduto = consulta.getResultList();
      return listaProduto;
    }

}
