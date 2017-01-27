/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ventins.entities.BasicaTabla;

/**
 *
 * @author lorena
 */
@Stateless
public class BasicaTablaFacade extends AbstractFacade<BasicaTabla> implements BasicaTablaFacadeLocal {

    @PersistenceContext(unitName = "ventinsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BasicaTablaFacade() {
        super(BasicaTabla.class);
    }
    
}
