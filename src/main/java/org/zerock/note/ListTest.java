package org.zerock.note;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args) {

        ArrayList<NoteDTO> list
                = new ArrayList<>();

        list.add(NoteDTO.builder().no(1).who("A").whom("B").build());
        list.add(NoteDTO.builder().no(2).who("A").whom("B").build());
        list.add(NoteDTO.builder().no(3).who("B").whom("A").build());
        list.add(NoteDTO.builder().no(4).who("B").whom("A").build());
        list.add(NoteDTO.builder().no(5).who("A").whom("B").build());

        System.out.println(list.size());

        System.out.println(list);

        List<NoteDTO> blist =
        list.stream().filter(noteDTO -> noteDTO.getWhom().equals("B")).collect(Collectors.toList());

        System.out.println(blist);

//        list.remove(2); //3rd remove
        list.removeIf( noteDTO -> noteDTO.getNo() == 5);

        System.out.println(list);
        System.out.println(list.size());
    }

}
