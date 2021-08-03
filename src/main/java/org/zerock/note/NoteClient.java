package org.zerock.note;

import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.net.Socket;

public class NoteClient {

    //bad code
    public static void main(String[] args) throws Exception {

        NoteDTO data = NoteDTO.builder().who("B").whom("A").content("커피한잔? 콜").build();
        Command command = Command.builder().oper("READ").noteDTO(data).build();

        Gson gson = new Gson();

        String str = gson.toJson(command);

        Socket socket = new Socket("localhost", 9999);
        DataOutputStream dataOutputStream
                = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF(str);


    }
}
