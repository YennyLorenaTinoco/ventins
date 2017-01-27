/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.session;

import java.util.List;
import javax.ejb.Local;
import ventins.entities.FacturasCompra;

/**
 *
 * @author lorena
 */
@Local
public interface FacturasCompraFacadeLocal {

    void create(FacturasCompra facturasCompra);

    void edit(FacturasCompra facturasCompra);

    void remove(FacturasCompra facturasCompra);

    FacturasCompra find(Object id);

    List<FacturasCompra> findAll();

    List<FacturasCompra> findRange(int[] range);

    int count();
    
}
