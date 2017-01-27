/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.session;

import java.util.List;
import javax.ejb.Local;
import ventins.entities.BasicaTipo;

/**
 *
 * @author lorena
 */
@Local
public interface BasicaTipoFacadeLocal {

    void create(BasicaTipo basicaTipo);

    void edit(BasicaTipo basicaTipo);

    void remove(BasicaTipo basicaTipo);

    BasicaTipo find(Object id);

    List<BasicaTipo> findAll();

    List<BasicaTipo> findRange(int[] range);

    int count();
    
}
