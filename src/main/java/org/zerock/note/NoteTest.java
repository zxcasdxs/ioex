package org.zerock.note;

import com.google.gson.Gson;

public class NoteTest {

    public static void main(String[] args) {

//        NoteDTO dto = NoteDTO.builder().who("A").whom("B").content("밥먹자").build();
//
//        Gson gson = new Gson();
//
//        String jsonStr = gson.toJson(dto);
//
//        System.out.println(jsonStr);
//
//        NoteDTO result =  gson.fromJson(jsonStr, NoteDTO.class);
//
//        System.out.println(result);

        //add
        NoteDTO data = NoteDTO.builder().who("A").whom("B").content("커피한잔?").build();

        Command command = Command.builder().oper("ADD").noteDTO(data).build();

        System.out.println(command);

        Gson gson = new Gson();

        String jsonStr = gson.toJson(command);

        System.out.println(jsonStr);
    }
}
