package org.zerock.ex2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class DataClient {

    //bad code
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Your Message");

        String msg = scanner.nextLine();

        Socket socket = new Socket("localhost", 9998);

        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        InputStream in = socket.getInputStream();
        DataInputStream din = new DataInputStream(in);

        dos.writeUTF(msg);
        System.out.println("------------------------");
        String serverMsg = din.readUTF();
        System.out.println(serverMsg);
    }
}
