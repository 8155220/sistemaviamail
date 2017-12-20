/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorComandos;

/**
 *
 * @author mauriballes
 */
public class Token {

    // Constantes
    public static final int NUM = 0; // Numero Valor
    public static final int STRING = 1; // String Constante
    public static final int FUNC = 2; // Alguna Funcion
    public static final int GB = 3; //Guion Bajo
    public static final int CA = 4; // Corchete Abierto
    public static final int CC = 5; // Corchete Cerrado
    public static final int COMA = 6; // Coma ,
    public static final int FIN = 7;
    public static final int ERROR = 8;
    public static final int TRUE = 9;
    public static final int FALSE = 10;
    public static final int HELP = 11;

    // Funciones
    //MODIFICADO GRUPO06
    public static final int OBTENERUSUARIOS = 200;
    public static final int REGISTRARUSUARIO = 201;
    public static final int ELIMINARUSUARIO = 202;
    public static final int MODIFICARUSUARIO = 203;
    
    public static final int OBTENERINDICADOR = 204;
    public static final int REGISTRARINDICADOR = 205;
    public static final int ELIMINARINDICADOR = 206;
    public static final int MODIFICARINDICADOR = 207;
    //TIPOUSUARIO
    public static final int OBTENERTIPOUSUARIO = 208;
    public static final int REGISTRARTIPOUSUARIO = 209;
    public static final int ELIMINARTIPOUSUARIO = 210;
    public static final int MODIFICARTIPOUSUARIO = 211;
    //MODELO
    public static final int OBTENERMODELO = 212;
    public static final int REGISTRARMODELO = 213;
    public static final int ELIMINARMODELO = 214;
    public static final int MODIFICARMODELO = 215;
    //ENCUESTA
    public static final int OBTENERENCUESTA = 216;
    public static final int REGISTRARENCUESTA = 217;
    public static final int ELIMINARENCUESTA = 218;
    public static final int MODIFICARENCUESTA = 219;
    //FACULTAD
    public static final int OBTENERFACULTAD = 220;
    public static final int REGISTRARFACULTAD = 221;
    public static final int ELIMINARFACULTAD = 222;
    public static final int MODIFICARFACULTAD = 223;
    //DETALLEUSUARIOENCUESTA
    public static final int OBTENERDETALLEUSUARIOENCUESTA = 224;
    public static final int REGISTRARDETALLEUSUARIOENCUESTA = 225;
    public static final int ELIMINARDETALLEUSUARIOENCUESTA = 226;
    
    //AYUDAS
    public static final int OBTENERAYUDAMETRICAS = 300;



    private int nombre;
    private int atributo;
    private String toStr;

    public Token() {
    }

    public Token(int nombre, int atributo, String toStr) {
        this.nombre = nombre;
        this.atributo = atributo;
        this.toStr = toStr;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getAtributo() {
        return atributo;
    }

    public void setAtributo(int atributo) {
        this.atributo = atributo;
    }

    public String getToStr() {
        return toStr;
    }

    public void setToStr(String toStr) {
        this.toStr = toStr;
    }

}
