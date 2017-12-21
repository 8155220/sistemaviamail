/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shep
 */
public class Usuario {

    public Conexion m_Conexion;
    private int id;
    private String name;
    private String email;
    private String password;
    private String apellido;
    private String ci;
    private int idtipousuario;
    private int idfacultad;

    public Usuario() {
        this.m_Conexion = Conexion.getInstancia();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public int getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(int idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public int getIdfacultad() {
        return idfacultad;
    }

    public void setIdfacultad(int idfacultad) {
        this.idfacultad = idfacultad;
    }
    //CRUD

    public DefaultTableModel obtenerUsuarios() {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel usuarios = new DefaultTableModel();
        usuarios.setColumnIdentifiers(new Object[]{ //nombre, ci, cargo, fechanacimiento, sexo, direccion
            "id", "name", "email", "apellido", "ci", "idtipousuario", "idfacultad"
        });

        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "users.id,\n"
                + "users.name,\n"
                + "users.email,\n"
                + "users.apellido,\n"
                + "users.ci,\n"
                + "users.idtipousuario,\n"
                + "users.idfacultad\n"
                + "FROM users";
        
        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Cierro la conexion
            this.m_Conexion.cerrarConexion();

            // Recorro el resultado
            while (rs.next()) {
                // Agrego las tuplas a mi tabla
                usuarios.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("apellido"),
                    rs.getString("ci"),
                    rs.getInt("idtipousuario"),
                    rs.getInt("idfacultad")
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return usuarios;
    }

    public int registrarUsuario() {
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "INSERT INTO public.users(\n"
                + "	name, email,password, apellido, ci, idtipousuario, idfacultad)\n"
                + "	VALUES (?, ?, ?, ?, ?, ?,?);";

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // El segundo parametro de usa cuando se tienen tablas que generan llaves primarias
            // es bueno cuando nuestra bd tiene las primarias autoincrementables
            ps.setString(1, this.name);
            ps.setString(2, this.email);
            ps.setString(3, this.password);
            ps.setString(4, this.apellido);
            ps.setString(5, this.ci);
            ps.setInt(6, this.idtipousuario);
            ps.setInt(7, this.idfacultad);
            int rows = ps.executeUpdate();

            this.m_Conexion.cerrarConexion();

            // Obtengo el id generado pra devolverlo
            if (rows != 0) {
                ResultSet generateKeys = ps.getGeneratedKeys();
                if (generateKeys.next()) {
                    return generateKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public void modificarUsuario() {
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();                 
        // Preparo la consulta
        String sql = "UPDATE users SET\n"
                + "name = ?,\n"
                + "apellido = ?,\n"
                + "ci = ?,\n"
                + "idtipousuario = ?,\n"
                + "idfacultad = ?\n"
                + "WHERE users.id = ?";
        try {
            // La ejecuto
            

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.name);
            ps.setString(2, this.apellido);
            ps.setString(3, this.ci);
            ps.setInt(4, this.idtipousuario);
            ps.setInt(5, this.idfacultad);
            ps.setInt(6, this.id);
            int rows = ps.executeUpdate();

            // Cierro la conexion
            this.m_Conexion.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public DefaultTableModel obtenerUsuario(int id) {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel usuario = new DefaultTableModel();
        usuario.setColumnIdentifiers(new Object[]{
            "id", "name", "email", "apellido", "ci;", "idtipousuario", "idfacultad"
        });

        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "users.id,\n"
                + "users.name,\n"
                + "users.email,\n"
                + "users.password,\n"
                + "users.apellido,\n"
                + "users.ci,\n"
                + "users.idtipousuario\n"
                + "users.idfacultad\n"
                + "FROM users\n"
                + "WHERE users.id=?";
        // Los simbolos de interrogacion son para mandar parametros 
        // a la consulta al momento de ejecutalas

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // Cierro la conexion
            this.m_Conexion.cerrarConexion();

            // Recorro el resultado
            while (rs.next()) {
                // Agrego las tuplas a mi tabla
                usuario.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("ci"),
                    rs.getString("cargo"),
                    rs.getDate("fechanacimiento"),
                    rs.getString("sexo"),
                    rs.getString("direccion")
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return usuario;
    }
    
    
    public Usuario getUsuario(int id) {
        // Tabla para mostrar lo obtenido de la consulta
        Usuario usuario = new Usuario();

        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "users.id,\n"
                + "users.name,\n"
                + "users.email,\n"
                + "users.password,\n"
                + "users.apellido,\n"
                + "users.ci,\n"
                + "users.idtipousuario,\n"
                + "users.idfacultad\n"
                + "FROM users\n"
                + "WHERE users.id=? order by id ASC";
        // Los simbolos de interrogacion son para mandar parametros 
        // a la consulta al momento de ejecutalas

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // Cierro la conexion
            this.m_Conexion.cerrarConexion();

            // Recorro el resultado
            while (rs.next()) {
                // Agrego las tuplas a mi tabla
                usuario.setId(rs.getInt("id"));
                usuario.setName(rs.getString("name"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCi(rs.getString("ci"));
                usuario.setIdtipousuario(rs.getInt("idtipousuario"));
                usuario.setIdfacultad(rs.getInt("idfacultad"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return usuario;
    }

    public void eliminarUsuario(int id) {
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "DELETE FROM users\n"
                + "WHERE users.id = ?\n";
        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
            // El segundo parametro de usa cuando se tienen tablas que generan llaves primarias
            // es bueno cuando nuestra bd tiene las primarias autoincrementables
            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            // Cierro Conexion
            this.m_Conexion.cerrarConexion();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", apellido=" + apellido + ", ci=" + ci + ", idtipousuario=" + idtipousuario + ", idfacultad=" + idfacultad + '}';
    }
    
    
}
