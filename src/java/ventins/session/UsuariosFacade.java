/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ventins.entities.Usuarios;
import javax.persistence.Query;

/**
 *
 * @author lorena
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "ventinsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public Usuarios getLogin(Usuarios usu) {
        try {
            Query q = em.createQuery("SELECT u.usuId FROM Usuarios u WHERE u.usuLogin=:login");
            q.setParameter("login", usu.getUsuLogin());
            return (Usuarios) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("ERROR GETLOGIN: " + e.toString());
            return null;
        }
    }
}
