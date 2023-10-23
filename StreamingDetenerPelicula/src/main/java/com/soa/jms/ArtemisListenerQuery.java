/**
 * 
 */
package com.soa.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.soa.business.DetenerPeliculaBusiness;
import com.soa.dto.Respuesta;
import com.soa.dto.InfoReproduccion;

/**
 * Class for receiving messages in an artemis queue
 */
@Component
public class ArtemisListenerQuery {
    
    @Autowired
    private DetenerPeliculaBusiness business;
    
    @Autowired
    private JmsSender sender;

    @Value("${queue.name.out}")
    private String outQueueName;

    @Value("${queue.name.next}")
    private String nextQueueName;
    
    /**
     * Recibir datos de reproducción de película
     * @param message JSON con tiempo y fechaInicio
     */
    @JmsListener(destination = "${queue.name.in}")
    public void receive(String message) {
        System.out.println(String.format("Received message: %s", message));        
        Gson gson = new Gson();
        InfoReproduccion infoReproduccion = gson.fromJson(message, InfoReproduccion.class);
        System.out.println(infoReproduccion);
        Respuesta respuesta = business.detenerReproduccion(infoReproduccion);
        String colaSalida = nextQueueName;
        /*
         * if(respuesta.getFechaInicio() != null) { colaSalida = nextQueueName; } else {
         * colaSalida = outQueueName; }
         */
        System.out.println("Resultado de la consulta: " + respuesta);
        try {
            sender.sendMessage(respuesta.toString(), colaSalida);
            System.out.println(String.format("Mensaje enviado: %s", 
                    respuesta.toString()));
        } catch(Exception e) {
            e.printStackTrace();
        }       
        
    }
}
