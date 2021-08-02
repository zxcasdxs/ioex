package org.zerock.ex1;

import com.sun.source.tree.WhileLoopTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileFastCopy {

    public static void main(String[] args) {

        //try with resource
        try(InputStream fin = new FileInputStream(("C:\\zzz\\aaa.jpeg"));
            OutputStream fos = new FileOutputStream("C:\\zzz\\copy22.jpg");
        ) {
            byte[] arr = new byte[5]; //8kb
            while(true) {
                int count = fin.read(arr); // 몇 개나 새로운 데이터를 읽었나
                if(count == -1) {break;}
//                fos.write(arr, 0, count);
                fos.write(arr);
            }//while end



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
