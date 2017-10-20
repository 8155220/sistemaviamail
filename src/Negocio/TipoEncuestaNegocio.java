/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.TipoEncuesta;
import Modelo.Usuario;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shep
 */
public class TipoEncuestaNegocio {
    public TipoEncuesta tipoEncuesta;
    
    public TipoEncuestaNegocio(){
        this.tipoEncuesta = new TipoEncuesta();
    }
    public DefaultTableModel obtenerTipoEncuestas() {
        return this.tipoEncuesta.obtenerTipoEncuesta();
    }
    public DefaultTableModel obtenerUsuario(int id) {
        return this.tipoEncuesta.getTipoEncuesta(id);
    }
    public int registrarTipoEncuesta(String descripcion) {
        // No olvidar primero settear los datos
        this.tipoEncuesta.setDescripcion(descripcion);
        return this.tipoEncuesta.registrarTipoEncuesta();
    }
    public void eliminarTipoEncuesta(int id){
        this.tipoEncuesta.eliminarTipoEncuesta(id);
    }
    public void modificarTipoEncuesta(int id,String descripcion) {
        this.tipoEncuesta.setId(id);
        this.tipoEncuesta.setDescripcion(descripcion);
        this.tipoEncuesta.modificarTipoEncuesta();
    }
}
