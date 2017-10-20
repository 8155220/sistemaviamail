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
    
    public static final int OBTENERNIVELINDICADOR = 204;
    public static final int REGISTRARNIVELINDICADOR = 205;
    public static final int ELIMINARNIVELINDICADOR = 206;
    public static final int MODIFICARNIVELINDICADOR = 207;
    //TIPOENCUESTA
    public static final int OBTENERTIPOENCUESTA = 208;
    public static final int REGISTRARTIPOENCUESTA = 209;
    public static final int ELIMINARTIPOENCUESTA = 210;
    public static final int MODIFICARTIPOENCUESTA = 211;
    //NIVELMODELO
    public static final int OBTENERNIVELMODELO = 212;
    public static final int REGISTRARNIVELMODELO = 213;
    public static final int ELIMINARNIVELMODELO = 214;
    public static final int MODIFICARNIVELMODELO = 215;
    //ENCUESTA
    public static final int OBTENERENCUESTA = 216;
    public static final int REGISTRARENCUESTA = 217;
    public static final int ELIMINARENCUESTA = 218;
    public static final int MODIFICARENCUESTA = 219;


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
