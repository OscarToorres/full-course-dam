/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package es.leliadoura.ad.mariabd;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam220
 */
public class MariaBD {

    public static void main(String[] args) {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://192.168.56.101:3306/Prueba";

            con = DriverManager.getConnection(url, "aduser", "abc123.");

        } catch (SQLException ex) {
            Logger.getLogger(MariaBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MariaBD.class.getName()).log(Level.SEVERE, null, ex);
        }

//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setUser("aduser");
//        dataSource.setPassword("abc123.");
//        //Para un servidor de verdad habria que poner su url real, como es en local se pone la ip
//        dataSource.setServerName("192.168.56.101"); 
//        dataSource.setPort(3306);
//        dataSource.setDatabaseName("Prueba");
//
//        try {
//            con = dataSource.getConnection();
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(MariaBD.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try {
            Statement stmt = con.createStatement();

            String tabla = "CREATE TABLE Modulos "
                    + "(nombre VARCHAR(20), horas INTEGER, codigo VARCHAR(3) primary key)";

            String insert1 = "INSERT INTO `Modulos`(`nombre`, `horas`, `codigo`) "
                    + " VALUES ('DAM',800,'001')";

            String insert2 = "INSERT INTO `alumno`(`nombre`, `apellidos`, `edad`, `dni`) "
                    + " VALUES ('luis','lustres',32,'3A')";

            String update = " UPDATE `alumno` SET "
                    + " `nombre`= 'alvarito',"
                    + " `apellidos`= 'ribeiro',"
                    + " `edad`=22"
                    + " WHERE dni = '1A'";

            stmt.executeUpdate(insert1);
        } catch (SQLException ex) {
            Logger.getLogger(MariaBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MariaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Selects 
        String query = "SELECT * FROM Alumnos ";

    }
}