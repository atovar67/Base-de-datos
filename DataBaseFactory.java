/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bufete.database;

import com.bufete.exception.BufeteException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

import java.util.Properties;
import java.util.List;
import java.util.HashMap;


import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Connection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerConnectionPoolDataSource;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;          
import org.jdom2.JDOMException;    
import org.jdom2.input.SAXBuilder; 


/**
 *
 * @author Alfonso Tovar
 */
public class DataBaseFactory {
    
    private static HashMap<Oficina,DataBase> informacion;
    private static HashMap<Oficina,DataSource> dataSource;
    
    public static Connection get_connection(int oficina) throws BufeteException {
        return get_connection(oficina,"MYSQL");
    }

    public static Connection get_connection(int oficina,String tipo) throws BufeteException {
        Connection con=null;
        BufeteException bf=null;
        int i=0;
        while (i<5) {
            try {
                if (informacion==null) {
                    getInformation();
                    dataSource = new HashMap();
                    Iterator itr=informacion.keySet().iterator();
                    while (itr.hasNext()) {
                        Oficina of=(Oficina)itr.next();
                        if (informacion.get(of).getDataBaseType().equals("MYSQL")) {
                            dataSource.put(of, getMySQLDataSource(of.getOficina()));
                        } 
                        else {
                            dataSource.put(of, getSQLServerDataSource(of.getOficina()));
                        }                        
                    }
                }
                con=dataSource.get(new Oficina(oficina,tipo)).getConnection();
                i=5;
            } catch (Exception e) {
                e.printStackTrace();
                bf =new BufeteException(e.toString());
                i++;
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException ie) {
                    
                }
            }
        }
        if (con==null) {
            throw bf;
        }
        return con;
    }
        
    private static DataSource getMySQLDataSource(int oficina) {
        DataBase db=informacion.get(new Oficina(oficina,"MYSQL"));
	MysqlDataSource mysqlDS = null;
        mysqlDS = new MysqlDataSource();
	mysqlDS.setURL("jdbc:mysql://"+db.getIP()+":"+db.getPuerto()+"/"+db.getDataBaseName());
	mysqlDS.setUser(db.getUsuario());
	mysqlDS.setPassword(db.getPassword());
	return mysqlDS;
    }

    private static DataSource getSQLServerDataSource(int oficina) {
        DataBase db=informacion.get(new Oficina(oficina,"SQLSERVER"));
	SQLServerConnectionPoolDataSource sqlDS = null;
        sqlDS = new SQLServerConnectionPoolDataSource();
	sqlDS.setURL("jdbc:sqlserver://"+db.getIP()+"\\"+db.getDataBaseName()+":"+db.getPuerto());
	sqlDS.setUser(db.getUsuario());
	sqlDS.setPassword(db.getPassword());
	return sqlDS;
    }
    
    private static void getInformation() throws BufeteException {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( "./BasedeDatos.xml" );
        informacion = new HashMap();
        try {
            Document document = (Document) builder.build( xmlFile );
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren();
            for ( int i = 0; i < list.size(); i++ ) {
                DataBase db = new DataBase();
                
                Element root = (Element) list.get(i);
 
                db.setIP(root.getChildTextTrim("IP_Host"));
                db.setPuerto(root.getChildTextTrim("Puerto"));
                db.setUsuario(root.getChildTextTrim("Usuario"));
                db.setPassword(root.getChildTextTrim("Password"));
                db.setDataBaseName(root.getChildTextTrim("DatabaseName"));
                db.setDataBaseType(root.getChildTextTrim("TipoBasedeDatos"));
                db.setClaveAduana(root.getChildTextTrim("Oficina"));
                db.setSistema(root.getChildTextTrim("Sistema"));
                
                informacion.put(new Oficina(Integer.parseInt(db.getClaveAduana()),db.getDataBaseType()), db);
            }
        }catch ( IOException io ) {
            throw new BufeteException(io.getCause());
        }catch ( JDOMException jdomex ) {
            throw new BufeteException(jdomex.getMessage());
        } catch (NumberFormatException nfe) {
            throw new BufeteException(nfe.getMessage());
        }
    }
}
