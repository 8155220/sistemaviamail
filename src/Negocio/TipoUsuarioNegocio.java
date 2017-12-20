/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.TipoUsuario;
import Modelo.Usuario;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shep
 */
public class TipoUsuarioNegocio {
    public TipoUsuario tipoUsuario;
    
    public TipoUsuarioNegocio(){
        this.tipoUsuario = new TipoUsuario();
    }
    public DefaultTableModel obtenerTipoUsuarios() {
        return this.tipoUsuario.obtenerTipoUsuario();
    }
    public DefaultTableModel obtenerUsuario(int id) {
        return this.tipoUsuario.getTipoUsuario(id);
    }
    public int registrarTipoUsuario(String descripcion) {
        // No olvidar primero settear los datos
        this.tipoUsuario.setDescripcion(descripcion);
        return this.tipoUsuario.registrarTipoUsuario();
    }
    public void eliminarTipoUsuario(int id){
        this.tipoUsuario.eliminarTipoUsuario(id);
    }
    public void modificarTipoUsuario(int id,String descripcion) {
        this.tipoUsuario.setId(id);
        this.tipoUsuario.setDescripcion(descripcion);
        this.tipoUsuario.modificarTipoUsuario();
    }
}
