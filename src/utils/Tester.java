/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Modelo.Conexion;
import java.util.Calendar;
import software.ModeloMadurezMail;

/**
 *
 * @author Shep
 */
public class Tester {
    
    
    public static void main(String[] args){
        ModeloMadurezMail sw = new ModeloMadurezMail();
        sw.processMessage("subject:OBTENERFACULTAD");
        //System.out.println("subject:REGISTRARUSUARIO [\"Pedro\",\"81646\",\"Docente\",\"2017-06-26\",\"m\",\"av cruz del sur\"]");
        //System.out.println(Calendar.getInstance().getTime().getDate());
        
        //Conexion c = Conexion.getInstancia();
        //c.abrirConexion();
    }
    
}
