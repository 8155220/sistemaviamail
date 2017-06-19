/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correos.acropolis.software;

import correos.acropolis.procesador.Analex;
import correos.acropolis.procesador.Cinta;
import correos.acropolis.procesador.Parser;
import correos.acropolis.procesador.Token;
import correos.acropolis.utils.Utils;

/**
 *
 * @author mauriballes
 */
public class NuevaAcropolisMail {

    public void processMessage(String Message) {
        // Setteando Variables
        String destinatario = Utils.getDestinatario(Message);
        String content = Utils.getSubjectOrden(Message);
        Cinta cinta = new Cinta(content);
        Analex analex = new Analex(cinta);
        Parser parser = new Parser(analex);

        // Verificar Orden
        parser.Expresion();
        if (parser.errorFlag) {
            // Enviar Correo de Error
            return;
        }

        // Si todo va bien, procesar el Comando
        analex.Init();
        Token token = analex.Preanalisis();

        if (token.getNombre() == Token.HELP) {
            // Mostrar Ayudas
            // Enviar Correo con ayudas
            return;
        }

        // Sino es HELP, es una funcionalidad
        switch (token.getNombre()) {
            case Token.OBTENERALUMNOS:
                obtenerAlumnos(analex, destinatario);
                break;
            case Token.REGISTRARALUMNO:
                registrarAlumno(analex, destinatario);
                break;
            case Token.MODIFICARALUMNO:
                modificarAlumno(analex, destinatario);
                break;
            case Token.OBTENERPROFESORES:
                obtenerProfesores(analex, destinatario);
                break;
            case Token.REGISTRARPROFESOR:
                registrarProfesor(analex, destinatario);
                break;
            case Token.MODIFICARPROFESOR:
                modificarProfesor(analex, destinatario);
                break;
            case Token.OBTENERINSCRIPCIONES:
                obtenerInscripciones(analex, destinatario);
                break;
            case Token.OBTENERDETALLEINSCRIPCION:
                obtenerDetalleInscripcion(analex, destinatario);
                break;
            case Token.OBTENERCURSOSHABILITADOS:
                obtenerCursosHabilitados(analex, destinatario);
                break;
            case Token.REGISTRARINSCRIPCION:
                registrarInscripcion(analex, destinatario);
                break;
            case Token.MODIFICARINSCRIPCION:
                modificarInscripcion(analex, destinatario);
                break;
            case Token.ADICIONARGRUPOS:
                adicionarGrupos(analex, destinatario);
                break;
            case Token.RETIRARGRUPOS:
                retirarGrupos(analex, destinatario);
                break;
            case Token.OBTENERCURSOS:
                obtenerCursos(analex, destinatario);
                break;
            case Token.OBTENERPREREQUISITOS:
                obtenerPrerequisitos(analex, destinatario);
                break;
            case Token.REGISTRARCURSO:
                registrarCurso(analex, destinatario);
                break;
            case Token.MODIFICARCURSO:
                modificarCurso(analex, destinatario);
                break;
            case Token.OBTENERGRUPOS:
                obtenerGrupos(analex, destinatario);
                break;
            case Token.OBTENERHORARIOS:
                obtenerHorarios(analex, destinatario);
                break;
            case Token.REGISTRARGRUPO:
                registrarGrupo(analex, destinatario);
                break;
            case Token.MODIFICARGRUPO:
                modificarGrupo(analex, destinatario);
                break;
            case Token.ASIGNARGRUPO:
                asignarGrupo(analex, destinatario);
                break;
            case Token.REGISTRARHORARIO:
                registrarHorario(analex, destinatario);
                break;
            case Token.MODIFICARHORARIO:
                modificarHorario(analex, destinatario);
                break;
            case Token.ELIMINARHORARIO:
                eliminarHorario(analex, destinatario);
                break;
            case Token.OBTENERAULAS:
                obtenerAulas(analex, destinatario);
                break;
            case Token.REGISTRARAULA:
                registrarAula(analex, destinatario);
                break;
            case Token.MODIFICARAULA:
                modificarAula(analex, destinatario);
                break;
            case Token.OBTENERKARDEXS:
                obtenerKardexs(analex, destinatario);
                break;
            case Token.OBTENERASISTENCIAS:
                obtenerAsistencias(analex, destinatario);
                break;
            case Token.REGISTRARASISTENCIAS:
                registrarAsistencia(analex, destinatario);
                break;
            case Token.MODIFICARASISTENCIAS:
                modificarAsistencia(analex, destinatario);
                break;
            case Token.REGISTRARNOTA:
                registrarNota(analex, destinatario);
                break;
            case Token.REPORTEHISTORICO:
                reporteHistorico(analex, destinatario);
                break;
            case Token.REPORTEALUMNOSINSCRITOS:
                reporteAlumnosInscritos(analex, destinatario);
                break;
            case Token.REPORTEOFERTACURSOS:
                reporteOfertaCursos(analex, destinatario);
                break;
            case Token.AGREGARPREREQUISITO:
                agregarPrerequisito(analex, destinatario);
                break;
            case Token.QUITARPREREQUISITO:
                quitarPrerequisito(analex, destinatario);
                break;
        }
    }

    public void obtenerAlumnos(Analex analex, String correoDest) {

    }

    public void registrarAlumno(Analex analex, String correoDest) {

    }

    public void modificarAlumno(Analex analex, String correoDest) {

    }

    public void registrarProfesor(Analex analex, String correoDest) {

    }

    public void modificarProfesor(Analex analex, String correoDest) {

    }

    public void obtenerProfesores(Analex analex, String correoDest) {

    }

    public void obtenerInscripciones(Analex analex, String correoDest) {

    }

    public void obtenerDetalleInscripcion(Analex analex, String correoDest) {

    }

    public void obtenerCursosHabilitados(Analex analex, String correoDest) {

    }

    public void registrarInscripcion(Analex analex, String correoDest) {

    }

    public void modificarInscripcion(Analex analex, String correoDest) {

    }

    public void adicionarGrupos(Analex analex, String correoDest) {

    }

    public void retirarGrupos(Analex analex, String correoDest) {

    }

    public void obtenerCursos(Analex analex, String correoDest) {

    }

    public void obtenerPrerequisitos(Analex analex, String correoDest) {

    }

    public void registrarCurso(Analex analex, String correoDest) {

    }

    public void modificarCurso(Analex analex, String correoDest) {

    }

    public void obtenerGrupos(Analex analex, String correoDest) {

    }

    public void obtenerHorarios(Analex analex, String correoDest) {

    }

    public void registrarGrupo(Analex analex, String correoDest) {

    }

    public void modificarGrupo(Analex analex, String correoDest) {

    }

    public void asignarGrupo(Analex analex, String correoDest) {

    }

    public void registrarHorario(Analex analex, String correoDest) {

    }

    public void modificarHorario(Analex analex, String correoDest) {

    }

    public void eliminarHorario(Analex analex, String correoDest) {

    }

    public void obtenerAulas(Analex analex, String correoDest) {

    }

    public void registrarAula(Analex analex, String correoDest) {

    }

    public void modificarAula(Analex analex, String correoDest) {

    }

    public void obtenerKardexs(Analex analex, String correoDest) {

    }

    public void registrarAsistencia(Analex analex, String correoDest) {

    }

    public void modificarAsistencia(Analex analex, String correoDest) {

    }

    public void obtenerAsistencias(Analex analex, String correoDest) {

    }

    public void registrarNota(Analex analex, String correoDest) {

    }

    public void reporteHistorico(Analex analex, String correoDest) {

    }

    public void reporteAlumnosInscritos(Analex analex, String correoDest) {

    }

    public void reporteOfertaCursos(Analex analex, String correoDest) {

    }

    public void agregarPrerequisito(Analex analex, String correoDest) {

    }

    public void quitarPrerequisito(Analex analex, String correoDest) {

    }
}