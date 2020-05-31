/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entidades.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entidades.Venda;
import java.util.Date;


/**
 *
 * @author Cirim
 */
@Stateless
public class VendaSBean  {

    @PersistenceContext(unitName = "Sige-bootstrapPU")
    private EntityManager em;
    
    public void salvar(Venda venda) throws Exception {
        try{
         em.merge(venda);   
        } catch (Exception ex){
        throw new Exception("Error ao Salvar Venda");
    }
    }
    
    public void excluir(Venda venda) {
        em.remove(em.find(Venda.class, venda.getId()));
    }
    
    public Venda pesquisar(Long id) {
        return em.find(Venda.class, id);        
    }
    
    public List<Venda> pesquisar(Cliente cliente) throws Exception {
        try {
            Query consulta = em.createNamedQuery("Venda.findByCliente");
            consulta.setParameter("cliente", cliente);
            return consulta.getResultList();
        } catch (Exception e) {
            throw new Exception("Erro ao pesquisar a Venda por Cliente.");
        }
    }
    
    public List<Venda> pesquisar(Date dataVenda) throws Exception {
        try {
            Query consulta = em.createNamedQuery("Venda.findByDataVenda");
            consulta.setParameter("data", dataVenda);
            return consulta.getResultList();
        } catch (Exception e) {
            throw new Exception("Erro ao pesquisar pela Data da Venda.");
        }
    }
    

}
