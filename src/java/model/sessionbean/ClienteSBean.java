/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.sessionbean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.entidades.Cliente;
import model.entidades.Usuario;

/**
 *
 * @author Cirim
 */
@Stateless
public class ClienteSBean {

    @PersistenceContext(unitName = "sigePU")
    EntityManager em;
    
    public void salvar(Cliente cliente){
       em.merge(cliente); 
    }
    
    public void excluir(Cliente cliente){
        em.remove(em.find(Cliente.class,cliente.getId()));
    }
    
    public Cliente pesquisar(Long id){
        return em.find(Cliente.class, id);
    }
    
    public List<Cliente> pesquisar(String nome){
      List<Cliente> listaCliente;
      Query consulta = em.createNamedQuery("Cliente.findByName");
      consulta.setParameter("nome", nome + "%");
      listaCliente = consulta.getResultList();
      return listaCliente;
    }

}
