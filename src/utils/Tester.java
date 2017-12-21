/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Modelo.Conexion;
import Modelo.Usuario;
import java.util.Calendar;
import sockets.ClienteSMTP;
import software.ModeloMadurezMail;

/**
 *
 * @author Shep
 */
public class Tester {
    
    
    public static void main(String[] args){
        ModeloMadurezMail sw = new ModeloMadurezMail();
        
        //MODIFICARUSUARIO [1003,"PEPEMODIFICADO","linares","65456465",1,1]
        //////USUARIOS
        //REGISTRARUSUARIO ["PEPE","pepe@gmail.com","123456","linares","65456465",1,1]
        //sw.processMessage("subject:REGISTRARUSUARIO [\"PEPE\",\"pepe@gmail.com\",\"123456\",\"linares\",\"65456465\",1,1] "); 
       // sw.processMessage("subject:MODIFICARUSUARIO [1003,\"PEPEMODIFICADO\",\"linares\",\"65456465\",1,1] ");                  
        //sw.processMessage("subject:ELIMINARUSUARIO [1003]");                                                                     
        //////MODELO
       // sw.processMessage("subject:OBTENERMODELO");
       // sw.processMessage("subject:REGISTRARMODELO [\"MODELO 1\"] "); //REGISTRAR
        //sw.processMessage("subject:MODIFICARMODELO [7,\"PPEPE\"] ");                  //MODIFICAR
        //sw.processMessage("subject:ELIMINARMODELO [7]");                                                                     
        
        //////FACULTAD
        sw.processMessage("subject:OBTENERFACULTAD");
        //sw.processMessage("subject:REGISTRARFACULTAD [\"FACULTAD 1\"] "); //REGISTRAR
        //sw.processMessage("subject:MODIFICARFACULTAD [18,\"PPEPE\"] ");                  //MODIFICAR
       // sw.processMessage("subject:ELIMINARFACULTAD [18]");                                                                    
        //////TIPOUSUARIO
        sw.processMessage("subject:OBTENERTIPOUSUARIO");
        //sw.processMessage("subject:REGISTRARTIPOUSUARIO [\"TIPOUSUARIO 1\"] "); //REGISTRAR
        //sw.processMessage("subject:MODIFICARTIPOUSUARIO [4,\"PPEPE\"] ");                  //MODIFICAR
       // sw.processMessage("subject:ELIMINARTIPOUSUARIO [4]");                                                                    
        //////ENCUESTA
        sw.processMessage("subject:OBTENERENCUESTA");
        //sw.processMessage("subject:REGISTRARENCUESTA [4,\"2017-12-19\",\"2017-12-25\",1005,3,4,5,6,7,8,9,10,11] "); 
       // sw.processMessage("subject:ELIMINARENCUESTA [19]");                                                              
        
       //////INDICADOR
        sw.processMessage("subject:OBTENERINDICADOR");
       // sw.processMessage("subject:REGISTRARINDICADOR [\"INDICADOR 1\",\"descripcionmetrica\",3] "); //REGISTRAR
       //w.processMessage("subject:MODIFICARINDICADOR [31,\"PPEPE\",\"des\",5] ");                  //MODIFICAR
        //sw.processMessage("subject:ELIMINARINDICADOR [31]");    
       //RESULTADOS
       sw.processMessage("subject:OBTENERUSUARIOENCUESTA [1]"); //->Listade usuarios de la encuesta 1
       
       sw.processMessage("subject:OBTENERRESULTADOUSUARIO [1,584]");//->lista rESPUESTAS encuesta 1 usuario 15
       
       
        //System.out.println("subject:REGISTRARUSUARIO [\"Pedro\",\"81646\",\"Docente\",\"2017-06-26\",\"m\",\"av cruz del sur\"]");
        //System.out.println(Calendar.getInstance().getTime().getDate());
        
        //Conexion c = Conexion.getInstancia();
        //c.abrirConexion();
        
        
         //ClienteSMTP.sendHtmlMail("alfredochsoliz@gmail.com", "Encuesta Pendiente", Utils.encuestaHtml());
    }
    
}
