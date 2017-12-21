/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shep
 */
public class TipoUsuario {
    private int id;
    private String descripcion;
    public Conexion m_Conexion;
    public TipoUsuario() {
        this.m_Conexion = Conexion.getInstancia();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public DefaultTableModel obtenerTipoUsuario() {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel tipoEncuesta = new DefaultTableModel();
        tipoEncuesta.setColumnIdentifiers(new Object[]{  //nombre, ci, cargo, fechanacimiento, sexo, direccion
            "id", "descripcion"
        });

        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "tipo_usuarios.id,\n"
                + "tipo_usuarios.descripcion\n"
                + "FROM tipo_usuarios order by id ASC";

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Cierro la conexion
            this.m_Conexion.cerrarConexion();

            // Recorro el resultado
            while (rs.next()) {
                // Agrego las tuplas a mi tabla
                tipoEncuesta.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("descripcion")
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tipoEncuesta;
    }
    
    public int registrarTipoUsuario() {
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "INSERT INTO public.tipo_usuarios(\n" +
                    "	descripcion)\n" +
                    "	VALUES (?);";

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // El segundo parametro de usa cuando se tienen tablas que generan llaves primarias
            // es bueno cuando nuestra bd tiene las primarias autoincrementables
            ps.setString(1, this.descripcion);
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
    public void modificarTipoUsuario() {
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "UPDATE tipo_usuarios SET\n"
                + "descripcion = ?\n"
                + "WHERE tipo_usuarios.id = ?";
        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.descripcion);
            ps.setInt(2, this.id);
            int rows = ps.executeUpdate();
            // Cierro la conexion
            this.m_Conexion.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public DefaultTableModel getTipoUsuario(int id) {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel tipoEncuesta = new DefaultTableModel();
        tipoEncuesta.setColumnIdentifiers(new Object[]{
            "id", "descripcion"
        });

        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "tipo_usuarios.id,\n"
                + "tipo_usuarios.descripcion,\n"
                + "FROM tipo_usuarios\n"
                + "WHERE tipo_usuarios.id=?";
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
                tipoEncuesta.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("descripcion")
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tipoEncuesta;
    }
    public void eliminarTipoUsuario(int id){
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "DELETE FROM tipo_usuarios\n"
                + "WHERE tipo_usuarios.id = ?\n";
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
