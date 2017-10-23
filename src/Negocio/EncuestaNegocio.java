/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Modelo.Encuesta;
import Modelo.Usuario;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Shep
 */
//  private int id;
//    private String nombre;
//    private String ci;
//    private String direccion;
//    private String cargo;
//    private Date fechanacimiento;
//    private String sexo;
public class EncuestaNegocio {
    public Encuesta encuesta;
    
    public EncuestaNegocio(){
        this.encuesta = new Encuesta();
    }
    public DefaultTableModel obtenerEncuestas() {
        return this.encuesta.obtenerEncuestas();
    }
    public DefaultTableModel obtenerEncuesta(int id) {
        return this.encuesta.getEncuesta(id);
    }
    public int registrarEncuesta(int idfacultad, int idnivelmodelo) {
        // No olvidar primero settear los datos
        this.encuesta.setIdfacultad(idfacultad);
        this.encuesta.setIdnivelmodelo(idnivelmodelo);
        return this.encuesta.registrarEncuesta();
    }
    public void eliminarEncuesta(int id){
        this.encuesta.eliminarEncuesta(id);
    }
}
