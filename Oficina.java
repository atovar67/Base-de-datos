/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bufete.database;

import java.util.Objects;

/**
 *
 * @author Alfonso Tovar
 */
public class Oficina {

    private int oficina;
    private String basedeDatos;

    public Oficina(int oficina, String basedeDatos) {
        this.oficina = oficina;
        this.basedeDatos = basedeDatos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.oficina;
        hash = 37 * hash + Objects.hashCode(this.basedeDatos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oficina other = (Oficina) obj;
        if (this.oficina != other.oficina) {
            return false;
        }
        if (!Objects.equals(this.basedeDatos, other.basedeDatos)) {
            return false;
        }
        return true;
    }

    /**
     * Get the value of basedeDatos
     *
     * @return the value of basedeDatos
     */
    public String getBasedeDatos() {
        return basedeDatos;
    }

    /**
     * Set the value of basedeDatos
     *
     * @param basedeDatos new value of basedeDatos
     */
    public void setBasedeDatos(String basedeDatos) {
        this.basedeDatos = basedeDatos;
    }

    /**
     * Get the value of oficina
     *
     * @return the value of oficina
     */
    public int getOficina() {
        return oficina;
    }

    /**
     * Set the value of oficina
     *
     * @param oficina new value of oficina
     */
    public void setOficina(int oficina) {
        this.oficina = oficina;
    }
    
}
