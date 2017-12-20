/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Indicador;
import Modelo.Usuario;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shep
 */
public class IndicadorNegocio {
    public Indicador nivelIndicador;
    
    public IndicadorNegocio(){
        this.nivelIndicador = new Indicador();
    }
    public DefaultTableModel obtenerIndicadors() {
        return this.nivelIndicador.obtenerIndicador();
    }
    public DefaultTableModel obtenerUsuario(int id) {
        return this.nivelIndicador.getIndicador(id);
    }
    public int registrarIndicador(String descripcion,String metrica,int idnivelmodelo) {
        // No olvidar primero settear los datos
        this.nivelIndicador.setDescripcion(descripcion);
        this.nivelIndicador.setMetrica(metrica);
        this.nivelIndicador.setIdnivelmodelo(idnivelmodelo);
        return this.nivelIndicador.registrarIndicador();
    }
    public void eliminarIndicador(int id){
        this.nivelIndicador.eliminarIndicador(id);
    }
    public void modificarIndicador(int id,String descripcion,String metrica,int idnivelmodelo){
        this.nivelIndicador.setId(id);
        this.nivelIndicador.setDescripcion(descripcion);
        this.nivelIndicador.setMetrica(metrica);
        this.nivelIndicador.setIdnivelmodelo(idnivelmodelo);
        this.nivelIndicador.modificarIndicador();
    }
}
