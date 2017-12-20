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
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shep
 */
public class Encuesta {

    private int id;
    private int idfacultad;
    private Date fechainicio;
    private Date fechafin;
    private int idusuario1;
    private int idusuario2;
    private int idusuario3;
    private int idusuario4;
    private int idusuario5;
    private int idusuario6;
    private int idusuario7;
    private int idusuario8;
    private int idusuario9;
    private int idusuario10;
    
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

    public int getIdfacultad() {
        return idfacultad;
    }

    public void setIdfacultad(int idfacultad) {
        this.idfacultad = idfacultad;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public int getIdusuario1() {
        return idusuario1;
    }

    public void setIdusuario1(int idusuario1) {
        this.idusuario1 = idusuario1;
    }

    public int getIdusuario2() {
        return idusuario2;
    }

    public void setIdusuario2(int idusuario2) {
        this.idusuario2 = idusuario2;
    }

    public int getIdusuario3() {
        return idusuario3;
    }

    public void setIdusuario3(int idusuario3) {
        this.idusuario3 = idusuario3;
    }

    public int getIdusuario4() {
        return idusuario4;
    }

    public void setIdusuario4(int idusuario4) {
        this.idusuario4 = idusuario4;
    }

    public int getIdusuario5() {
        return idusuario5;
    }

    public void setIdusuario5(int idusuario5) {
        this.idusuario5 = idusuario5;
    }

    public int getIdusuario6() {
        return idusuario6;
    }

    public void setIdusuario6(int idusuario6) {
        this.idusuario6 = idusuario6;
    }

    public int getIdusuario7() {
        return idusuario7;
    }

    public void setIdusuario7(int idusuario7) {
        this.idusuario7 = idusuario7;
    }

    public int getIdusuario8() {
        return idusuario8;
    }

    public void setIdusuario8(int idusuario8) {
        this.idusuario8 = idusuario8;
    }

    public int getIdusuario9() {
        return idusuario9;
    }

    public void setIdusuario9(int idusuario9) {
        this.idusuario9 = idusuario9;
    }

    public int getIdusuario10() {
        return idusuario10;
    }

    public void setIdusuario10(int idusuario10) {
        this.idusuario10 = idusuario10;
    }
    
    /*
    public DefaultTableModel obtenerEncuestas() {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel encuestas = new DefaultTableModel();
        encuestas.setColumnIdentifiers(new Object[]{ //nombre, ci, cargo, fechanacimiento, sexo, direccion
            "id", "idfacultad", "idnivelmodelo", "fecha", "cuantificacionmadurez", "nivelmadurezaprobado"
        });
        
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "encuesta.id,\n"
                + "encuesta.idfacultad,\n"
                + "encuesta.idnivelmodelo,\n"
                + "encuesta.fecha,\n"
                + "encuesta.cuantificacionmadurez,\n"
                + "encuesta.nivelmadurezaprobado\n"
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
                    rs.getInt("idfacultad"),
                    rs.getInt("idnivelmodelo"),
                    rs.getDate("fecha"),
                    rs.getInt("cuantificacionmadurez"),
                    rs.getString("nivelmadurezaprobado")
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return encuestas;
    }*/
    
    /*
    private int id;
    private int idfacultad;
    private Date fechainicio;
    private Date fechafin;
    private int idusuario1;
    */
 public DefaultTableModel obtenerEncuestas() {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel encuestas = new DefaultTableModel();
        encuestas.setColumnIdentifiers(new Object[]{ //nombre, ci, cargo, fechanacimiento, sexo, direccion
            "id", "facultad", "fechaInicio", "fechaFin"
        });
            this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();
        // Preparo la consulta
       // String sql = "SELECT e.id,f.descripcion descripcionfacultad,nm.descripcion descripcionnivelmodelo,e.fecha,e.cuantificacionmadurez,e.nivelmadurezaprobado from encuesta e,facultad f,nivelmodelo nm where e.idfacultad=f.id and e.idnivelmodelo=nm.id";
       String sql = "SELECT e.id,\n" +
                    "f.descripcion descripcionfacultad,\n" +
                    "e.fechainicio,\n" +
                    "e.fechafin\n" +
                    "from encuestas e,facultads f where e.idfacultad=f.id";
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
                    rs.getString("descripcionfacultad"),
                    rs.getDate("fechainicio"),
                    rs.getDate("fechafin")
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
        
    
        String sql = "INSERT INTO public.encuestas(\n"
                + "	idfacultad, fechainicio, fechafin,idusuario1,idusuario2,idusuario3,idusuario4,idusuario5,idusuario6,idusuario7,idusuario8,idusuario9,idusuario10)\n"
                + "	VALUES (?, ?, ?,?,?,?,?,?,?,?,?,?,?);"; 
/*
            private int idfacultad;
    private Date fechainicio;
    private Date fechafin;
    private int idusuario1;
        */
        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // El segundo parametro de usa cuando se tienen tablas que generan llaves primarias
            // es bueno cuando nuestra bd tiene las primarias autoincrementables
            
            //registrando la fecha actual en this.fecha 
            //this.fechainicio = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            //this.fechainicio = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            ps.setInt(1, this.idfacultad);
            ps.setDate(2, this.fechainicio);
            ps.setDate(3, this.fechafin);
            ps.setInt(4, this.idusuario1);
            ps.setInt(5, this.idusuario2);
            ps.setInt(6, this.idusuario3);
            ps.setInt(7, this.idusuario4);
            ps.setInt(8, this.idusuario5);
            ps.setInt(9, this.idusuario6);
            ps.setInt(10, this.idusuario7);
            ps.setInt(11, this.idusuario8);
            ps.setInt(12, this.idusuario9);
            ps.setInt(13, this.idusuario10);
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

    /* NO TENDRA MODIFICAR 
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
    } */

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

    public void eliminarEncuesta(int id) {
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "DELETE FROM encuestas\n"
                + "WHERE encuestas.id = ?\n";
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
