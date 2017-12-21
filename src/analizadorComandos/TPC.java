/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorComandos;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author mauriballes
 */
public class TPC {

    private static final LinkedList<String> lexemas = new LinkedList<>(Arrays.asList(
            "HELP",
            "TRUE",
            "FALSE" //HASTA AQUI TODO BIEN
            ,
             "OBTENERUSUARIOS",
             "REGISTRARUSUARIO",
             "ELIMINARUSUARIO",
             "MODIFICARUSUARIO" //INDICADOR
            ,
             "OBTENERINDICADOR",
             "REGISTRARINDICADOR",
             "ELIMINARINDICADOR",
             "MODIFICARINDICADOR" //TIPOUSUARIO
            ,
             "OBTENERTIPOUSUARIO",
             "REGISTRARTIPOUSUARIO",
             "ELIMINARTIPOUSUARIO",
             "MODIFICARTIPOUSUARIO" //MODELO
            ,
             "OBTENERMODELO",
             "REGISTRARMODELO",
             "ELIMINARMODELO",
             "MODIFICARMODELO" //ENCUESTA
            ,
             "OBTENERENCUESTA",
             "REGISTRARENCUESTA",
             "ELIMINARENCUESTA",
             "MODIFICARENCUESTA" //FACULTAD
            ,
             "OBTENERFACULTAD",
             "REGISTRARFACULTAD",
             "ELIMINARFACULTAD",
             "MODIFICARFACULTAD" //DETALLEUSUARIOENCUESTA
            ,
             "OBTENERDETALLEUSUARIOENCUESTA",
             "REGISTRARDETALLEUSUARIOENCUESTA",
             "ELIMINARDETALLEUSUARIOENCUESTA",
             
             "OBTENERUSUARIOENCUESTA",
             "OBTENERRESULTADOUSUARIO"
             
    ));

    private static final LinkedList<Token> tokens = new LinkedList<>(Arrays.asList(
            new Token(Token.HELP, -1, "HELP"),
            new Token(Token.TRUE, -1, "TRUE"),
            new Token(Token.FALSE, -1, "FALSE"),
            //MODIFICADO GRUPO 6  SE AGREGO LA COMA Y LA LINEA 106
            new Token(Token.FUNC, Token.OBTENERUSUARIOS, "OBTENERUSUARIOS"),
            new Token(Token.FUNC, Token.REGISTRARUSUARIO, "REGISTRARUSUARIO"),
             new Token(Token.FUNC, Token.ELIMINARUSUARIO, "ELIMINARUSUARIO"),
             new Token(Token.FUNC, Token.MODIFICARUSUARIO, "MODIFICARUSUARIO"),
             new Token(Token.FUNC, Token.OBTENERINDICADOR, "OBTENERINDICADOR"),
             new Token(Token.FUNC, Token.REGISTRARINDICADOR, "REGISTRARINDICADOR"),
             new Token(Token.FUNC, Token.ELIMINARINDICADOR, "ELIMINARINDICADOR"),
             new Token(Token.FUNC, Token.MODIFICARINDICADOR, "MODIFICARINDICADOR") //TIPOUSUARIO
            ,
             new Token(Token.FUNC, Token.OBTENERTIPOUSUARIO, "OBTENERTIPOUSUARIO"),
             new Token(Token.FUNC, Token.REGISTRARTIPOUSUARIO, "REGISTRARTIPOUSUARIO"),
             new Token(Token.FUNC, Token.ELIMINARTIPOUSUARIO, "ELIMINARTIPOUSUARIO"),
             new Token(Token.FUNC, Token.MODIFICARTIPOUSUARIO, "MODIFICARTIPOUSUARIO") //MODELO
            ,
             new Token(Token.FUNC, Token.OBTENERMODELO, "OBTENERMODELO"),
             new Token(Token.FUNC, Token.REGISTRARMODELO, "REGISTRARMODELO"),
             new Token(Token.FUNC, Token.ELIMINARMODELO, "ELIMINARMODELO"),
             new Token(Token.FUNC, Token.MODIFICARMODELO, "MODIFICARMODELO") //MODELO
            ,
             new Token(Token.FUNC, Token.OBTENERENCUESTA, "OBTENERENCUESTA"),
             new Token(Token.FUNC, Token.REGISTRARENCUESTA, "REGISTRARENCUESTA"),
             new Token(Token.FUNC, Token.ELIMINARENCUESTA, "ELIMINARENCUESTA"),
             new Token(Token.FUNC, Token.MODIFICARENCUESTA, "MODIFICARENCUESTA") //FACULTAD
            ,
             new Token(Token.FUNC, Token.OBTENERFACULTAD, "OBTENERFACULTAD"),
             new Token(Token.FUNC, Token.REGISTRARFACULTAD, "REGISTRARFACULTAD"),
             new Token(Token.FUNC, Token.ELIMINARFACULTAD, "ELIMINARFACULTAD"),
             new Token(Token.FUNC, Token.MODIFICARFACULTAD, "MODIFICARFACULTAD") //DETALLEUSUARIOENCUESTA
            ,
             new Token(Token.FUNC, Token.OBTENERDETALLEUSUARIOENCUESTA, "OBTENERDETALLEUSUARIOENCUESTA"),
             new Token(Token.FUNC, Token.REGISTRARDETALLEUSUARIOENCUESTA, "REGISTRARDETALLEUSUARIOENCUESTA"),
             new Token(Token.FUNC, Token.ELIMINARDETALLEUSUARIOENCUESTA, "ELIMINARDETALLEUSUARIOENCUESTA") //AYUDAS
            ,
              new Token(Token.FUNC, Token.OBTENERUSUARIOENCUESTA, "OBTENERUSUARIOENCUESTA"),
              new Token(Token.FUNC, Token.OBTENERRESULTADOUSUARIO, "OBTENERRESULTADOUSUARIO"),

             new Token(Token.FUNC, Token.OBTENERAYUDAMETRICAS, "OBTENERAYUDAMETRICAS")
    ));

    public static Token estaEnTPC(String lexema) {
        lexema = lexema.toUpperCase();
        for (int i = 0; i < lexemas.size(); i++) {
            if (lexemas.get(i).toUpperCase().equals(lexema)) {
                Token token = new Token();
                token.setNombre(tokens.get(i).getNombre());
                token.setAtributo(tokens.get(i).getAtributo());
                token.setToStr(tokens.get(i).getToStr());
                return token;
            }
        }
        return null;
    }
}
