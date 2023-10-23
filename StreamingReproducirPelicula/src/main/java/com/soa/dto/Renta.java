package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la información de la solicitud de renta ACEPTADA Y COBRADA.
 */
public class Renta {
    
    /* Folio de renta */
    private Integer folio;
    
    /* Tiempo en segundos por el cual se rentó la película */
    private Integer tiempo;
    
    /* Id de la película renta */
    private Integer idPelicula;
    
    /* Id del usuario que rentó la película */
    private Integer idUsuario;
    
    /* Total cobrado de la renta */
    private Double total;

    @Override
    public String toString() {
        Gson gson = new Gson();
        //Convierte el objeto de la clase a un json
        String json = gson.toJson(this);
        return json;
        
    }

    /**
     * @return the folio
     */
    public Integer getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(Integer folio) {
        this.folio = folio;
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
     * @return the idPelicula
     */
    public Integer getIdPelicula() {
        return idPelicula;
    }

    /**
     * @param idPelicula the idPelicula to set
     */
    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }
}
