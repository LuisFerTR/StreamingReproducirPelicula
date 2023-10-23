/**
 * 
 */
package com.soa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soa.dto.Renta;

/**
 * Capa de acceso a datos
 */
@Repository
public class RentasDao {
    
    /**
     * Objeto especializado en acceso a la BD.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Colocar la fecha de inicio en renta.
     * @param renta
     */
    public void actualizarFechaInicio(Renta renta, String fechaInicio) throws Exception {                
        
        jdbcTemplate.execute(String.format(
                "update rentas set fechainicio = '%s' where folio = '%s';",
                fechaInicio, renta.getFolio()));
    }


}
