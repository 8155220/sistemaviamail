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
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shep
 */
public class DetalleUsuarioEncuesta {
    private int id;
    private int idencuesta;
    private int idnivelmodelo;
    private int idnivelindicador;
    private int idusuario;
    private int respuesta;
    
    public Conexion m_Conexion;

    public DetalleUsuarioEncuesta() {
        this.m_Conexion = Conexion.getInstancia();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdencuesta() {
        return idencuesta;
    }

    public void setIdencuesta(int idencuesta) {
        this.idencuesta = idencuesta;
    }

    public int getIdnivelmodelo() {
        return idnivelmodelo;
    }

    public void setIdnivelmodelo(int idnivelmodelo) {
        this.idnivelmodelo = idnivelmodelo;
    }

    public int getIdnivelindicador() {
        return idnivelindicador;
    }

    public void setIdnivelindicador(int idnivelindicador) {
        this.idnivelindicador = idnivelindicador;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
    
    public DefaultTableModel obtenerDetalleUsuarioEncuestas() {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel detalleusuarioencuestas = new DefaultTableModel();
        detalleusuarioencuestas.setColumnIdentifiers(new Object[]{ //nombre, ci, cargo, fechanacimiento, sexo, direccion
            "id", "idencuesta", "nivelmodelo", "nivelindicador", "usuario", "respuesta"
        });
            this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();
        // Preparo la consulta
        String sql = "select due.id,e.id idencuesta\n" +
                    ",nm.descripcion descripcionnivelmodelo\n" +
                    ",ni.descripcion descripcionnivelindicador\n" +
                    ",u.nombre nombreusuario\n" +
                    ",due.respuesta\n" +
                    "from detalle_usuario_encuesta due, encuesta e, nivelmodelo nm, nivelindicador ni, usuario u \n" +
                    "where due.idencuesta=e.id and due.idnivelmodelo=nm.id and due.idnivelindicador=ni.id and due.idusuario=u.id";

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Cierro la conexion
            this.m_Conexion.cerrarConexion();

            // Recorro el resultado
            while (rs.next()) {
                // Agrego las tuplas a mi tabla
                detalleusuarioencuestas.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getInt("idencuesta"),
                    rs.getString("descripcionnivelmodelo"),
                    rs.getString("descripcionnivelindicador"),
                    rs.getString("nombreusuario"),
                    rs.getInt("respuesta")
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return detalleusuarioencuestas;
    }
    /*
    public int registrarDetalleUsuarioEncuesta() {
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        
    
        String sql = "INSERT INTO public.detalle_usuario_encuesta(\n" +
                    "	idencuesta, idnivelmodelo, idnivelindicador, idusuario, respuesta)\n" +
                    "	VALUES (?, ?, ?, ?, ?);"; 

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // El segundo parametro de usa cuando se tienen tablas que generan llaves primarias
            // es bueno cuando nuestra bd tiene las primarias autoincrementables
            
            //registrando la fecha actual en this.fecha 
            ps.setInt(1, this.idencuesta);
            ps.setInt(2, this.idnivelmodelo);
            ps.setInt(3, this.idnivelindicador);
            ps.setInt(4, this.idusuario);
            ps.setInt(5,this.respuesta);
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
    */
    public int registrarDetalleUsuarioEncuesta() {
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        
    
        String sql = "INSERT INTO public.detalle_usuario_encuesta(\n" +
                    "	idencuesta, idnivelmodelo, idnivelindicador, idusuario, respuesta)\n" +
                    "	VALUES (?, ?, ?, ?, ?);"; 

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // El segundo parametro de usa cuando se tienen tablas que generan llaves primarias
            // es bueno cuando nuestra bd tiene las primarias autoincrementables
            
            //registrando la fecha actual en this.fecha 
            ps.setInt(1, this.idencuesta);
            ps.setInt(2, this.idnivelmodelo);
            ps.setInt(3, this.idnivelindicador);
            ps.setInt(4, this.idusuario);
            ps.setInt(5,this.respuesta);
            int rows = ps.executeUpdate();

            //INVENTO
            sql = "select avg(respuesta*100) promedio from detalle_usuario_encuesta where idencuesta=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idencuesta);
            ResultSet rs = ps.executeQuery();
            int promedio = 0;
            while (rs.next()) {
                // Agrego las tuplas a mi tabla
                promedio = rs.getInt("promedio");
            }
            sql = "UPDATE encuesta SET\n"
                + "cuantificacionmadurez = ?,\n"
                + "nivelmadurezaprobado = ?\n"
                + "WHERE id = ?";
            // La ejecuto
            System.out.println("ELPROMEDIOES : "+promedio);
            ps = con.prepareStatement(sql);
            ps.setInt(1, promedio);
            ps.setString(2, "Test");
            ps.setString(2, "Test");
            ps.setInt(2, this.idencuesta);
            rows = ps.executeUpdate();
            
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

    /* NO TENDRA MODIFICAR 
    public void modificarDetalleUsuarioEncuesta() {
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "UPDATE detalleusuarioencuesta SET\n"
                + "cantidadmiembros = ?,\n"
                + "cuantificacionmadurez = ?,\n"
                + "descripcion = ?,\n"
                + "evaluacion = ?,\n"
                + "idnivelindicador = ?,\n"
                + "idtipodetalleusuarioencuesta = ?,\n"
                + "fecha = ?\n"
                + "WHERE detalleusuarioencuesta.id = ?";
        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, this.cantidadmiembros);
            ps.setInt(2, this.cuantificacionmadurez);
            ps.setString(3, this.descripcion);
            ps.setInt(4, this.evaluacion);
            ps.setInt(5, this.idnivelindicador);
            ps.setInt(6, this.idtipodetalleusuarioencuesta);
            ps.setDate(7, this.fecha);
            ps.setInt(8, this.id);
            int rows = ps.executeUpdate();

            // Cierro la conexion
            this.m_Conexion.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } */

    public DefaultTableModel getDetalleUsuarioEncuesta(int id) {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel detalleusuarioencuesta = new DefaultTableModel();
        detalleusuarioencuesta.setColumnIdentifiers(new Object[]{
            "id", "nombre", "ci", "cargo", "fechanacimiento", "sexo", "direccion"
        });

        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "detalleusuarioencuesta.id,\n"
                + "detalleusuarioencuesta.nombre,\n"
                + "detalleusuarioencuesta.ci,\n"
                + "detalleusuarioencuesta.cargo,\n"
                + "detalleusuarioencuesta.fechanacimiento,\n"
                + "detalleusuarioencuesta.sexo,\n"
                + "detalleusuarioencuesta.direccion\n"
                + "FROM detalleusuarioencuesta\n"
                + "WHERE detalleusuarioencuesta.id=?";
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
                detalleusuarioencuesta.addRow(new Object[]{
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
        return detalleusuarioencuesta;
    }

    public void eliminarDetalleUsuarioEncuesta(int id) {
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "DELETE FROM detalleusuarioencuesta\n"
                + "WHERE detalleusuarioencuesta.id = ?\n";
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
