

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class stooge
{
    public static int count = 0;
    static void stoogesort(int arr[], int l, int h, int cnt) {

        if (l >= h) {
            return;
        }
        if (arr[l] > arr[h])
        {
            int t = arr[l];
            arr[l] = arr[h];
            arr[h] = t;
            count = count + 1;
        }
        if (h-l+1 > 2) {
            int t = (h-l+1) / 3;
            stoogesort(arr, l, h-t, cnt + 1);
            stoogesort(arr, l+t, h, cnt + 1);
            stoogesort(arr, l, h-t, cnt + 1);
        }

    }

    public static void main(String args[]) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("File.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                long start = System.currentTimeMillis();
                String[] strArray = line.split(" ");
                int[] intArray = new int[strArray.length];
                for(int i = 0; i < strArray.length; i++) {
                    intArray[i] = Integer.parseInt(strArray[i]);
                }
                int n = intArray.length; 
                stoogesort(intArray, 0, n-1, 0);

                System.out.println(count+" - количество итераций");
                count = 0;
//                System.out.println(Arrays.toString(intArray));
                long finish = System.currentTimeMillis();
                long elapsed = finish - start;
                System.out.println(n + "\t" + elapsed);
            }
            System.out.println(count);
        }
        catch(IOException e) {
            System.out.print("Error :" + e);
        }
    }
}



