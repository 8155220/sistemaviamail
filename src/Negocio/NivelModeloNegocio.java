/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Indicador;
import Modelo.Modelo;
import Modelo.Usuario;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shep
 */
public class NivelModeloNegocio {
    public Modelo nivelModelo;
    
    public NivelModeloNegocio(){
        this.nivelModelo = new Modelo();
    }
    public DefaultTableModel obtenerNivelModelos() {
        return this.nivelModelo.obtenerNivelModelo();
    }
    public DefaultTableModel obtenerUsuario(int id) {
        return this.nivelModelo.getNivelModelo(id);
    }
    public int registrarNivelModelo(String descripcion) {
        // No olvidar primero settear los datos
        this.nivelModelo.setDescripcion(descripcion);
        return this.nivelModelo.registrarNivelModelo();
    }
    public void eliminarNivelModelo(int id){
        this.nivelModelo.eliminarNivelModelo(id);
    }
    public void modificarNivelModelo(int id,String descripcion) {
        this.nivelModelo.setId(id);
        this.nivelModelo.setDescripcion(descripcion);
        this.nivelModelo.modificarNivelModelo();
    }
}
