package multyTreadHomeWork;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Stream;

/**Создать класс поток, который создает средствами
        Java файл и записать в него произвольно сгенерированный
        массив из 10 случайных целых чисел. Запустить 5 потоков.
*/

public class Task54 {
    final static String MyFilePath = "task54.txt";

    public Task54(int countThread) {
        String nameTread;
        try {
            createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= countThread; i++) {
            Thread54 t1 = new Thread54();
            nameTread = "My thread for t.54 " + i;
            t1.setName(nameTread);
            System.out.println("Создан поток: "+ nameTread);
            t1.start();
        }
    }

    void createNewFile() throws IOException {
        File path = new File(MyFilePath);
        if (!path.createNewFile()) {
            path.delete();
            path.createNewFile();
        }
    }

    public static synchronized void writeToMyFile(ArrayList <Integer>arrayList, String threadName) throws FileNotFoundException {
        FileWriter f = null;
        try {
            f = new FileWriter(MyFilePath,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stream<Integer> stream = arrayList.stream();
        FileWriter finalF = f;
        stream.forEach(x -> {
            try {
                finalF.write(x.toString());
                finalF.write(" \twritten by "+threadName);
                finalF.append('\n');
                finalF.flush();
                 } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
