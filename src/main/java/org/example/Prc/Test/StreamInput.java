package org.example.Prc.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @program: NacosLearn
 * @description: 文件流的读取
 * @author: 占翔昊
 * @create 2020-10-21 15:56
 **/
public class StreamInput {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> lists = Arrays.asList("zxh","nwy");
        FileOutputStream fileOnputStream = new FileOutputStream("1.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOnputStream);
        out.writeObject(lists);

        FileInputStream fileInputStream = new FileInputStream("1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        List<String> l = (List<String>) objectInputStream
                .readObject();

        l.forEach(System.out::println);
        out.close();
        fileInputStream.close();
    }
}
