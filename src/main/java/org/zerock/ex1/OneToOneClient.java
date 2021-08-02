package org.zerock.ex1;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneClient {

    //bad code
    public static void main(String[] args) throws Exception {

        Scanner keyscanner = new Scanner(System.in);
        Socket socket = new Socket("localhost", 9999);


        System.out.println("Connected....");

        OutputStream out = socket.getOutputStream();

        //문자열을 byte[] 바꿔서 out.write(바이트배열)

        String msg = keyscanner.nextLine()+"\n";

        out.write(msg.getBytes());

        out.close();
        socket.close();
    }
}
