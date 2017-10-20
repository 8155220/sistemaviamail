/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import utils.Constants;
import java.io.*;
import java.net.*;

/**
 *
 * @author mauriballes
 */
public class ClienteSMTP {

    private static final int PORT = 25; // SMTP

    public static void sendMail(String toMail, String subject, String content) {
        // Estableciendo variables
        BufferedReader reader;
        DataOutputStream writer;
        String command;

        try {
            // Estableciendo Conexion Socket
            Socket socket = new Socket(Constants.MAIL_SERVER_HOST, PORT);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new DataOutputStream(socket.getOutputStream());

            if (socket != null && reader != null && writer != null) {
                reader.readLine();
                //comienzA DEBUG
                System.out.println("COMIENZA DEBUG");
                // Saludar al servidor
               // command = "EHLO " + Constants.MAIL_SERVER_HOST + "\r\n"; //ORIGINAL
                command = "EHLO " + "backup" + "\r\n";
                System.out.println(command);
                writer.writeBytes(command);
                getMultiline(reader);
                //System.out.println(getMultiline(reader));//
                command = "MAIL FROM : " + Constants.MAIL_USERMAIL + "\r\n";
                System.out.println(command);
                writer.writeBytes(command);
                //System.out.println(reader.readLine());
                reader.readLine();//original

                command = "RCPT TO : " + toMail + "\r\n";
                System.out.println(command);
                writer.writeBytes(command);
                reader.readLine(); //original
                //System.out.println(reader.readLine());

                // Escribir Mensaje
                command = "DATA\n";
                System.out.println(command);
                writer.writeBytes(command);
                getMultiline(reader);
                //System.out.println(getMultiline(reader)); //
                command = "Subject: " + subject + "\r\n" + content + "\n.\r\n";
                System.out.println(command);
                writer.writeBytes(command);
                
                reader.readLine(); //ORIGINAL
                //System.out.println(reader.readLine());
                
                command = "QUIT\r\n";
                writer.writeBytes(command);
                reader.readLine();
                System.out.println("END DEBUG");
                System.out.println("Entro hasta el final sendmail");
            }

            // Cerrar Conexion
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    static protected String getMultiline(BufferedReader in) throws IOException {
        String lines = "";
        while (true) {
            String line = in.readLine();
            if (line == null) {
                // Server closed connection
                throw new IOException(" S : Server unawares closed the connection.");
            }
            if (line.charAt(3) == ' ') {
                lines = lines + "\n" + line;
                // No more lines in the server response
                break;
            }
            // Add read line to the list of lines
            lines = lines + "\n" + line;
        }
        return lines;
    }
}
