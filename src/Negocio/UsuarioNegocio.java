/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
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
public class UsuarioNegocio {
    public Usuario usuario;
    
    public UsuarioNegocio(){
        this.usuario = new Usuario();
    }
    public DefaultTableModel obtenerUsuarios() {
        return this.usuario.obtenerUsuarios();
    }
    public DefaultTableModel obtenerUsuario(int id) {
        return this.usuario.getUsuario(id);
    }
    public int registrarUsuario(String nombre, String ci, String cargo, Date fechanacimiento, String sexo, String direccion) {
        // No olvidar primero settear los datos
        this.usuario.setNombre(nombre);
        this.usuario.setCi(ci);
        this.usuario.setDireccion(direccion);
        this.usuario.setCargo(cargo);
        this.usuario.setFechanacimiento(fechanacimiento);
        this.usuario.setSexo(sexo);
        return this.usuario.registrarUsuario();
    }
    public void eliminarUsuario(int id){
        this.usuario.eliminarUsuario(id);
    }
    public void modificarUsuario(int id,String nombre, String ci, String cargo, Date fechanacimiento, String sexo, String direccion) {
        this.usuario.setId(id);
        this.usuario.setNombre(nombre);
        this.usuario.setCi(ci);
        this.usuario.setDireccion(direccion);
        this.usuario.setCargo(cargo);
        this.usuario.setFechanacimiento(fechanacimiento);
        this.usuario.setSexo(sexo);
        this.usuario.modificarUsuario();
    }
}
