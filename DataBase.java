/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bufete.database;

import com.bufete.exception.BufeteException;

/**
 *
 * @author Alfonso Tovar
 */
public class DataBase {

    private String claveAduana;
    private String IP;
    private String puerto;
    private String dataBaseName;
    private String dataBaseType;
    private String usuario;
    private String password;
    private String sistema;

    /**
     * Get the value of sistema
     *
     * @return the value of sistema
     */
    public String getSistema() {
        return sistema;
    }

    /**
     * Set the value of sistema
     *
     * @param sistema new value of sistema
     */
    public void setSistema(String sistema) throws BufeteException {
        if (!sistema.equals("CAAAREM3")) {
            if (!sistema.equals("ADUASIS")) {
                if (!sistema.equals("SATO")) {
                    if (!sistema.equals("Reg001")) {
                        throw new BufeteException("El parametro de Sistema unicamente debe ser 'CAAAREM3' ' ADUASIS' o 'SATO'");
                    }
                }
            }
        }
        this.sistema = sistema;
    }


    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Get the value of usuario
     *
     * @return the value of usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Set the value of usuario
     *
     * @param usuario new value of usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    /**
     * Get the value of dataBaseType
     *
     * @return the value of dataBaseType
     */
    public String getDataBaseType() {
        return dataBaseType;
    }

    /**
     * Set the value of dataBaseType
     *
     * @param dataBaseType new value of dataBaseType
     */
    public void setDataBaseType(String dataBaseType) throws BufeteException {
        if (dataBaseType.equals("MYSQL")) {
            this.dataBaseType = dataBaseType;
        } else {
            if (dataBaseType.equals("SQLSERVER")) {
                this.dataBaseType = dataBaseType;
            } else {
                throw new BufeteException("Valor Invalido, unicamente son validos MYSQL o SQLSErVER");
            }
        }
    }


    /**
     * Get the value of dataBaseName
     *
     * @return the value of dataBaseName
     */
    public String getDataBaseName() {
        return dataBaseName;
    }

    /**
     * Set the value of dataBaseName
     *
     * @param dataBaseName new value of dataBaseName
     */
    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }


    /**
     * Get the value of claveAduana
     *
     * @return the value of claveAduana
     */
    public String getClaveAduana() {
        return claveAduana;
    }

    /**
     * Set the value of claveAduana
     *
     * @param claveAduana new value of claveAduana
     */
    public void setClaveAduana(String claveAduana) throws BufeteException {
        try {
            int aduana=Integer.parseInt(claveAduana);        
        } catch (Exception e) {
            throw new BufeteException("La oficina debe ser un valor numerico correspondienta a la clave de la aduana conforma al anexo 22 de las RGCE");
        }
        this.claveAduana = claveAduana;
    }

    /**
     * Get the value of puerto
     *
     * @return the value of puerto
     */
    public String getPuerto() {
        return puerto;
    }

    /**
     * Set the value of puerto
     *
     * @param puerto new value of puerto
     */
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }


    /**
     * Get the value of IP
     *
     * @return the value of IP
     */
    public String getIP() {
        return IP;
    }

    /**
     * Set the value of IP
     *
     * @param IP new value of IP
     */
    public void setIP(String IP) {
        this.IP = IP;
    }

    
}
