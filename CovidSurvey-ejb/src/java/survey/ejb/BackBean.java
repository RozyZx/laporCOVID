/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author RozyZzx
 */
@Stateless
@LocalBean
public class BackBean {
    private int SUCCESS = 1, FAIL = 0;
    
    public String decide(String name, String id, String addr, String contact, String suspect, String add){
        if(initDB() == SUCCESS){
            try {
                String sql = "insert into lapor values(?,?,?,?,?,?)";
                pst = c.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, id);
                pst.setString(3, addr);
                pst.setString(4, contact);
                pst.setString(5, suspect);
                pst.setString(6, add);
                pst.execute();
                
                return "yes";
            } catch (SQLException ex) {}
        }
        return "no";
    }
    
    //<editor-fold desc="DB init">
    /*
    CREATE TABLE lapor(
        name VARCHAR(32) NOT NULL,
        id VARCHAR(32) NOT NULL,
        addr VARCHAR(128) NOT NULL,
        contact VARCHAR(128) NOT NULL,
        suspect VARCHAR(92) NOT NULL,
        addi VARCHAR(256) NOT NULL);
    */
    
    private final String password = "rsbk_survey";
    private final String user = "rsbk_survey";
    private final String database_name = "rsbk_survey";
    private final String url_base = "db4free.net:3306/";
    private PreparedStatement pst;
    private Connection c;
    Statement script;
    
    private int initDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            c = DriverManager.getConnection(
                    "jdbc:mysql://"+
                            url_base+
                            database_name+
                            "?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false",
                    user,
                    password);
            script = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            
            System.out.println("Success");
            return SUCCESS;
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(BackBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FAIL;
    }
    //</editor-fold>
}
