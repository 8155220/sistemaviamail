/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Modelo.DetalleUsuarioEncuesta;
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
public class DetalleUsuarioEncuestaNegocio {
    public DetalleUsuarioEncuesta detalleUsuarioEncuesta;
    
    public DetalleUsuarioEncuestaNegocio(){
        this.detalleUsuarioEncuesta = new DetalleUsuarioEncuesta();
    }
    public DefaultTableModel obtenerDetalleUsuarioEncuestas() {
        return this.detalleUsuarioEncuesta.obtenerDetalleUsuarioEncuestas();
    }
    public DefaultTableModel obtenerDetalleUsuarioEncuesta(int id) {
        return this.detalleUsuarioEncuesta.getDetalleUsuarioEncuesta(id);
    }
    public int registrarDetalleUsuarioEncuesta(int idencuesta, int idnivelmodelo,int idnivelindicador,int idusuario,int respuesta) {
        // No olvidar primero settear los datos
        this.detalleUsuarioEncuesta.setIdencuesta(idencuesta);
        this.detalleUsuarioEncuesta.setIdnivelmodelo(idnivelmodelo);
        this.detalleUsuarioEncuesta.setIdnivelindicador(idnivelindicador);
        this.detalleUsuarioEncuesta.setIdusuario(idusuario);
        this.detalleUsuarioEncuesta.setRespuesta(respuesta);
        return this.detalleUsuarioEncuesta.registrarDetalleUsuarioEncuesta();
    }
    public void eliminarDetalleUsuarioEncuesta(int id){
        this.detalleUsuarioEncuesta.eliminarDetalleUsuarioEncuesta(id);
    }
}
