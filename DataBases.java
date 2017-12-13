/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import com.bufete.database.DataBaseFactory;

/**
 *
 * @author Alfonso Tovar
 */
public class DataBases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DataBaseFactory.get_connection(01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
