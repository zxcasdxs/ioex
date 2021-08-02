package org.zerock.ex1;

import javax.print.attribute.standard.Severity;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneServer {

    //bad code
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Ready....");

        Socket client = serverSocket.accept();

        System.out.println("client connected....");

        InputStream in = client.getInputStream();
        Scanner inScanner = new Scanner(in);

        String line = inScanner.nextLine();

        System.out.println(line);

        inScanner.close();
        in.close();
        client.close();
        serverSocket.close();

    }//m end
}//c end
