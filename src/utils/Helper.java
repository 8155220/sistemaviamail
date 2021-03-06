/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author mauriballes
 */
public class Helper {

    public static final String HELP_GLOBAL = "Bienvenido!!!\n\n"
            + "A continuacion se listaran los comandos disponibles para interactuar con el sistema\n"
            + "Para acceder a la documentacion de cada uno, enviar el nombre del comando seguido de la palabra HELP\n\n"
            + "OBTENERALUMNOS\n"
            + "REGISTRARALUMNO\n"
            + "MODIFICARALUMNO\n"
            + "OBTENERPROFESORES\n"
            + "REGISTRARPROFESOR\n"
            + "MODIFICARPROFESOR\n"
            + "OBTENERINSCRIPCIONES\n"
            + "OBTENERDETALLEINSCRIPCION\n"
            + "OBTENERCURSOSHABILITADOS\n"
            + "REGISTRARINSCRIPCION\n"
            + "MODIFICARINSCRIPCION\n"
            + "ADICIONARGRUPOS\n"
            + "RETIRARGRUPOS\n"
            + "OBTENERCURSOS\n"
            + "OBTENERPREREQUISITOS\n"
            + "REGISTRARCURSO\n"
            + "MODIFICARCURSO\n"
            + "OBTENERGRUPOS\n"
            + "OBTENERHORARIOS\n"
            + "REGISTRARGRUPO\n"
            + "MODIFICARGRUPO\n"
            + "ASIGNARGRUPO\n"
            + "REGISTRARHORARIO\n"
            + "MODIFICARHORARIO\n"
            + "ELIMINARHORARIO\n"
            + "OBTENERAULAS\n"
            + "REGISTRARAULA\n"
            + "MODIFICARAULA\n"
            + "OBTENERKARDEXS\n"
            + "OBTENERASISTENCIAS\n"
            + "REGISTRARASISTENCIAS\n"
            + "MODIFICARASISTENCIAS\n"
            + "REGISTRARNOTA\n"
            + "REPORTEHISTORICO\n"
            + "REPORTEALUMNOSINSCRITOS\n"
            + "REPORTEOFERTACURSOS\n"
            + "AGREGARPREREQUISITO\n"
            + "QUITARPREREQUISITO";
    public static final String HELP_GLOBAL_HTML = "<style>\n"
            + "    .stringcolor {\n"
            + "        color: green;\n"
            + "    }\n"
            + "    .intcolor {\n"
            + "        color: blue;\n"
            + "    }\n"
            + "\n"
            + "</style>\n"
            + "\n"
            + "<!--CASO DE USO  USUARIOS-->\n"
            + "<table border=\"1\" width=\"100%\">\n"
            + "    <thead>\n"
            + "    <tr ><td COLSPAN=\"3\" align=\"center\" style='font-weight:bold'>Caso de uso Gestionar Usuarios</td></tr>\n"
            + "    </thead>\n"
            + "\n"
            + "    <tbody>\n"
            + "    <tr >\n"
            + "        <td style='font-weight:bold'>COMANDO</td>\n"
            + "        <td style='font-weight:bold'>DESCRIPCION</td>\n"
            + "        <td style='font-weight:bold'>EJEMPLO</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>OBTENERUSUARIOS</td>\n"
            + "        <td>Devuelve una lista de todos los usuarios</td>\n"
            + "        <td>----------------------</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>REGISTRARUSUARIO [<span class=\"stringcolor\">String</span>  nombre,<span class=\"stringcolor\">String</span>  email,<span class=\"stringcolor\">String</span>  password,<span class=\"stringcolor\">String</span>  apellido,<span class=\"stringcolor\">String</span>  ci, <span class=\"intcolor\">int</span>  idtipousuario,<span class=\"intcolor\">int</span>  idfacultad]</td>\n"
            + "        <td>Registra Un Usuario en la base de datos</td>\n"
            + "        <td>REGISTRARUSUARIO [\"PEPE\",\"pepe@gmail.com\",\"123456\",\"linares\",\"65456465\",1,1]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>MODIFICARUSUARIO [<span class=\"intcolor\">int</span>  idusuario,<span class=\"stringcolor\">String</span>  nombre,<span class=\"stringcolor\">String</span>  apellido,<span class=\"stringcolor\">String</span>  ci,<span class=\"intcolor\">int</span>  idtipousuario,<span class=\"intcolor\">int</span>  idfacultad]</td>\n"
            + "        <td>Modifica Un Usuario en la base de datos</td>\n"
            + "        <td>MODIFICARUSUARIO [955,\"PEPEMODIFICADO\",\"linares\",\"65456465\",1,1]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>ELIMINARUSUARIO [<span class=\"intcolor\">int</span>  idusuario]</td>\n"
            + "        <td>Elimina Un Usuario de la base de datos</td>\n"
            + "        <td>ELIMINARUSUARIO [955]</td>\n"
            + "    </tr>\n"
            + "</table>\n"
            + "<br>\n"
            + "<!--CASO DE USO  FACULTAD-->\n"
            + "<table border=\"1\" width=\"100%\">\n"
            + "    <thead>\n"
            + "    <tr ><td COLSPAN=\"3\" align=\"center\" style='font-weight:bold'>Caso de uso Gestionar FACULTAD</td></tr>\n"
            + "    </thead>\n"
            + "\n"
            + "    <tbody>\n"
            + "    <tr >\n"
            + "        <td style='font-weight:bold'>COMANDO</td>\n"
            + "        <td style='font-weight:bold'>DESCRIPCION</td>\n"
            + "        <td style='font-weight:bold'>EJEMPLO</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>OBTENERFACULTAD</td>\n"
            + "        <td>Devuelve una lista de todos las facultades</td>\n"
            + "        <td>----------------------</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>REGISTRARFACULTAD [<span class=\"stringcolor\">String</span>  Descripcion] </td>\n"
            + "        <td>Registra una Facultad en la base de datos</td>\n"
            + "        <td>REGISTRARFACULTAD [\"nombreFacultad\"]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>MODIFICARFACULTAD [<span class=\"intcolor\">int</span>  idfacultad,<span class=\"stringcolor\">String</span>  nuevoNombre]</td>\n"
            + "        <td>Modifica la facultad recibiendo como parametro el id, en la base de datos</td>\n"
            + "        <td>MODIFICARFACULTAD [17,\"FACULTAD_FUTURO\"]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>ELIMINARFACULTAD [<span class=\"intcolor\">int</span>  idfacultad]</td>\n"
            + "        <td>Elimina una facultad en la base de datos</td>\n"
            + "        <td>ELIMINARFACULTAD [18]</td>\n"
            + "    </tr>\n"
            + "</table>\n"
            + "\n"
            + "<br>\n"
            + "<!--CASO DE USO  ENCUESTA-->\n"
            + "<table border=\"1\" width=\"100%\">\n"
            + "    <thead>\n"
            + "    <tr ><td COLSPAN=\"3\" align=\"center\" style='font-weight:bold'>Caso de uso Gestionar ENCUESTA</td></tr>\n"
            + "    </thead>\n"
            + "\n"
            + "    <tbody>\n"
            + "    <tr >\n"
            + "        <td style='font-weight:bold'>COMANDO</td>\n"
            + "        <td style='font-weight:bold'>DESCRIPCION</td>\n"
            + "        <td style='font-weight:bold'>EJEMPLO</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>OBTENERENCUESTA</td>\n"
            + "        <td>Devuelve una lista de todos las facultades</td>\n"
            + "        <td>----------------------</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>REGISTRARENCUESTA [<span class=\"intcolor\">int</span>  idfacultad,Date fechainicio,Date fechafin,<span class=\"intcolor\">int</span>  idusuario1,<span class=\"intcolor\">int</span>  idusuario2,...,<span class=\"intcolor\">int</span>  idusuario10]</td>\n"
            + "        <td>Registra una encuesta en la base de datos</td>\n"
            + "        <td>REGISTRARENCUESTA [4,\"2017-12-19\",\"2017-12-25\",1005,3,4,5,6,7,8,9,10,11]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>ELIMINARENCUESTA [<span class=\"intcolor\">int</span>  idencuesta]</td>\n"
            + "        <td>Elimina una encuesta en la base de datos</td>\n"
            + "        <td>ELIMINARENCUESTA [19]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>OBTENERUSUARIOENCUESTA [<span class=\"intcolor\">int</span>  idencuesta]</td>\n"
            + "        <td>Obtiene la lista de usuarios de esa encuesta, parametro recibe id de encuesta</td>\n"
            + "        <td>OBTENERUSUARIOENCUESTA [1]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>OBTENERRESULTADOUSUARIO [<span class=\"intcolor\">int</span>  idencuesta,<span class=\"intcolor\">int</span>  idusuario]</td>\n"
            + "        <td>Obtiene la lista de respuestas del usuario en esa encuesta, parametro recibe id de encuesta y idusuario</td>\n"
            + "        <td>OBTENERRESULTADOUSUARIO [1,584]</td>\n"
            + "    </tr>\n"
            + "</table>\n"
            + "\n"
            + "<br>\n"
            + "<!--CASO DE USO  TIPOUSUARIO-->\n"
            + "<table border=\"1\" width=\"100%\">\n"
            + "    <thead>\n"
            + "    <tr ><td COLSPAN=\"3\" align=\"center\" style='font-weight:bold'>Caso de uso Gestionar TIPOUSUARIO</td></tr>\n"
            + "    </thead>\n"
            + "\n"
            + "    <tbody>\n"
            + "    <tr >\n"
            + "        <td style='font-weight:bold'>COMANDO</td>\n"
            + "        <td style='font-weight:bold'>DESCRIPCION</td>\n"
            + "        <td style='font-weight:bold'>EJEMPLO</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>OBTENERTIPOUSUARIO</td>\n"
            + "        <td>Devuelve una lista de todos las facultades</td>\n"
            + "        <td>----------------------</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>REGISTRARTIPOUSUARIO [<span class=\"stringcolor\">String</span>  descripcion]</td>\n"
            + "        <td>Registra una tipo de usuario en la base de datos</td>\n"
            + "        <td>REGISTRARTIPOUSUARIO [\"TIPOUSUARIO_1\"]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>MODIFICARTIPOUSUARIO [<span class=\"intcolor\">int</span>  idtipousuario,<span class=\"stringcolor\">String</span>  nuevoNombre]</td>\n"
            + "        <td>Modifica la tipo de usuario recibiendo como parametro el id, en la base de datos</td>\n"
            + "        <td>MODIFICARTIPOUSUARIO [4,\"nuevoNombreTipoUsuario\"]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>ELIMINARTIPOUSUARIO [<span class=\"intcolor\">int</span>  idtipousuario]</td>\n"
            + "        <td>Elimina una tipo de usuario en la base de datos</td>\n"
            + "        <td>ELIMINARTIPOUSUARIO [4]</td>\n"
            + "    </tr>\n"
            + "</table>\n"
            + "\n"
            + "<br>\n"
            + "<!--CASO DE USO  MODELO-->\n"
            + "<table border=\"1\" width=\"100%\">\n"
            + "    <thead>\n"
            + "    <tr ><td COLSPAN=\"3\" align=\"center\" style='font-weight:bold'>Caso de uso Gestionar MODELO</td></tr>\n"
            + "    </thead>\n"
            + "\n"
            + "    <tbody>\n"
            + "    <tr >\n"
            + "        <td style='font-weight:bold'>COMANDO</td>\n"
            + "        <td style='font-weight:bold'>DESCRIPCION</td>\n"
            + "        <td style='font-weight:bold'>EJEMPLO</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>OBTENERMODELO</td>\n"
            + "        <td>Devuelve una lista de todos las facultades</td>\n"
            + "        <td>----------------------</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>REGISTRARMODELO [<span class=\"stringcolor\">String</span>  nombreModelo]</td>\n"
            + "        <td>Registra una modelo en la base de datos</td>\n"
            + "        <td>REGISTRARMODELO [\"MODELO_1\"]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>MODIFICARMODELO [<span class=\"intcolor\">int</span>  idmodelo, <span class=\"stringcolor\">String</span>  nuevoNombre]</td>\n"
            + "        <td>Modifica la modelo recibiendo como parametro el id, en la base de datos</td>\n"
            + "        <td>MODIFICARMODELO [7,\"nuevoNombre\"]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>ELIMINARMODELO [<span class=\"intcolor\">int</span>  idmodelo]</td>\n"
            + "        <td>Elimina una modelo en la base de datos</td>\n"
            + "        <td>ELIMINARMODELO [7]</td>\n"
            + "    </tr>\n"
            + "</table>\n"
            + "\n"
            + "<br>\n"
            + "<!--CASO DE USO  INDICADOR-->\n"
            + "<table border=\"1\" width=\"100%\">\n"
            + "    <thead>\n"
            + "    <tr ><td COLSPAN=\"3\" align=\"center\" style='font-weight:bold'>Caso de uso Gestionar INDICADOR</td></tr>\n"
            + "    </thead>\n"
            + "\n"
            + "    <tbody>\n"
            + "    <tr >\n"
            + "        <td style='font-weight:bold'>COMANDO</td>\n"
            + "        <td style='font-weight:bold'>DESCRIPCION</td>\n"
            + "        <td style='font-weight:bold'>EJEMPLO</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>OBTENERINDICADOR</td>\n"
            + "        <td>Devuelve una lista de todos las facultades</td>\n"
            + "        <td>----------------------</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>REGISTRARINDICADOR [<span class=\"stringcolor\">String</span>  nombreIndicador,<span class=\"stringcolor\">String</span>  descripcionMetrica,<span class=\"intcolor\">int</span>  idmodelo]</td>\n"
            + "        <td>Registra una indicador en la base de datos</td>\n"
            + "        <td>REGISTRARINDICADOR [\"INDICADOR 1\",\"descripcionmetrica\",3]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>MODIFICARINDICADOR[<span class=\"intcolor\">int</span>  idindicador,<span class=\"stringcolor\">String</span>  nombreIndicador,<span class=\"stringcolor\">String</span>  descripcionMetrica,<span class=\"intcolor\">int</span>  idmodelo] </td>\n"
            + "        <td>Modifica la indicador recibiendo como parametro el id, en la base de datos</td>\n"
            + "        <td>MODIFICARINDICADOR [31,\"nombreIndicador\",\"descripcionMetrica\",5]</td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td>ELIMINARINDICADOR [<span class=\"intcolor\">int</span>  idindicador]</td>\n"
            + "        <td>Elimina una indicador en la base de datos</td>\n"
            + "        <td>ELIMINARINDICADOR [31]</td>\n"
            + "    </tr>\n"
            + "</table>";
    public static final String HELP_OBTENERALUMNOS = "Obtener Alumnos!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los alumnos registrados en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    public static final String HELP_REGISTRARALUMNO = "Registrar Alumno!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es registrar a un alumno en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- nombres (String con Comillas Dobles)\n"
            + "- apellidos (String con Comillas Dobles)\n"
            + "- telefono (Entero)\n"
            + "- fecha_nacimiento (String con Comillas Dobles) [\"dd-mm-aaaa\"]\n"
            + "- fecha_ingreso (String con Comillas Dobles) [\"dd-mm-aaaa\"]\n"
            + "- estado (true, false)";
    public static final String HELP_MODIFICARALUMNO = "Modificar Alumno!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar a un alumno en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "- nombres (String con Comillas Dobles)\n"
            + "- apellidos (String con Comillas Dobles)\n"
            + "- telefono (Entero)\n"
            + "- fecha_nacimiento (String con Comillas Dobles) [\"dd-mm-aaaa\"]\n"
            + "- fecha_ingreso (String con Comillas Dobles) [\"dd-mm-aaaa\"]\n"
            + "- estado (true, false)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "nombres, apellidos, telefono, fecha_nacimiento, fecha_ingreso, estado";
    public static final String HELP_OBTENERPROFESORES = "Obtener Profesores!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los profesores registrados en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    public static final String HELP_REGISTRARPROFESOR = "Registrar Profesor!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es registrar a un profesor en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- nombres (String con Comillas Dobles)\n"
            + "- apellidos (String con Comillas Dobles)\n"
            + "- telefono (Entero)\n"
            + "- fecha_postulacion (String con Comillas Dobles) [\"dd-mm-aaaa\"]\n"
            + "- estado (true, false)";
    public static final String HELP_MODIFICARPROFESOR = "Modificar Profesor!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar a un profesor en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "- nombres (String con Comillas Dobles)\n"
            + "- apellidos (String con Comillas Dobles)\n"
            + "- telefono (Entero)\n"
            + "- fecha_postulacion (String con Comillas Dobles) [\"dd-mm-aaaa\"]\n"
            + "- estado (true, false)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "nombres, apellidos, telefono, fecha_postulacion, estado";
    public static final String HELP_OBTENERINSCRIPCIONES = "Obtener Inscripciones!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar las boletas de inscripcion registradas en el sistema,\n"
            + "de un alumno, se debe enviar el id_alumno";
    public static final String HELP_OBTENERDETALLEINSCRIPCION = "Obtener Detalle de Inscripciones!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar el detalle de grupos de las boletas de inscripcion registradas\n"
            + "en el sistema, de un alumno, se debe enviar el id de la boleta";
    public static final String HELP_OBTENERCURSOSHABILITADOS = "Obtener Cursos Habilitados!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los cursos habilitados para inscribir por el alumno\n"
            + "se debe enviar el id_alumno";
    public static final String HELP_REGISTRARINSCRIPCION = "Registrar Inscripcion!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es registrar una inscripcion en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- fecha_inscripcion (String con Comillas Dobles) [\"dd-mm-aaaa\"]\n"
            + "- id_alumno (Entero)";
    public static final String HELP_MODIFICARINSCRIPCION = "Modificar Inscripcion!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar una inscripcion en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "- fecha_inscripcion (String con Comillas Dobles) [\"dd-mm-aaaa\"]\n"
            + "- id_alumno (Entero)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "fecha_inscripcion, id_alumno";
    public static final String HELP_ADICIONARGRUPOS = "Adicionar Grupos!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es adicionar grupos a la boleta de inscripcion en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "- id_grupo (Entero)\n"
            + "- mes (Entero)\n"
            + "- gestion (Entero)\n"
            + "- id_alumno (Entero)";
    public static final String HELP_RETIRARGRUPOS = "Retirar Grupos!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es retirar grupos a la boleta de inscripcion en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "- id_grupo (Entero)\n"
            + "- mes (Entero)\n"
            + "- gestion (Entero)\n"
            + "- id_alumno (Entero)";
    public static final String HELP_OBTENERCURSOS = "Obtener Cursos!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los cursos registrados en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    public static final String HELP_OBTENERPREREQUISITOS = "Obtener Prerequisitos!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los prerequisitos de cursos registrados en el sistema,\n"
            + "es necesario enviar el 'id' del curso";
    public static final String HELP_REGISTRARCURSO = "Registrar Curso!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es registrar a un curso en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- nombre (String con Comillas Dobles)\n"
            + "- descripcion (String con Comillas Dobles)\n"
            + "- estado (true, false)";
    public static final String HELP_MODIFICARCURSO = "Modificar Curso!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar a un curso en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "- nombre (String con Comillas Dobles)\n"
            + "- descripcion (String con Comillas Dobles)\n"
            + "- estado (true, false)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "nombre, descripcion, estado";
    public static final String HELP_OBTENERGRUPOS = "Obtener Grupos!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los grupos registrados en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    public static final String HELP_OBTENERHORARIOS = "Obtener Horarios!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los horarios registrados de los grupo en el sistema,\n"
            + "se debe enviar el id_grupo";
    public static final String HELP_REGISTRARGRUPO = "Registrar Grupo!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es registrar a un grupo en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- nombre (String con Comillas Dobles)\n"
            + "- id_curso (Entero)";
    public static final String HELP_MODIFICARGRUPO = "Modificar Grupo!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar a un grupo en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "- nombre (String con Comillas Dobles)\n"
            + "- id_curso (Entero)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "nombre, id_curso";
    public static final String HELP_ASIGNARGRUPO = "Asignar Grupo!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es asignar los grupos a profesores registrados en el sistema,\n"
            + "se debe enviar el id_grupo seguido del id_profesor";
    public static final String HELP_REGISTRARHORARIO = "Registrar Horario!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es registrar a un horario de un grupo en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id_grupo (Entero)\n"
            + "- dia (String con Comillas Dobles)\n"
            + "- hora_inicio (String con Comillas Dobles) [\"hh:mm\"]\n"
            + "- hora_fin (String con Comillas Dobles) [\"hh:mm\"]\n"
            + "- id_aula (Entero)";
    public static final String HELP_MODIFICARHORARIO = "Modificar Horario!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar a un profesor en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id_grupo (Entero)\n"
            + "- id (Entero)\n"
            + "- dia (String con Comillas Dobles)\n"
            + "- hora_inicio (String con Comillas Dobles) [\"hh:mm\"]\n"
            + "- hora_fin (String con Comillas Dobles) [\"hh:mm\"]\n"
            + "- id_aula (Entero)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "dia, hora_inicio, hora_fin, id_aula";
    public static final String HELP_ELIMINARHORARIO = "Eliminar Horario!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es eliminar los horarios registrados en el sistema,\n"
            + "se debe enviar el id del horario y su id_grupo";
    public static final String HELP_OBTENERAULAS = "Obtener Aulas!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar las aulas registrados en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    public static final String HELP_REGISTRARAULA = "Registrar Aula!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es registrar a un aula en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- nombre (String con Comillas Dobles)\n"
            + "- capacidad (Entero)";
    public static final String HELP_MODIFICARAULA = "Modificar Aula!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar a un profesor en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "- nombre (String con Comillas Dobles)\n"
            + "- capacidad (Entero)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "nombre, capacidad";
    public static final String HELP_OBTENERKARDEXS = "Obtener Kardexs!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los kardex de un alumno,\n"
            + "se debe de enviar el id del alumno";
    public static final String HELP_OBTENERASISTENCIAS = "Obtener Asistencias!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar las asistencias de una alumno en un grupo mediante su kardex,\n"
            + "se necesita enviar el id de su kardex del alumno";
    public static final String HELP_REGISTRARASISTENCIAS = "Registrar Asistencias!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es registrar una asistencia en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- estado (String con Comillas Dobles) [\"P\", \"A\"]\n"
            + "- fecha (String con Comillas Dobles) [\"dd-mm-aaaa\"]\n"
            + "- id_kardex (Entero)";
    public static final String HELP_MODIFICARASISTENCIAS = "Modificar Asistencias!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar una asistencia en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "- estado (String con Comillas Dobles) [\"P\", \"A\"]\n"
            + "- fecha (String con Comillas Dobles) [\"dd-mm-aaaa\"]\n"
            + "- id_kardex (Entero)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "estado, fecha, id_kardex";
    public static final String HELP_REGISTRARNOTA = "Registrar Nota!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es registrar una nota en un kardex del sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id_kardex (Entero)\n"
            + "- nota (String con Comillas Dobles) [\"A\",\"R\"]";
    public static final String HELP_REPORTEHISTORICO = "Reporte Historico!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los cursos ya inscritos con su nota respectiva,\n"
            + "se debe enviar el id de alumno";
    public static final String HELP_REPORTEALUMNOSINSCRITOS = "Reporte Alumnos Inscritos!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los alumnos inscritos en un grupo en un determinada gestion,\n"
            + "se necesita enviar datos de: id_grupo, mes y gestion";
    public static final String HELP_REPORTEOFERTACURSOS = "Reporte Oferta de Cursos!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar la oferta de cursos disponibles,\n"
            + "no es necesario enviar ningun parametros";
    public static final String HELP_AGREGARPREREQUISITO = "Agregar Prerequisito!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es agregar un prerequisito a un curso.\n"
            + "Sus parametros son: id_curso y id_prerequisito";
    public static final String HELP_QUITARPREREQUISITO = "Quitar Prerequisito!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es quitar un prerequisito a un curso.\n"
            + "Sus parametros son: id_curso y id_prerequisito";

}
