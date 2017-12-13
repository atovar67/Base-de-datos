/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bufete.database;

import java.util.HashMap;
import javax.sql.DataSource;

/**
 *
 * @author Alfonso Tovar
 */
public class Sistema {
    
    private static HashMap<String,DataSource> sistema = new HashMap();

    public DataSource put(String key, DataSource value) {
        return sistema.put(key, value);
    }

    public DataSource get(Object key) {
        return sistema.get(key);
    }
    
}
