package org.zerock.note;

import javax.imageio.stream.ImageInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteService {

    private Map<String, ArrayList<NoteDTO>> notemap = new HashMap<>();
    private Integer idx = 0;


    public ArrayList<NoteDTO> getList(String owner){
        return notemap.get(owner);
    }

    public Integer add(NoteDTO noteDTO) {

        noteDTO.setNo(++idx);
        String owner = noteDTO.getWhom();


        ArrayList<NoteDTO> noteDTOS = notemap.get(owner);

        if (noteDTOS == null) {
            ArrayList<NoteDTO> noteList = new ArrayList<>();
            noteList.add(noteDTO);
            notemap.put(owner, noteList);
        } else {
            noteDTOS.add(noteDTO);
        }

        return idx;
    }

//    public static void main(String[] args) {
//
//        NoteService service = new NoteService();
//        NoteDTO noteDTO = NoteDTO.builder().who("user2").whom("user1").content("이해가 안가").build();
//        service.add(noteDTO);
//        NoteDTO noteDTO2 = NoteDTO.builder().who("user3").whom("user1").content("나도....").build();
//        service.add(noteDTO2);
//        NoteDTO noteDTO3 = NoteDTO.builder().who("user1").whom("user2").content("아직도 이해가 안가").build();
//        service.add(noteDTO3);
//
//        System.out.println(service.notemap);
//
//    }

}
