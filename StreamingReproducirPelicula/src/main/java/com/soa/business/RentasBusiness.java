/**
 * 
 */
package com.soa.business;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.RentasDao;
import com.soa.dto.Respuesta;
import com.soa.dto.Renta;

/**
 * Capa de negocio que coloca la fecha de inicio de reproducción a la renta.
 * 
 */
@Component
public class RentasBusiness {

    /**Objeto de acceso a datos*/
    @Autowired
    private RentasDao rentasDao;
    
    /**
     * Calcula la fecha de inicio de reproducción de una película rentada.
     * @param renta
     * @return
     */
    public Respuesta iniciarReproduccion(Renta renta) {
        
        Respuesta respuesta = new Respuesta();
        try {                        
            LocalDateTime ahora = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(ahora);
            String fechaInicio = timestamp.toString();
            
            respuesta.setMessage("Inicio de reproducción de película EXITOSO");
            respuesta.setFechaInicio(fechaInicio);
            respuesta.setTiempo(renta.getTiempo());
            
            rentasDao.actualizarFechaInicio(renta, fechaInicio);             
        } catch(Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error en la BD al actualizar fechaInicio de renta");
        }            
            return respuesta;        
    }
}
