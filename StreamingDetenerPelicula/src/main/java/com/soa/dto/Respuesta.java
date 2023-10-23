package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la información necesaria para la siguiente cola.
 */
public class Respuesta {

    /*Mensaje de respuesta*/
    private String message;
    
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        //Convierte el objeto de la clase a un json
        String json = gson.toJson(this);
        return json;
        
    }
}
