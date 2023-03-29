

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class DataGenerator {
    public static void main(String[] args) {
        Random r = new Random();
        try {
            File file = new File("File.txt");
            if (!file.exists())
                file.createNewFile();
            int line_count = 100;
            int array_len = 10;
            PrintWriter pw = new PrintWriter(file);
            for (int i = 0; i < line_count; i++) {
                for (int j = 0; j < array_len; j++) {
                    pw.print("" + (r.nextInt(10000) + 1) + " ");
                }
                pw.print("\n");
                array_len += 1000;
            }
            pw.close();

        } catch(IOException e) {
            System.out.print("Error :" + e);
        }
    }
}