/**
 * 
 */
package com.soa.business;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.soa.dto.Respuesta;
import com.soa.dto.InfoReproduccion;

/**
 * Capa de negocio que consulta usuarios
 * 
 */
@Component
public class DetenerPeliculaBusiness {
    
    /**
     * Detiene la reproducción de la película
     * @param infoReproduccion
     * @return Respuesta 
     */
    public Respuesta detenerReproduccion(InfoReproduccion infoReproduccion) {
        
        Respuesta respuesta = new Respuesta();
                               
        Timestamp timestampInicio = Timestamp.valueOf(infoReproduccion.getFechaInicio());
        Long tiempoInicio = timestampInicio.getTime();
        Long limite = Long.valueOf(infoReproduccion.getTiempo().longValue() * 1000);
        Long tiempoAhora = Long.valueOf(0);
        
        do {
            LocalDateTime ahora = LocalDateTime.now();
            Timestamp timestampAhora = Timestamp.valueOf(ahora);
            tiempoAhora = timestampAhora.getTime();
        } while (tiempoAhora - tiempoInicio < limite);
        
        respuesta.setMessage("Se detuvo la reproducción de la película");
          
        return respuesta;        
    }
}
