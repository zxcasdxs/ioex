package org.zerock.ex2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class GatewayServer {

    //bad code
    public static void main(String[] args) throws Exception{

        Map<String, String> ipMap = new HashMap<>();

        ipMap.put("A", "Hyun-9999.asuscomm.com");
        ipMap.put("B", "ip");
        ipMap.put("C", "ip");
        ipMap.put("D", "ip");


        ServerSocket serverSocket = new ServerSocket(9998);
        System.out.println("Ready...");

        while (true) {

            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            DataInputStream din = new DataInputStream(in);
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            String str = din.readUTF();

            System.out.println("CLIENT MSG : " + str);

            Socket subSocket = new Socket(ipMap.get(str), 9999);
            DataOutputStream subDos = new DataOutputStream(subSocket.getOutputStream());
            DataInputStream subDin = new DataInputStream(subSocket.getInputStream());

            subDos.writeUTF(str);

            String msg = subDin.readUTF();


            dos.writeUTF(msg);
            dos.flush();

        }//while end
    }
}
