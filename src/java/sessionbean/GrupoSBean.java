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
import entidades.Grupo;


/**
 *
 * @author Cirim
 */
@Stateless
public class GrupoSBean  {

    @PersistenceContext(unitName = "Sige-bootstrapPU")
    private EntityManager em;
    
    public void salvar(Grupo grupo) throws Exception {
        try{
         em.merge(grupo);   
        } catch (Exception ex){
        throw new Exception("Error ao Salvar Grupo");
    }
    }
    
    public void excluir(Grupo grupo) {
        em.remove(em.find(Grupo.class, grupo.getId()));
    }
    
    public Grupo pesquisar(Long id) {
        return em.find(Grupo.class, id);        
    }
    
    public List<Grupo> pesquisar(String valorPesquisa) {
        List<Grupo> listaGrupo;
        Query consulta = em.createNamedQuery("Grupo.findByNome");
        consulta.setParameter("nome", valorPesquisa + "%");
        listaGrupo = consulta.getResultList();
        return listaGrupo;
    }
    

}
