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
public class ReproducirPeliculaBusiness {

    /** Objeto de acceso a datos */
    @Autowired
    private RentasDao rentasDao;

    /**
     * Calcula la fecha de inicio de reproducción de una película rentada.
     * 
     * @param renta
     * @return
     */
    public Respuesta iniciarReproduccion(Renta renta) {

        Respuesta respuesta = new Respuesta();
        try {
            LocalDateTime inicio = LocalDateTime.now();
            Timestamp timestampInicio = Timestamp.valueOf(inicio);
            String fechaInicio = timestampInicio.toString();
            Long tiempoInicio = timestampInicio.getTime();
            Long limite = Long.valueOf(renta.getTiempo().longValue() * 1000);
            
            String message = "Inicio de reproducción de película EXITOSO";

            respuesta.setMessage(message);
            respuesta.setFechaInicio(fechaInicio);
            respuesta.setTiempo(renta.getTiempo());

            rentasDao.actualizarFechaInicio(renta, fechaInicio);

            Long tiempoAhora = Long.valueOf(0);
            System.out.println("Inicio de reproducción de película EXITOSO");

            do {
                LocalDateTime ahora = LocalDateTime.now();
                Timestamp timestampAhora = Timestamp.valueOf(ahora);
                tiempoAhora = timestampAhora.getTime();
                System.out.println("Reproduciendo película...");

                Thread.sleep(1000);
            } while (tiempoAhora - tiempoInicio < limite);

            System.out.println("Tiempo de renta superado.");
            System.out.println("Se detuvo la reproducción de la película.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error en la BD al actualizar fechaInicio de renta");
        }
        return respuesta;
    }
}
