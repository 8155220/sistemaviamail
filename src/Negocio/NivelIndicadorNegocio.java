/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.NivelIndicador;
import Modelo.Usuario;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shep
 */
public class NivelIndicadorNegocio {
    public NivelIndicador nivelIndicador;
    
    public NivelIndicadorNegocio(){
        this.nivelIndicador = new NivelIndicador();
    }
    public DefaultTableModel obtenerNivelIndicadors() {
        return this.nivelIndicador.obtenerNivelIndicador();
    }
    public DefaultTableModel obtenerUsuario(int id) {
        return this.nivelIndicador.getNivelIndicador(id);
    }
    public int registrarNivelIndicador(String descripcion,String metrica,int idnivelmodelo) {
        // No olvidar primero settear los datos
        this.nivelIndicador.setDescripcion(descripcion);
        this.nivelIndicador.setMetrica(metrica);
        this.nivelIndicador.setIdnivelmodelo(idnivelmodelo);
        return this.nivelIndicador.registrarNivelIndicador();
    }
    public void eliminarNivelIndicador(int id){
        this.nivelIndicador.eliminarNivelIndicador(id);
    }
    public void modificarNivelIndicador(int id,String descripcion,String metrica,int idnivelmodelo){
        this.nivelIndicador.setId(id);
        this.nivelIndicador.setDescripcion(descripcion);
        this.nivelIndicador.setMetrica(metrica);
        this.nivelIndicador.setIdnivelmodelo(idnivelmodelo);
        this.nivelIndicador.modificarNivelIndicador();
    }
}
