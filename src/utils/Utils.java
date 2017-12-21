/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import vista.Block;
import vista.Board;
import vista.Table;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class Utils {

    public static Date convertirFechas(String fecha) {
        // Formato de fecha a ingresar dd-MM-yyyy
        Date fechaNueva = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date fechaJava = formato.parse(fecha);
            fechaNueva = new Date(fechaJava.getTime());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return fechaNueva;
    }

    public static String getDestinatario(String contenido) {
        String destinatario = "";
        // Dividir en lineas
        String[] lines = contenido.split("\n");
        int index = -1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > 5
                    && lines[i].substring(0, 5).toUpperCase().equals("FROM:")) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            // Quitar la palabra 'From: '
            destinatario = lines[index].substring(6);
            lines = destinatario.split(" ");
            if (lines.length == 1) { // Correo del Server
                destinatario = lines[0];
            } else { // Desde otro Servidor de Correo
                destinatario = lines[lines.length - 1];
                destinatario = destinatario.split("<")[1].split(">")[0];
            }
        }
        return destinatario;
    }

    public static String getSubjectOrden(String contenido) {
        String orden = "";
        // Dividir en lineas
        String[] lines = contenido.split("\n");
        int index = -1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > 8
                    && lines[i].substring(0, 8).toUpperCase().equals("SUBJECT:")) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            // Quitar la palabra 'Subject: '
            orden = lines[index].substring(8);
        }
        return orden;
    }

    public static String dibujarTabla(DefaultTableModel tabla) {
        String tableString = "";
        ArrayList<String> headers = new ArrayList<>();
        ArrayList<List<String>> rowList = new ArrayList<>();

        // Agregando Los Headers
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            headers.add(tabla.getColumnName(i));
        }

        // Agregando Content
        for (int i = 0; i < tabla.getRowCount(); i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                row.add(String.valueOf(tabla.getValueAt(i, j)));
            }
            rowList.add(row.subList(0, row.size()));
        }

        if (rowList.size() < 1) {
            return "(Tabla Vacia)";
        }

        // Creando Tabla para mostrar
        Board board = new Board(300);
        Table table = new Table(board, 300, headers, rowList);
        Block tableBlock = table.tableToBlocks();
        board.setInitialBlock(tableBlock);
        board.build();
        tableString = board.getPreview();

        return tableString;
    }

    public static String dibujarTablaHTML(DefaultTableModel tabla) {
        String html = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Title</title>\n"
                + "</head>\n"
                + "<body>"
                + "<table class=\"table table-hover\">\n"
                + "        <tr>";
        String tableString = "";
        ArrayList<String> headers = new ArrayList<>();
        ArrayList<List<String>> rowList = new ArrayList<>();

        // Agregando Los Headers
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            headers.add(tabla.getColumnName(i));
            html += "<th>" + tabla.getColumnName(i) + "</th>";
        }
        html += "<tbody>";

        // Agregando Content
        for (int i = 0; i < tabla.getRowCount(); i++) {
            ArrayList<String> row = new ArrayList<>();
            html += "<tr>";
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                row.add(String.valueOf(tabla.getValueAt(i, j)));
                html += "<td class=\"table-text\">";
                html += String.valueOf(tabla.getValueAt(i, j));
                html += "</td>";
            }
            rowList.add(row.subList(0, row.size()));
            html += "</tr>";
        }
        html += "</tbody>\n"
                + "    </table>";

        if (rowList.size() < 1) {
            return "(Tabla Vacia)";
        }

        // Creando Tabla para mostrar
        Board board = new Board(300);
        Table table = new Table(board, 300, headers, rowList);
        Block tableBlock = table.tableToBlocks();
        board.setInitialBlock(tableBlock);
        board.build();
        tableString = board.getPreview();

        html += "</body>\n"
                + "</html>";
        return html;
    }

    public static String quitarComillas(String texto) {
        int len = texto.length() - 1;
        return texto.substring(1, len);
    }

    public static String checkbox() {
        return "<form action=\"/action_page.php\">\n"
                + "  <input type=\"checkbox\" name=\"vehicle\" value=\"Bike\"> I have a bike<br>\n"
                + "  <input type=\"checkbox\" name=\"vehicle\" value=\"Car\" checked> I have a car<br>\n"
                + "  <input type=\"submit\" value=\"Submit\">\n"
                + "</form>";
    }

    public static String testHtml() {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<title>Page Title</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "\n"
                + "<h1>My First Heading</h1>\n"
                + "<p>My first paragraph.</p>\n"
                + "\n" + " <?php echo \"helloworld \"?>"
                + "</body>\n"
                + "</html>";
    }

    public static String encuestaHtml() {
        return "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Title</title>\n"
                + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\" integrity=\"sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb\" crossorigin=\"anonymous\">\n"
                + "    </head>\n"
                + "<body>\n"
                + "<form class=\"form-horizontal\" method=\"POST\" action=\"http://www.google.com\">\n"
                + "\n"
                + "    <table class=\"table table-hover\">\n"
                + "        <tr>\n"
                + "            <th>No</th>\n"
                + "            <th>Pregunta</th>\n"
                + "            <th>Si/No</th>\n"
                + "        </tr>\n"
                + "\n"
                + "        <input type=\"hidden\" name=\"idtipousuario\"  value=\"1005\">\n"
                + "\n"
                + "        <tbody>\n"
                + "\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                1\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <!--{{\\App\\CasoDeUso::findOrFail($detalle_tipousuario_cdu->idcdu)->descripcion}}-->\n"
                + "                Tiene un listado de los equipos de computacion de la facultad, y su asignacion.\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"1\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"1\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                2\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <!--{{\\App\\CasoDeUso::findOrFail($detalle_tipousuario_cdu->idcdu)->descripcion}}-->\n"
                + "                Los Sistemas Operativos y Software con ofimaticos y de gestion se instalan con la configuracion basica\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"2\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"2\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                3\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <!--{{\\App\\CasoDeUso::findOrFail($detalle_tipousuario_cdu->idcdu)->descripcion}}-->\n"
                + "                Las Redes Cableadas o inalambricas con permiten conectarse de manera automatica y acceso a la red LAN\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"3\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"3\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                4\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <!--{{\\App\\CasoDeUso::findOrFail($detalle_tipousuario_cdu->idcdu)->descripcion}}-->\n"
                + "                Se comparten carpetas de manera generica osea lo que se desea compartir\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"4\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"4\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                5\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <!--{{\\App\\CasoDeUso::findOrFail($detalle_tipousuario_cdu->idcdu)->descripcion}}-->\n"
                + "                Los usuarios no se autentican para ingresar al computador\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"5\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"5\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                6\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <!--{{\\App\\CasoDeUso::findOrFail($detalle_tipousuario_cdu->idcdu)->descripcion}}-->\n"
                + "                Existe un Responsable o Departamento de Seguridad Informatica\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"6\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"6\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                7\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <!--{{\\App\\CasoDeUso::findOrFail($detalle_tipousuario_cdu->idcdu)->descripcion}}-->\n"
                + "                Las Medidas Basicas de Seguridad esta dada por el reconocimiento en la especialidad de seguridad de la informacion, personal de hardware y software y procedimiento\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"7\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"7\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                8\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Se realiza la instalacion y actualización de software como ser antivirus, antispyware, Firewall y otros\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"8\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"8\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                9\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <!--{{\\App\\CasoDeUso::findOrFail($detalle_tipousuario_cdu->idcdu)->descripcion}}-->\n"
                + "                Se realiza Respaldo y Recuperacion de datos, y la guarda adecuada de los datos en otro lugar\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"9\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"9\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                10\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Administran herramientas de Hardware y Software para el soporte tecnico\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"10\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"10\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                11\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <!--{{\\App\\CasoDeUso::findOrFail($detalle_tipousuario_cdu->idcdu)->descripcion}}-->\n"
                + "                Existen documentos donde se especifiquen las procedimientos, funciones, medidas, normas, politicas y obligaciones de los usuario\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"11\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"11\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                12\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <!--{{\\App\\CasoDeUso::findOrFail($detalle_tipousuario_cdu->idcdu)->descripcion}}-->\n"
                + "                Existen documentos que expliquen como llevar procesos, hardware y software; asi como las responsabilidades del personal y de los usuario\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"12\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"12\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                13\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Existen informacion sobre confidencialidad, integridad, disponibilidad, autenticacion, autorizacion, firmas electronicas, etc.\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"13\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"13\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                14\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <!--{{\\App\\CasoDeUso::findOrFail($detalle_tipousuario_cdu->idcdu)->descripcion}}-->\n"
                + "                Existe la bitacora sobre acciones que realizan los usuarios cuando acceden a datos u  informacion, sobre incidentes de seguridad y eventos para mejor la seguridad\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"14\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"14\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                15\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "\n"
                + "                Existen Cursos, Charlas, Seminarios y Reuniones sobre Etica y cultura de seguridad informatica\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"15\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"15\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                16\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Se realizan Auditoria externas como internas en el marco de la seguridad informatica\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"16\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"16\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                17\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Se tiene planificado Desarrollar un plan Estrategico donde su vision, mision y politicas incluyan la seguridad informatica\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"17\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"17\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                18\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Se tiene planificado la capacitacion al personal administrativo, docentes y estudiantes sobre seguridad informatica, Control de acceso a Fisico y Logico\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"18\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"18\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                19\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Se adopta y cumple las politicas relativas a confidencialidad, integridad, disponibilidad, autenticacion , autorizacion y cualquier medida de seguridad que se considere necesaria\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"19\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"19\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                20\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Se identifica en el personal y los usuarios las conductas relacionadas cono los valores y ética de seguridad informática\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"20\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"20\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                21\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                El Responsable de Seguridad Informática, genera políticas, informa y controla la aplicación en los diferentes niveles de la facultad\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"21\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"21\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                22\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Existe una cultura organizacional de la seguridad informatica y se exigen valores eticos\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"22\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"22\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                23\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Existen grupos de trabajos que promueven y consolidan y fomentan el desarrollo de la seguridad informatica con administradores y usuarios\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"23\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"23\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                24\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Se realizan de forma periodica el analisis de la gestion de riesgo en la organizacion\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"24\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"24\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                25\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Se realiza una revision de los controles y de ataques ocurridos, estadisticas que permiten planificar medidas preventivas y correctivas\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"25\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"25\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                26\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Se realizaron reuniones para la revision  de la medias y politicas de seguridad\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"26\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"26\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                27\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <!--{{\\App\\CasoDeUso::findOrFail($detalle_tipousuario_cdu->idcdu)->descripcion}}-->\n"
                + "                Existen mecanismo para la promocion y valoracion de las aptitudes con respecto a la seguridad informatica\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"27\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"27\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                28\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Existe un sistema que permita hacer seguimiento a las politicas, aprobacion y difusion.\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"28\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"28\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                29\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Se tiene el porcentaje de ejecucion del plan estrategico son respecto a la seguridad de la informacion\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"29\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"29\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td class=\"table-text\">\n"
                + "                30\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                Existen reportes sobre uso y ataques a las redes, y estadistica que se puedan consultar en linea\n"
                + "            </td>\n"
                + "            <td class=\"table-text\">\n"
                + "                <div class=\"togglebutton\">\n"
                + "                    <label>\n"
                + "                        <input type=\"hidden\" name=\"30\"  value=\"0\">\n"
                + "                        <input type=\"checkbox\" name=\"30\" value=\"1\">\n"
                + "                    </label>\n"
                + "                </div>\n"
                + "            </td>\n"
                + "\n"
                + "        </tr>\n"
                + "        </tbody>\n"
                + "\n"
                + "    </table>\n"
                + "\n"
                + "    <div class=\"form-group\">\n"
                + "        <div class=\"col-md-6 col-md-offset-4\">\n"
                + "            <button type=\"submit\" class=\"btn btn-primary\">\n"
                + "                Guardar\n"
                + "            </button>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</form>\n"
                + "</body>\n"
                + "</html>";
    }
}
