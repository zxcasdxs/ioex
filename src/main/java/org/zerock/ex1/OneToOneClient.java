package org.zerock.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneClient {

    //bad code
    public static void main(String[] args) throws Exception {

        Scanner keyScanner = new Scanner(System.in);
        Socket socket = new Socket("localhost", 9999);


        System.out.println("Connected....");

        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        Scanner inScanner = new Scanner(in);

        //문자열을 byte[] 바꿔서 out.write(바이트배열)

        for(int i = 0; i < 100; i++) {
            String msg = keyScanner.nextLine() + "\n";

            out.write(msg.getBytes());
            System.out.println("-----------------------");
            System.out.println(inScanner.nextLine());
        }
        out.close();
        socket.close();
    }
}
