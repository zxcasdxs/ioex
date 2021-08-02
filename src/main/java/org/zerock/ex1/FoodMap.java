package org.zerock.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class FoodMap {
    public static void main(String[] args) throws Exception {



        String[][] arr = {{"불고기", "냉면", "비빔밥"},
                        {"회", "초밥", "라멘"},
                        {"샐러드", "파스타", "스테이크"},
                        {"김밥", "떡볶이", "튀김"}
        };

        Random random = new Random();


        Map<String, String[]> foodMap = new HashMap<>() ;
        foodMap.put("korean", arr[0]);
        foodMap.put("japan", arr[1]);
        foodMap.put("western", arr[2]);
        foodMap.put("snack", arr[3]);


        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Ready....");

        while (true) {


            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress());

            InputStream in = socket.getInputStream();
            Scanner inScanner = new Scanner(in);

            String msg = inScanner.nextLine();
            int ranNum = random.nextInt(arr[0].length);
            String[] foodArr = (foodMap.get(msg));
            System.out.println(foodArr[ranNum]);

            String sendMsg = "SERVER : " + foodArr[ranNum];
            OutputStream out = socket.getOutputStream();

            out.write(sendMsg.getBytes());
            out.flush();


            out.close();
            inScanner.close();
            in.close();
            socket.close();

        }//while end
    }
}
