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
public class Encuesta {
    private int id;
    private int cantidadmiembros;
    private int cuantificacionmadurez;
    private String descripcion;
    private int evaluacion;
    private int idnivelindicador;
    private int idtipoencuesta;
    private Date fecha;
    public Conexion m_Conexion;
    
    public Encuesta() {
        this.m_Conexion = Conexion.getInstancia();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadmiembros() {
        return cantidadmiembros;
    }

    public void setCantidadmiembros(int cantidadmiembros) {
        this.cantidadmiembros = cantidadmiembros;
    }

    public int getCuantificacionmadurez() {
        return cuantificacionmadurez;
    }

    public void setCuantificacionmadurez(int cuantificacionmadurez) {
        this.cuantificacionmadurez = cuantificacionmadurez;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(int evaluacion) {
        this.evaluacion = evaluacion;
    }

    public int getIdnivelindicador() {
        return idnivelindicador;
    }

    public void setIdnivelindicador(int idnivelindicador) {
        this.idnivelindicador = idnivelindicador;
    }

    public int getIdtipoencuesta() {
        return idtipoencuesta;
    }

    public void setIdtipoencuesta(int idtipoencuesta) {
        this.idtipoencuesta = idtipoencuesta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public DefaultTableModel obtenerEncuestas() {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel encuestas = new DefaultTableModel();
        encuestas.setColumnIdentifiers(new Object[]{  //nombre, ci, cargo, fechanacimiento, sexo, direccion
            "id", "cantidadmiembros", "cuantificacionmadurez", "descripcion", "evaluacion", "idnivelindicador", "idtipoencuesta", "fecha"
        });

        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "encuesta.id,\n"
                + "encuesta.cantidadmiembros,\n"
                + "encuesta.cuantificacionmadurez,\n"
                + "encuesta.descripcion,\n"
                + "encuesta.evaluacion,\n"
                + "encuesta.idnivelindicador,\n"
                + "encuesta.idtipoencuesta,\n"
                + "encuesta.fecha\n"
                + "FROM encuesta";

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Cierro la conexion
            this.m_Conexion.cerrarConexion();

            // Recorro el resultado
            while (rs.next()) {
                // Agrego las tuplas a mi tabla
                encuestas.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getInt("cantidadmiembros"),
                    rs.getInt("cuantificacionmadurez"),
                    rs.getString("descripcion"),
                    rs.getInt("evaluacion"),
                    rs.getInt("idnivelindicador"),
                    rs.getInt("idtipoencuesta"),
                    rs.getDate("fecha")
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return encuestas;
    }
    
    public int registrarEncuesta() {
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "INSERT INTO public.encuesta(\n" +
                "	cantidadmiembros, cuantificacionmadurez, descripcion, evaluacion, idnivelindicador, idtipoencuesta, fecha)\n" +
                "	VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // El segundo parametro de usa cuando se tienen tablas que generan llaves primarias
            // es bueno cuando nuestra bd tiene las primarias autoincrementables
            ps.setInt(1, this.cantidadmiembros);
            ps.setInt(2, this.cuantificacionmadurez);
            ps.setString(3, this.descripcion);
            ps.setInt(4, this.evaluacion);
            ps.setInt(5, this.idnivelindicador);
            ps.setInt(6, this.idtipoencuesta);
            ps.setDate(7, this.fecha);
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
    public void modificarEncuesta() {
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "UPDATE encuesta SET\n"
                + "cantidadmiembros = ?,\n"
                + "cuantificacionmadurez = ?,\n"
                + "descripcion = ?,\n"
                + "evaluacion = ?,\n"
                + "idnivelindicador = ?,\n"
                + "idtipoencuesta = ?,\n"
                + "fecha = ?\n"
                + "WHERE encuesta.id = ?";
        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, this.cantidadmiembros);
            ps.setInt(2, this.cuantificacionmadurez);
            ps.setString(3, this.descripcion);
            ps.setInt(4, this.evaluacion);
            ps.setInt(5, this.idnivelindicador);
            ps.setInt(6, this.idtipoencuesta);
            ps.setDate(7, this.fecha);
            ps.setInt(8, this.id);
            int rows = ps.executeUpdate();

            // Cierro la conexion
            this.m_Conexion.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public DefaultTableModel getEncuesta(int id) {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel encuesta = new DefaultTableModel();
        encuesta.setColumnIdentifiers(new Object[]{
            "id", "nombre", "ci", "cargo", "fechanacimiento", "sexo", "direccion"
        });

        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "encuesta.id,\n"
                + "encuesta.nombre,\n"
                + "encuesta.ci,\n"
                + "encuesta.cargo,\n"
                + "encuesta.fechanacimiento,\n"
                + "encuesta.sexo,\n"
                + "encuesta.direccion\n"
                + "FROM encuesta\n"
                + "WHERE encuesta.id=?";
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
                encuesta.addRow(new Object[]{
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
        return encuesta;
    }
    public void eliminarEncuesta(int id){
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "DELETE FROM encuesta\n"
                + "WHERE encuesta.id = ?\n";
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
