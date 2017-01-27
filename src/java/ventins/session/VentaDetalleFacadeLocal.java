/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.session;

import java.util.List;
import javax.ejb.Local;
import ventins.entities.VentaDetalle;

/**
 *
 * @author lorena
 */
@Local
public interface VentaDetalleFacadeLocal {

    void create(VentaDetalle ventaDetalle);

    void edit(VentaDetalle ventaDetalle);

    void remove(VentaDetalle ventaDetalle);

    VentaDetalle find(Object id);

    List<VentaDetalle> findAll();

    List<VentaDetalle> findRange(int[] range);

    int count();
    
}
