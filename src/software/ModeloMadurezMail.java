/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

import Negocio.DetalleUsuarioEncuestaNegocio;
import Negocio.EncuestaNegocio;
import Negocio.FacultadNegocio;
import Negocio.NivelIndicadorNegocio;
import Negocio.NivelModeloNegocio;
import Negocio.TipoEncuestaNegocio;
import Negocio.UsuarioNegocio;
import sockets.ClienteSMTP;
import analizadorComandos.Analex;
import analizadorComandos.Cinta;
import analizadorComandos.Parser;
import analizadorComandos.Token;
import utils.Helper;
import utils.Utils;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class ModeloMadurezMail {

    public void processMessage(String Message) {
        // Setteando Variables
        String destinatario = Utils.getDestinatario(Message);
        System.out.println("destinatario :"+ destinatario);
        String content = Utils.getSubjectOrden(Message);
        System.out.println("get SubjectOrden :" + content);
        Cinta cinta = new Cinta(content);
        Analex analex = new Analex(cinta);
        Parser parser = new Parser(analex);

        // Verificar Orden
        parser.Expresion();
        if (parser.errorFlag) {
            // Enviar Correo de Error
            ClienteSMTP.sendMail(destinatario, "Error de Comando",
                    "El comando introducido es incorrecto, trate consultando las ayudas con el comando HELP"
            );
            return;
        }

        // Si todo va bien, procesar el Comando
        analex.Init();
        Token token = analex.Preanalisis();

        if (token.getNombre() == Token.HELP) {
            // Mostrar Ayudas
            ClienteSMTP.sendMail(destinatario, "Asistencia - Servicio Email", Helper.HELP_GLOBAL);
            return;
        }
        System.out.println("EL TOKEN ES : "+token.getAtributo());

        // Sino es HELP, es una funcionalidad
        switch (token.getAtributo()) {

            //MODIFICADO GRUPO6
            case Token.OBTENERUSUARIOS:
                obtenerUsuarios(analex,destinatario);
                break;
            case Token.REGISTRARUSUARIO:
                registrarUsuario(analex,destinatario);
                break;
            case Token.ELIMINARUSUARIO:
                eliminarUsuario(analex,destinatario);
                break;
            case Token.MODIFICARUSUARIO:
                modificarUsuario(analex,destinatario);
                break;
            case Token.OBTENERNIVELINDICADOR:
                obtenerNivelIndicador(analex,destinatario);
                break;
            case Token.REGISTRARNIVELINDICADOR:
                registrarNivelIndicador(analex,destinatario);
                break;
            case Token.ELIMINARNIVELINDICADOR:
                eliminarNivelIndicador(analex,destinatario);
                break;
            case Token.MODIFICARNIVELINDICADOR:
                modificarNivelIndicador(analex,destinatario);
                break;
                //TIPOENCUESTA
            case Token.OBTENERTIPOENCUESTA:
                obtenerTipoEncuesta(analex,destinatario);
                break;
            case Token.REGISTRARTIPOENCUESTA:
                registrarTipoEncuesta(analex,destinatario);
                break;
            case Token.ELIMINARTIPOENCUESTA:
                eliminarTipoEncuesta(analex,destinatario);
                break;
            case Token.MODIFICARTIPOENCUESTA:
                modificarTipoEncuesta(analex,destinatario);
                break;
                //NIVELMODELO
            case Token.OBTENERNIVELMODELO:
                obtenerNivelModelo(analex,destinatario);
                break;
            case Token.REGISTRARNIVELMODELO:
                registrarNivelModelo(analex,destinatario);
                break;
            case Token.ELIMINARNIVELMODELO:
                eliminarNivelModelo(analex,destinatario);
                break;
            case Token.MODIFICARNIVELMODELO:
                modificarNivelModelo(analex,destinatario);
                break;
                //ENCUESTA
            case Token.OBTENERENCUESTA:
                obtenerEncuestas(analex,destinatario);
                break;
            case Token.REGISTRARENCUESTA:
                registrarEncuesta(analex,destinatario);
                break;
            case Token.ELIMINARENCUESTA:
                eliminarEncuesta(analex,destinatario);
                break;
                //FACULTAD
            case Token.OBTENERFACULTAD:
                obtenerFacultad(analex,destinatario);
                break;
            case Token.REGISTRARFACULTAD:
                registrarFacultad(analex,destinatario);
                break;
            case Token.ELIMINARFACULTAD:
                eliminarFacultad(analex,destinatario);
                break;
            case Token.MODIFICARFACULTAD:
                modificarFacultad(analex,destinatario);
                break;
                //DETALLEUSUARIOENCUESTA
            case Token.OBTENERDETALLEUSUARIOENCUESTA:
                obtenerDetalleUsuarioEncuestas(analex,destinatario);
                break;
            case Token.REGISTRARDETALLEUSUARIOENCUESTA:
                registrarDetalleUsuarioEncuesta(analex,destinatario);
                break;
            case Token.ELIMINARDETALLEUSUARIOENCUESTA:
                eliminarDetalleUsuarioEncuesta(analex,destinatario);
                break;
                
        }
    }


    private void obtenerUsuarios(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTabla(usuarioNegocio.obtenerUsuarios());
        ClienteSMTP.sendMail(correoDest, "Obtener Usuarios", message);
    }

    private void registrarUsuario(Analex analex, String correoDest) {
         // Obtengo el Siguiente token
         System.out.println("ENTRO AQUI registrarUsuario");
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        analex.Avanzar();
        // Atributos
        String nombre = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String ci = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String cargo = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        Date fechanacimiento = Utils.convertirFechas(Utils.quitarComillas(analex.Preanalisis().getToStr()));
        analex.Avanzar();
        analex.Avanzar();
        String sexo = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String direccion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        usuarioNegocio.registrarUsuario(nombre, ci, cargo, fechanacimiento, sexo, direccion);
        ClienteSMTP.sendMail(correoDest, "Registrar Usuario", "Registro realizado Correctamente");
    }

    private void eliminarUsuario(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        usuarioNegocio.eliminarUsuario(id);
        ClienteSMTP.sendMail(correoDest, "Eliminar Usuario", "Eliminacion Completada Satisfactoriamente");
    }

    private void modificarUsuario(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_MODIFICARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        analex.Avanzar();
        // Atributos
        // int telefono = analex.Preanalisis().getAtributo();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        String nombre = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String ci = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String cargo = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        Date fechanacimiento = Utils.convertirFechas(Utils.quitarComillas(analex.Preanalisis().getToStr()));
        analex.Avanzar();
        analex.Avanzar();
        String sexo = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String direccion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        usuarioNegocio.modificarUsuario(id,nombre, ci, cargo, fechanacimiento, sexo, direccion);
        ClienteSMTP.sendMail(correoDest, "Registrar Usuario", "Registro realizado Correctamente");
    }

    private void obtenerNivelIndicador(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        NivelIndicadorNegocio nivelIndicadorNegocio = new NivelIndicadorNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTabla(nivelIndicadorNegocio.obtenerNivelIndicadors());
        ClienteSMTP.sendMail(correoDest, "Obtener NivelIndicador", message);
    }

    private void registrarNivelIndicador(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        NivelIndicadorNegocio nivelIndicadorNegocio = new NivelIndicadorNegocio();
        analex.Avanzar();
        // Atributos
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String metrica = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int idnivelmodelo = analex.Preanalisis().getAtributo();

        nivelIndicadorNegocio.registrarNivelIndicador(descripcion,metrica,idnivelmodelo);
        ClienteSMTP.sendMail(correoDest, "Registrar NivelIndicador", "Registro realizado Correctamente");
    }

    private void eliminarNivelIndicador(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        NivelIndicadorNegocio nivelIndicadorNegocio = new NivelIndicadorNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        
        nivelIndicadorNegocio.eliminarNivelIndicador(id);
        ClienteSMTP.sendMail(correoDest, "Eliminar NivelIndicador", "Eliminacion Completada Satisfactoriamente");
    }

    private void modificarNivelIndicador(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_MODIFICARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        NivelIndicadorNegocio nivelIndicadorNegocio = new NivelIndicadorNegocio();
        analex.Avanzar();
        // Atributos
        // int telefono = analex.Preanalisis().getAtributo();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String metrica = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int idnivelmodelo = analex.Preanalisis().getAtributo();
        
        nivelIndicadorNegocio.modificarNivelIndicador(id,descripcion,metrica,idnivelmodelo);
        ClienteSMTP.sendMail(correoDest, "Modificado NivelIndicador", "Registro realizado Correctamente");
    }
    private void obtenerTipoEncuesta(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        TipoEncuestaNegocio tipoEncuestaNegocio = new TipoEncuestaNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTabla(tipoEncuestaNegocio.obtenerTipoEncuestas());
        ClienteSMTP.sendMail(correoDest, "Obtener TipoEncuesta", message);
    }

    private void registrarTipoEncuesta(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        TipoEncuestaNegocio tipoEncuestaNegocio = new TipoEncuestaNegocio();
        analex.Avanzar();
        // Atributos
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        //analex.Avanzar();
        //analex.Avanzar();
        tipoEncuestaNegocio.registrarTipoEncuesta(descripcion);
        ClienteSMTP.sendMail(correoDest, "Registrar TipoEncuesta", "Registro realizado Correctamente");
    }

    private void eliminarTipoEncuesta(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        TipoEncuestaNegocio tipoEncuestaNegocio = new TipoEncuestaNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        tipoEncuestaNegocio.eliminarTipoEncuesta(id);
        ClienteSMTP.sendMail(correoDest, "Eliminar TipoEncuesta", "Eliminacion Completada Satisfactoriamente");
    }

    private void modificarTipoEncuesta(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_MODIFICARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        TipoEncuestaNegocio tipoEncuestaNegocio = new TipoEncuestaNegocio();
        analex.Avanzar();
        // Atributos
        // int telefono = analex.Preanalisis().getAtributo();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        tipoEncuestaNegocio.modificarTipoEncuesta(id,descripcion);
        ClienteSMTP.sendMail(correoDest, "Modificado TipoEncuesta", "Registro realizado Correctamente");
    }
    private void obtenerNivelModelo(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        NivelModeloNegocio nivelModeloNegocio = new NivelModeloNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTabla(nivelModeloNegocio.obtenerNivelModelos());
        ClienteSMTP.sendMail(correoDest, "Obtener NivelModelo", message);
    }

    private void registrarNivelModelo(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        NivelModeloNegocio nivelModeloNegocio = new NivelModeloNegocio();
        analex.Avanzar();
        // Atributos
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        //analex.Avanzar();
        //analex.Avanzar();
        nivelModeloNegocio.registrarNivelModelo(descripcion);
        ClienteSMTP.sendMail(correoDest, "Registrar NivelModelo", "Registro realizado Correctamente");
    }

    private void eliminarNivelModelo(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        NivelModeloNegocio nivelModeloNegocio = new NivelModeloNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        nivelModeloNegocio.eliminarNivelModelo(id);
        ClienteSMTP.sendMail(correoDest, "Eliminar NivelModelo", "Eliminacion Completada Satisfactoriamente");
    }

    private void modificarNivelModelo(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_MODIFICARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        NivelModeloNegocio nivelModeloNegocio = new NivelModeloNegocio();
        analex.Avanzar();
        // Atributos
        // int telefono = analex.Preanalisis().getAtributo();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        nivelModeloNegocio.modificarNivelModelo(id,descripcion);
        ClienteSMTP.sendMail(correoDest, "Modificado NivelModelo", "Registro realizado Correctamente");
    }
    
    private void obtenerEncuestas(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        EncuestaNegocio encuestaNegocio = new EncuestaNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTabla(encuestaNegocio.obtenerEncuestas());
        ClienteSMTP.sendMail(correoDest, "Obtener Encuestas", message);
        
    }
    
    private void registrarEncuesta(Analex analex, String correoDest) {
         // Obtengo el Siguiente token
         System.out.println("ENTRO AQUI registrarEncuesta");
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
            return;
        }
        //int cantidadmiembros, int cuantificacionmadurez, String descripcion, int evaluacion, int idnivelindicador, int idtipoencuesta,Date fecha
        // Sino, ejecutar el comando
        EncuestaNegocio encuestaNegocio = new EncuestaNegocio();
        analex.Avanzar();
        // Atributos
        //int id = analex.Preanalisis().getAtributo();
        int idfacultad = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idnivelmodelo = analex.Preanalisis().getAtributo();
        encuestaNegocio.registrarEncuesta(idfacultad, idnivelmodelo);
        ClienteSMTP.sendMail(correoDest, "Registrar Encuesta", "Registro realizado Correctamente");
    }

    private void eliminarEncuesta(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        EncuestaNegocio encuestaNegocio = new EncuestaNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        encuestaNegocio.eliminarEncuesta(id);
        ClienteSMTP.sendMail(correoDest, "Eliminar Encuesta", "Eliminacion Completada Satisfactoriamente");
    }


    private void obtenerFacultad(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        FacultadNegocio facultadNegocio = new FacultadNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTabla(facultadNegocio.obtenerFacultads());
        ClienteSMTP.sendMail(correoDest, "Obtener Facultad", message);
    }

    private void registrarFacultad(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        FacultadNegocio facultadNegocio = new FacultadNegocio();
        analex.Avanzar();
        // Atributos
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        //analex.Avanzar();
        //analex.Avanzar();
        facultadNegocio.registrarFacultad(descripcion);
        ClienteSMTP.sendMail(correoDest, "Registrar Facultad", "Registro realizado Correctamente");
    }

    private void eliminarFacultad(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        FacultadNegocio facultadNegocio = new FacultadNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        facultadNegocio.eliminarFacultad(id);
        ClienteSMTP.sendMail(correoDest, "Eliminar Facultad", "Eliminacion Completada Satisfactoriamente");
    }

    private void modificarFacultad(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_MODIFICARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        FacultadNegocio facultadNegocio = new FacultadNegocio();
        analex.Avanzar();
        // Atributos
        // int telefono = analex.Preanalisis().getAtributo();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        facultadNegocio.modificarFacultad(id,descripcion);
        ClienteSMTP.sendMail(correoDest, "Modificado Facultad", "Registro realizado Correctamente");
    }
    
    private void obtenerDetalleUsuarioEncuestas(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        DetalleUsuarioEncuestaNegocio detalleUsuarioEncuestaNegocio = new DetalleUsuarioEncuestaNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTabla(detalleUsuarioEncuestaNegocio.obtenerDetalleUsuarioEncuestas());
        ClienteSMTP.sendMail(correoDest, "Obtener DetalleUsuarioEncuestas", message);
        
    }
    
    private void registrarDetalleUsuarioEncuesta(Analex analex, String correoDest) {
         // Obtengo el Siguiente token
         System.out.println("ENTRO AQUI registrarDetalleUsuarioEncuesta");
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
            return;
        }
        //int cantidadmiembros, int cuantificacionmadurez, String descripcion, int evaluacion, int idnivelindicador, int idtipodetalleUsuarioEncuesta,Date fecha
        // Sino, ejecutar el comando
        DetalleUsuarioEncuestaNegocio detalleUsuarioEncuestaNegocio = new DetalleUsuarioEncuestaNegocio();
        analex.Avanzar();
        // Atributos
        //int id = analex.Preanalisis().getAtributo();
        int idencuesta = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idnivelmodelo = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idnivelindicador = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idusuario = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int respuesta = analex.Preanalisis().getAtributo();
        detalleUsuarioEncuestaNegocio.registrarDetalleUsuarioEncuesta(idencuesta, idnivelmodelo,idnivelindicador,idusuario,respuesta);
        ClienteSMTP.sendMail(correoDest, "Registrar DetalleUsuarioEncuesta", "Registro realizado Correctamente");
    }

    private void eliminarDetalleUsuarioEncuesta(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        DetalleUsuarioEncuestaNegocio detalleUsuarioEncuestaNegocio = new DetalleUsuarioEncuestaNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        detalleUsuarioEncuestaNegocio.eliminarDetalleUsuarioEncuesta(id);
        ClienteSMTP.sendMail(correoDest, "Eliminar DetalleUsuarioEncuesta", "Eliminacion Completada Satisfactoriamente");
    }

 
    
}
