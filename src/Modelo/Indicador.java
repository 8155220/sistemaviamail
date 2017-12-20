/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion;
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
public class Indicador {
    private int id;
    private String descripcion;
    private String metrica;
    private int idmodelo;
    public Conexion m_Conexion;
    public Indicador() {
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

    public String getMetrica() {
        return metrica;
    }

    public void setMetrica(String metrica) {
        this.metrica = metrica;
    }

    public int getIdnivelmodelo() {
        return idmodelo;
    }

    public void setIdnivelmodelo(int idmodelo) {
        this.idmodelo = idmodelo;
    }
    
    
    public DefaultTableModel obtenerIndicador() {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel indicadors = new DefaultTableModel();
        indicadors.setColumnIdentifiers(new Object[]{  //nombre, ci, cargo, fechanacimiento, sexo, direccion
            "id", "descripcion","metrica","idmodelo"
        });

        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "indicadors.id,\n"
                + "indicadors.descripcion,\n"
                + "indicadors.metrica,\n"
                + "modelos.descripcion idmodelo\n"
                + "FROM indicadors,modelos where modelos.id=indicadors.idmodelo";

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Cierro la conexion
            this.m_Conexion.cerrarConexion();

            // Recorro el resultado
            while (rs.next()) {
                // Agrego las tuplas a mi tabla
                indicadors.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("descripcion"),
                    rs.getString("metrica"),
                    rs.getString("idmodelo")
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return indicadors;
    }
    
    public int registrarIndicador() {
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();
            
  
    
        // Preparo la consulta
        String sql = "INSERT INTO public.indicadors(\n" +
                    "	descripcion,\n" +
                    "	metrica,\n" +
                    "	idmodelo)\n" +
                    "	VALUES (?,?,?);";

        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // El segundo parametro de usa cuando se tienen tablas que generan llaves primarias
            // es bueno cuando nuestra bd tiene las primarias autoincrementables
            ps.setString(1, this.descripcion);
            ps.setString(2, this.metrica);
            ps.setInt(3, this.idmodelo);
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
    public void modificarIndicador() {
        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "UPDATE indicadors SET\n"
                + "descripcion = ? ,\n"
                + "metrica = ?, \n"
                + "idmodelo = ?\n"
                + "WHERE indicadors.id = ?";
        try {
            // La ejecuto
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, this.descripcion);
            ps.setString(2, this.metrica);
            ps.setInt(3, this.idmodelo);
            ps.setInt(4, this.id);
            int rows = ps.executeUpdate();
            // Cierro la conexion
            this.m_Conexion.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public DefaultTableModel getIndicador(int id) {
        // Tabla para mostrar lo obtenido de la consulta
        DefaultTableModel indicadors = new DefaultTableModel();
        indicadors.setColumnIdentifiers(new Object[]{
            "id", "descripcion"
        });

        // Abro y obtengo la conexion
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "SELECT\n"
                + "indicadors.id,\n"
                + "indicadors.descripcion,\n"
                + "FROM indicadors\n"
                + "WHERE indicadors.id=?";
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
                indicadors.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("descripcion")
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return indicadors;
    }
    public void eliminarIndicador(int id){
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();

        // Preparo la consulta
        String sql = "DELETE FROM indicadors\n"
                + "WHERE indicadors.id = ?\n";
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
