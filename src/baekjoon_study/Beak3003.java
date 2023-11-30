package ch00_백준;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Beak3003 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);

        int[] pins = {1, 1, 2, 2, 2, 8};
        List<Integer> findPins = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < pins.length; i++) {
            int n = sc.nextInt();
            bw.write(n);
            findPins.add(n);
        }

        for (int i = 0; i < pins.length; i++) {
            result.add(pins[i] - findPins.get(i));
        }

        for (int i = 0; i < result.size(); i++) {
            bw.write(String.valueOf(result.get(i)));
            bw.write(" ");
        }

        bw.flush();
        bw.close();
        sc.close();
    }
}
