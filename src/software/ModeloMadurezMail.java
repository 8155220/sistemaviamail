/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

import Negocio.DetalleUsuarioEncuestaNegocio;
import Negocio.EncuestaNegocio;
import Negocio.FacultadNegocio;
import Negocio.IndicadorNegocio;
import Negocio.NivelModeloNegocio;
import Negocio.TipoUsuarioNegocio;
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
            ClienteSMTP.sendHtmlMail(destinatario, "Error de Comando",
                    "El comando introducido es incorrecto, trate consultando las ayudas con el comando HELP"
            );
            return;
        }

        // Si todo va bien, procesar el Comando
        analex.Init();
        Token token = analex.Preanalisis();

        if (token.getNombre() == Token.HELP) {
            // Mostrar Ayudas
            ClienteSMTP.sendHtmlMail(destinatario, "Asistencia - Servicio Email", Helper.HELP_GLOBAL);
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
            case Token.OBTENERINDICADOR:
                obtenerIndicador(analex,destinatario);
                break;
            case Token.REGISTRARINDICADOR:
                registrarIndicador(analex,destinatario);
                break;
            case Token.ELIMINARINDICADOR:
                eliminarIndicador(analex,destinatario);
                break;
            case Token.MODIFICARINDICADOR:
                modificarIndicador(analex,destinatario);
                break;
                //TIPOUSUARIO
            case Token.OBTENERTIPOUSUARIO:
                obtenerTipoUsuario(analex,destinatario);
                break;
            case Token.REGISTRARTIPOUSUARIO:
                registrarTipoUsuario(analex,destinatario);
                break;
            case Token.ELIMINARTIPOUSUARIO:
                eliminarTipoUsuario(analex,destinatario);
                break;
            case Token.MODIFICARTIPOUSUARIO:
                modificarTipoUsuario(analex,destinatario);
                break;
                //MODELO
            case Token.OBTENERMODELO:
                obtenerNivelModelo(analex,destinatario);
                break;
            case Token.REGISTRARMODELO:
                registrarNivelModelo(analex,destinatario);
                break;
            case Token.ELIMINARMODELO:
                eliminarNivelModelo(analex,destinatario);
                break;
            case Token.MODIFICARMODELO:
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
            case Token.OBTENERUSUARIOENCUESTA:
                obtenerUsuarioEncuesta(analex,destinatario);
                break;
            case Token.OBTENERRESULTADOUSUARIO:
                obtenerResultadoUsuario(analex,destinatario);
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
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTablaHTML(usuarioNegocio.obtenerUsuarios());
        ClienteSMTP.sendHtmlMail(correoDest, "Obtener Usuarios", message);
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
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        analex.Avanzar();

        String name = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String email = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String password = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String apellido = Utils.quitarComillas(analex.Preanalisis().getToStr());
        //Date apellido = Utils.convertirFechas(Utils.quitarComillas(analex.Preanalisis().getToStr())); --> para fecha
        analex.Avanzar();
        analex.Avanzar();
        String ci = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int idtipusuario = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idfacultad = analex.Preanalisis().getAtributo();
        
       
        usuarioNegocio.registrarUsuario(name, email, password, apellido, ci, idtipusuario,idfacultad);
        ClienteSMTP.sendHtmlMail(correoDest, "Registrar Usuario", "Registro realizado Correctamente");
    }

    private void eliminarUsuario(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        usuarioNegocio.eliminarUsuario(id);
        ClienteSMTP.sendHtmlMail(correoDest, "Eliminar Usuario", "Eliminacion Completada Satisfactoriamente");
    }

    private void modificarUsuario(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_MODIFICARALUMNO);
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
        
        String name = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String apellido = Utils.quitarComillas(analex.Preanalisis().getToStr());
        //Date apellido = Utils.convertirFechas(Utils.quitarComillas(analex.Preanalisis().getToStr())); --> para fecha
        analex.Avanzar();
        analex.Avanzar();
        String ci = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int idtipousuario = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idfacultad = analex.Preanalisis().getAtributo();
        usuarioNegocio.modificarUsuario(id,name, apellido, ci, idtipousuario,idfacultad);
        ClienteSMTP.sendHtmlMail(correoDest, "Registrar Usuario", "Registro realizado Correctamente");
    }

    private void obtenerIndicador(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        IndicadorNegocio nivelIndicadorNegocio = new IndicadorNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTablaHTML(nivelIndicadorNegocio.obtenerIndicadors());
        ClienteSMTP.sendHtmlMail(correoDest, "Obtener Indicador", message);
    }

    private void registrarIndicador(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        IndicadorNegocio nivelIndicadorNegocio = new IndicadorNegocio();
        analex.Avanzar();
        // Atributos
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String metrica = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int idnivelmodelo = analex.Preanalisis().getAtributo();

        nivelIndicadorNegocio.registrarIndicador(descripcion,metrica,idnivelmodelo);
        ClienteSMTP.sendHtmlMail(correoDest, "Registrar Indicador", "Registro realizado Correctamente");
    }

    private void eliminarIndicador(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        IndicadorNegocio nivelIndicadorNegocio = new IndicadorNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        
        nivelIndicadorNegocio.eliminarIndicador(id);
        ClienteSMTP.sendHtmlMail(correoDest, "Eliminar Indicador", "Eliminacion Completada Satisfactoriamente");
    }

    private void modificarIndicador(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_MODIFICARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        IndicadorNegocio nivelIndicadorNegocio = new IndicadorNegocio();
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
        
        nivelIndicadorNegocio.modificarIndicador(id,descripcion,metrica,idnivelmodelo);
        ClienteSMTP.sendHtmlMail(correoDest, "Modificado Indicador", "Registro realizado Correctamente");
    }
    
    private void obtenerTipoUsuario(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        TipoUsuarioNegocio tipoEncuestaNegocio = new TipoUsuarioNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTablaHTML(tipoEncuestaNegocio.obtenerTipoUsuarios());
        ClienteSMTP.sendHtmlMail(correoDest, "Obtener TipoUsuario", message);
    }

    private void registrarTipoUsuario(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        TipoUsuarioNegocio tipoEncuestaNegocio = new TipoUsuarioNegocio();
        analex.Avanzar();
        // Atributos
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        //analex.Avanzar();
        //analex.Avanzar();
        tipoEncuestaNegocio.registrarTipoUsuario(descripcion);
        ClienteSMTP.sendHtmlMail(correoDest, "Registrar TipoUsuario", "Registro realizado Correctamente");
    }

    private void eliminarTipoUsuario(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        TipoUsuarioNegocio tipoEncuestaNegocio = new TipoUsuarioNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        tipoEncuestaNegocio.eliminarTipoUsuario(id);
        ClienteSMTP.sendHtmlMail(correoDest, "Eliminar TipoUsuario", "Eliminacion Completada Satisfactoriamente");
    }

    private void modificarTipoUsuario(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_MODIFICARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        TipoUsuarioNegocio tipoEncuestaNegocio = new TipoUsuarioNegocio();
        analex.Avanzar();
        // Atributos
        // int telefono = analex.Preanalisis().getAtributo();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        String descripcion = Utils.quitarComillas(analex.Preanalisis().getToStr());
        tipoEncuestaNegocio.modificarTipoUsuario(id,descripcion);
        ClienteSMTP.sendHtmlMail(correoDest, "Modificado TipoUsuario", "Registro realizado Correctamente");
    }
    private void obtenerNivelModelo(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        NivelModeloNegocio nivelModeloNegocio = new NivelModeloNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        //String message = Utils.dibujarTablaHTML(nivelModeloNegocio.obtenerNivelModelos()); //ORIGINAL
        String message = Utils.dibujarTablaHTML(nivelModeloNegocio.obtenerNivelModelos());
        //ClienteSMTP.sendHtmlMail(correoDest, "Obtener NivelModelo", message);//ORIGINAL
        ClienteSMTP.sendHtmlMail(correoDest, "Obtener NivelModelo", message);
    }

    private void registrarNivelModelo(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
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
        ClienteSMTP.sendHtmlMail(correoDest, "Registrar NivelModelo", "Registro realizado Correctamente");
    }

    private void eliminarNivelModelo(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        NivelModeloNegocio nivelModeloNegocio = new NivelModeloNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        nivelModeloNegocio.eliminarNivelModelo(id);
        ClienteSMTP.sendHtmlMail(correoDest, "Eliminar NivelModelo", "Eliminacion Completada Satisfactoriamente");
    }

    private void modificarNivelModelo(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_MODIFICARALUMNO);
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
        ClienteSMTP.sendHtmlMail(correoDest, "Modificado NivelModelo", "Registro realizado Correctamente");
    }
    
    private void obtenerEncuestas(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        EncuestaNegocio encuestaNegocio = new EncuestaNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTablaHTML(encuestaNegocio.obtenerEncuestas());
        ClienteSMTP.sendHtmlMail(correoDest, "Obtener Encuestas", message);
        
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
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
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
        String fechainicio = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String fechafin = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int idusuario1 = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idusuario2 = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idusuario3 = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idusuario4 = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idusuario5 = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idusuario6 = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idusuario7 = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idusuario8 = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idusuario9 = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idusuario10 = analex.Preanalisis().getAtributo();
        
        encuestaNegocio.registrarEncuesta(idfacultad, fechainicio,fechafin,idusuario1,idusuario2,idusuario3,idusuario4,idusuario5,idusuario6,idusuario7,idusuario8,idusuario9,idusuario10);
        ClienteSMTP.sendHtmlMail(correoDest, "Registrar Encuesta", "Registro realizado Correctamente");
    }

    private void eliminarEncuesta(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        EncuestaNegocio encuestaNegocio = new EncuestaNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        encuestaNegocio.eliminarEncuesta(id);
        ClienteSMTP.sendHtmlMail(correoDest, "Eliminar Encuesta", "Eliminacion Completada Satisfactoriamente");
    }


    private void obtenerFacultad(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        FacultadNegocio facultadNegocio = new FacultadNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTablaHTML(facultadNegocio.obtenerFacultads());
        ClienteSMTP.sendHtmlMail(correoDest, "Obtener Facultad", message);
    }

    private void registrarFacultad(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
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
        ClienteSMTP.sendHtmlMail(correoDest, "Registrar Facultad", "Registro realizado Correctamente");
    }

    private void eliminarFacultad(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        FacultadNegocio facultadNegocio = new FacultadNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        facultadNegocio.eliminarFacultad(id);
        ClienteSMTP.sendHtmlMail(correoDest, "Eliminar Facultad", "Eliminacion Completada Satisfactoriamente");
    }

    private void modificarFacultad(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_MODIFICARALUMNO);
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
        ClienteSMTP.sendHtmlMail(correoDest, "Modificado Facultad", "Registro realizado Correctamente");
    }
    
    private void obtenerDetalleUsuarioEncuestas(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        DetalleUsuarioEncuestaNegocio detalleUsuarioEncuestaNegocio = new DetalleUsuarioEncuestaNegocio();
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTablaHTML(detalleUsuarioEncuestaNegocio.obtenerDetalleUsuarioEncuestas());
        ClienteSMTP.sendHtmlMail(correoDest, "Obtener DetalleUsuarioEncuestas", message);
        
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
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_REGISTRARALUMNO);
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
        ClienteSMTP.sendHtmlMail(correoDest, "Registrar DetalleUsuarioEncuesta", "Registro realizado Correctamente");
    }

    private void eliminarDetalleUsuarioEncuesta(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_ELIMINARHORARIO);
            return;
        }

        // Sino, ejecutar el comando
        DetalleUsuarioEncuestaNegocio detalleUsuarioEncuestaNegocio = new DetalleUsuarioEncuestaNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        detalleUsuarioEncuestaNegocio.eliminarDetalleUsuarioEncuesta(id);
        ClienteSMTP.sendHtmlMail(correoDest, "Eliminar DetalleUsuarioEncuesta", "Eliminacion Completada Satisfactoriamente");
    }

    private void obtenerUsuarioEncuesta(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        EncuestaNegocio encuestaNegocio = new EncuestaNegocio();
        
        //
        analex.Avanzar();
        int idencuesta = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        //
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTablaHTML(encuestaNegocio.obtenerUsuarioEncuesta(idencuesta));
        ClienteSMTP.sendHtmlMail(correoDest, "Obtener Usuarios de Encuesta", message);
    }

    private void obtenerResultadoUsuario(Analex analex, String correoDest) {
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendHtmlMail(correoDest, "Asistencia - Servicio Email", Helper.HELP_OBTENERALUMNOS);
            return;
        }
        EncuestaNegocio encuestaNegocio = new EncuestaNegocio();
        
        //
        analex.Avanzar();
        int idencuesta = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        int idusuario = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        //
        // Sino, ejecutar el comando
        //AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTablaHTML(encuestaNegocio.obtenerResultadoUsuario(idencuesta,idusuario));
        ClienteSMTP.sendHtmlMail(correoDest, "Obtener Usuarios de Encuesta", message);
    }

 
    
}
