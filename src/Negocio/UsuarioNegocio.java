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
        return this.usuario.obtenerUsuario(id);
    }
    public int registrarUsuario(String name, String email, String password, String apellido, String ci, int idtipousuario,int idfacultad) {
        // No olvidar primero settear los datos
        this.usuario.setName(name);
        this.usuario.setEmail(email);
        this.usuario.setPassword(password);
        this.usuario.setApellido(apellido);
        this.usuario.setCi(ci);
        this.usuario.setIdtipousuario(idtipousuario);
        this.usuario.setIdfacultad(idfacultad);
        return this.usuario.registrarUsuario();
    }
    public void eliminarUsuario(int id){
        this.usuario.eliminarUsuario(id);
    }
    public void modificarUsuario(int id,String name, String apellido, String ci, int idtipousuario,int idfacultad) {
        this.usuario.setId(id);
        this.usuario.setName(name);
        this.usuario.setApellido(apellido);
        this.usuario.setCi(ci);
        this.usuario.setIdtipousuario(idtipousuario);
        this.usuario.setIdfacultad(idfacultad);
        this.usuario.modificarUsuario();
    }
}
