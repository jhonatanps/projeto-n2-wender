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
import entidades.Usuario;

/**
 *
 * @author Cirim
 */
@Stateless
public class UsuarioSBean {

    @PersistenceContext(unitName = "Sige-bootstrapPU")
    EntityManager em;

    public void salvar(Usuario usuario) throws Exception {
        try {
            em.merge(usuario);

        } catch (Exception ex) {
            throw new Exception("Erro a salvar o usuario. - " + ex.getMessage());
        }
    }

    public void excluir(Usuario usuario) {
        em.remove(em.find(Usuario.class, usuario.getId()));
    }

    public Usuario pesquisar(Long id) {
        return em.find(Usuario.class, id);
    }

    public List<Usuario> pesquisar(String nome) {
        List<Usuario> listaUsuarios;
        Query consulta = em.createNamedQuery("Usuario.findByNome");
        consulta.setParameter("nome", nome + "%");
        listaUsuarios = consulta.getResultList();
        return listaUsuarios;
    }

    public Usuario logar(String userNome, String senha) throws Exception {
        try {
            Query consulta = em.createNamedQuery("Usuario.findByNameSenha");
            consulta.setParameter("userName", userNome);
            consulta.setParameter("senha", senha);
            return (Usuario) consulta.getSingleResult();
        } catch (Exception ex) {
            throw new Exception("Usuario ou senha e invalido");
        }
    }
}
