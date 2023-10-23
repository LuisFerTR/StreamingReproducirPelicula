package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la información de la reproducción de la película.
 */
public class InfoReproduccion {
    
    /* Tiempo rentado de la película */
    private Integer tiempo;
    
    /* Fecha de Inicio de la reproducción de la película */
    private String fechaInicio;

    @Override
    public String toString() {
        Gson gson = new Gson();
        //Convierte el objeto de la clase a un json
        String json = gson.toJson(this);
        return json;
        
    }

    /**
     * @return the tiempo
     */
    public Integer getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
