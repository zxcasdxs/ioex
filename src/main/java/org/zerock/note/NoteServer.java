package org.zerock.note;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NoteServer {

    //bad code
    public static void main(String[] args) throws Exception {

        NoteService service = new NoteService();

        //serverSocket
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("ready....");
        //loop
        while (true) {

            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream =
                    new DataInputStream(socket.getInputStream());
            String msg = dataInputStream.readUTF();

            Gson gson = new Gson();

            Command command = gson.fromJson(msg, Command.class);

            System.out.println(command);

            String oper = command.getOper();

            if (oper.equalsIgnoreCase("ADD")) {
                service.add(command.getNoteDTO());
            } else if(oper.equalsIgnoreCase("READ")) {
                String owner = command.getNoteDTO().getWhom();
                System.out.println(service.getList(owner));
            }
        }

        //socket

        //DataInputStream readUTF() => 문자열

        //Gson => 문자열을 Command 객체로 변환

        //Command 객체의 oper 값이 ADD면 service.add( ) 
    }
}
