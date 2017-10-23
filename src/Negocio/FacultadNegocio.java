/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.NivelIndicador;
import Modelo.Facultad;
import Modelo.Usuario;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shep
 */
public class FacultadNegocio {
    public Facultad facultad;
    
    public FacultadNegocio(){
        this.facultad = new Facultad();
    }
    public DefaultTableModel obtenerFacultads() {
        return this.facultad.obtenerFacultad();
    }
    public DefaultTableModel obtenerUsuario(int id) {
        return this.facultad.getFacultad(id);
    }
    public int registrarFacultad(String descripcion) {
        // No olvidar primero settear los datos
        this.facultad.setDescripcion(descripcion);
        return this.facultad.registrarFacultad();
    }
    public void eliminarFacultad(int id){
        this.facultad.eliminarFacultad(id);
    }
    public void modificarFacultad(int id,String descripcion) {
        this.facultad.setId(id);
        this.facultad.setDescripcion(descripcion);
        this.facultad.modificarFacultad();
    }
}
