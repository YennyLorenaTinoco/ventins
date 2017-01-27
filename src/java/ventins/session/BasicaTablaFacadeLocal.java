/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.session;

import java.util.List;
import javax.ejb.Local;
import ventins.entities.BasicaTabla;

/**
 *
 * @author lorena
 */
@Local
public interface BasicaTablaFacadeLocal {

    void create(BasicaTabla basicaTabla);

    void edit(BasicaTabla basicaTabla);

    void remove(BasicaTabla basicaTabla);

    BasicaTabla find(Object id);

    List<BasicaTabla> findAll();

    List<BasicaTabla> findRange(int[] range);

    int count();
    
}
