/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entidades.Fornecedor;


/**
 *
 * @author Cirim
 */
@Stateless
public class FornecedorSBean {

    @PersistenceContext(unitName = "Sige-bootstrapPU")
    EntityManager em;
    
    public void salvar(Fornecedor fornecedor){
       em.merge(fornecedor); 
    }
    
    public void excluir(Fornecedor fornecedor){
        em.remove(em.find(Fornecedor.class,fornecedor.getId()));
    }
    
    public Fornecedor pesquisar(Long id){
        return em.find(Fornecedor.class, id);
    }
    
    public List<Fornecedor> pesquisar(String nome){
      List<Fornecedor> listaFornecedor;
      Query consulta = em.createNamedQuery("Fornecedor.findByName");
      consulta.setParameter("nome", nome + "%");
      listaFornecedor = consulta.getResultList();
      return listaFornecedor;
    }

}
