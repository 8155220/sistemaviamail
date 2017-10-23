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
    private String nombre;
    private String ci;
    private String direccion;
    private String cargo;
    private Date fechanacimiento;
    private String sexo;
    public Usuario() {
        this.m_Conexion = Conexion.getInstancia();
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
        
    //CRUD
    
    public DefaultTableModel obtenerUsuarios() {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel usuarios = new DefaultTableModel();
        usuarios.setColumnIdentifiers(new Object[]{  //nombre, ci, cargo, fechanacimiento, sexo, direccion
            "id", "nombre", "ci", "cargo", "fechanacimiento", "sexo", "direccion"
        });

        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "usuario.id,\n"
                + "usuario.nombre,\n"
                + "usuario.ci,\n"
                + "usuario.cargo,\n"
                + "usuario.fechanacimiento,\n"
                + "usuario.sexo,\n"
                + "usuario.direccion\n"
                + "FROM usuario";

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
        return usuarios;
    }
    
    public int registrarUsuario() {
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "INSERT INTO public.usuario(\n" +
                    "	nombre, ci, cargo, fechanacimiento, sexo, direccion)\n" +
                    "	VALUES (?, ?, ?, ?, ?, ?);";

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // El segundo parametro de usa cuando se tienen tablas que generan llaves primarias
            // es bueno cuando nuestra bd tiene las primarias autoincrementables
            ps.setString(1, this.nombre);
            ps.setString(2, this.ci);
            ps.setString(3, this.cargo);
            ps.setDate(4, this.fechanacimiento);
            ps.setString(5, this.sexo);
            ps.setString(6, this.direccion);
            int rows = ps.executeUpdate();

            // Cierro Conexion
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
        String sql = "UPDATE usuario SET\n"
                + "nombre = ?,\n"
                + "ci = ?,\n"
                + "cargo = ?,\n"
                + "fechanacimiento = ?,\n"
                + "sexo = ?,\n"
                + "direccion = ?\n"
                + "WHERE usuario.id = ?";
        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.nombre);
            ps.setString(2, this.ci);
            ps.setString(3, this.cargo);
            ps.setDate(4, this.fechanacimiento);
            ps.setString(5, this.sexo);
            ps.setString(6, this.direccion);
            ps.setInt(7, this.id);
            int rows = ps.executeUpdate();

            // Cierro la conexion
            this.m_Conexion.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public DefaultTableModel getUsuario(int id) {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel usuario = new DefaultTableModel();
        usuario.setColumnIdentifiers(new Object[]{
            "id", "nombre", "ci", "cargo", "fechanacimiento", "sexo", "direccion"
        });

        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "usuario.id,\n"
                + "usuario.nombre,\n"
                + "usuario.ci,\n"
                + "usuario.cargo,\n"
                + "usuario.fechanacimiento,\n"
                + "usuario.sexo,\n"
                + "usuario.direccion\n"
                + "FROM usuario\n"
                + "WHERE usuario.id=?";
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
    public void eliminarUsuario(int id){
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "DELETE FROM usuario\n"
                + "WHERE usuario.id = ?\n";
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
}
