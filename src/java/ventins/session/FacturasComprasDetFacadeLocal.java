/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.session;

import java.util.List;
import javax.ejb.Local;
import ventins.entities.FacturasComprasDet;

/**
 *
 * @author lorena
 */
@Local
public interface FacturasComprasDetFacadeLocal {

    void create(FacturasComprasDet facturasComprasDet);

    void edit(FacturasComprasDet facturasComprasDet);

    void remove(FacturasComprasDet facturasComprasDet);

    FacturasComprasDet find(Object id);

    List<FacturasComprasDet> findAll();

    List<FacturasComprasDet> findRange(int[] range);

    int count();
    
}
