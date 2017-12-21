/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Modelo.Encuesta;
import Modelo.Usuario;
import utils.Utils;
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
    public int registrarEncuesta(int idfacultad, String fechainicio,String fechafin,int idusuario1,int idusuario2,int idusuario3,int idusuario4,int idusuario5,int idusuario6,int idusuario7,int idusuario8,int idusuario9,int idusuario10) {
        // No olvidar primero settear los datos
        this.encuesta.setIdfacultad(idfacultad);
        this.encuesta.setFechainicio(Utils.convertirFechas(fechainicio));
        this.encuesta.setFechafin(Utils.convertirFechas(fechainicio));
        this.encuesta.setIdusuario1(idusuario1);
        this.encuesta.setIdusuario2(idusuario2);
        this.encuesta.setIdusuario3(idusuario3);
        this.encuesta.setIdusuario4(idusuario4);
        this.encuesta.setIdusuario5(idusuario5);
        this.encuesta.setIdusuario6(idusuario6);
        this.encuesta.setIdusuario7(idusuario7);
        this.encuesta.setIdusuario8(idusuario8);
        this.encuesta.setIdusuario9(idusuario9);
        this.encuesta.setIdusuario10(idusuario10);
        
        return this.encuesta.registrarEncuesta();
    }
    public void eliminarEncuesta(int id){
        this.encuesta.eliminarEncuesta(id);
    }
    
    public DefaultTableModel obtenerUsuarioEncuesta(int idencuesta){
        return this.encuesta.obtenerUsuarioEncuesta(idencuesta);
    }
    public DefaultTableModel obtenerResultadoUsuario(int idencuesta,int idusuario){
        return this.encuesta.obtenerResultadoUsuario(idencuesta,idusuario);
    }
}
