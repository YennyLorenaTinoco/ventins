/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.session;

import java.util.List;
import javax.ejb.Local;
import ventins.entities.Cajas;

/**
 *
 * @author lorena
 */
@Local
public interface CajasFacadeLocal {

    void create(Cajas cajas);

    void edit(Cajas cajas);

    void remove(Cajas cajas);

    Cajas find(Object id);

    List<Cajas> findAll();

    List<Cajas> findRange(int[] range);

    int count();
    
}
