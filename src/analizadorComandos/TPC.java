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
             "MODIFICARUSUARIO" //NIVELINDICADOR
            ,
             "OBTENERNIVELINDICADOR",
             "REGISTRARNIVELINDICADOR",
             "ELIMINARNIVELINDICADOR",
             "MODIFICARNIVELINDICADOR" //TIPOENCUESTA
            ,
             "OBTENERTIPOENCUESTA",
             "REGISTRARTIPOENCUESTA",
             "ELIMINARTIPOENCUESTA",
             "MODIFICARTIPOENCUESTA" //NIVELMODELO
            ,
             "OBTENERNIVELMODELO",
             "REGISTRARNIVELMODELO",
             "ELIMINARNIVELMODELO",
             "MODIFICARNIVELMODELO" //ENCUESTA
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
             "ELIMINARDETALLEUSUARIOENCUESTA"
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
             new Token(Token.FUNC, Token.OBTENERNIVELINDICADOR, "OBTENERNIVELINDICADOR"),
             new Token(Token.FUNC, Token.REGISTRARNIVELINDICADOR, "REGISTRARNIVELINDICADOR"),
             new Token(Token.FUNC, Token.ELIMINARNIVELINDICADOR, "ELIMINARNIVELINDICADOR"),
             new Token(Token.FUNC, Token.MODIFICARNIVELINDICADOR, "MODIFICARNIVELINDICADOR") //TIPOENCUESTA
            ,
             new Token(Token.FUNC, Token.OBTENERTIPOENCUESTA, "OBTENERTIPOENCUESTA"),
             new Token(Token.FUNC, Token.REGISTRARTIPOENCUESTA, "REGISTRARTIPOENCUESTA"),
             new Token(Token.FUNC, Token.ELIMINARTIPOENCUESTA, "ELIMINARTIPOENCUESTA"),
             new Token(Token.FUNC, Token.MODIFICARTIPOENCUESTA, "MODIFICARTIPOENCUESTA") //NIVELMODELO
            ,
             new Token(Token.FUNC, Token.OBTENERNIVELMODELO, "OBTENERNIVELMODELO"),
             new Token(Token.FUNC, Token.REGISTRARNIVELMODELO, "REGISTRARNIVELMODELO"),
             new Token(Token.FUNC, Token.ELIMINARNIVELMODELO, "ELIMINARNIVELMODELO"),
             new Token(Token.FUNC, Token.MODIFICARNIVELMODELO, "MODIFICARNIVELMODELO") //NIVELMODELO
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
