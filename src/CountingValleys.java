import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int base = 0;
        int numValleys = 0;
        // String journey = "";

        for (char c : s.toCharArray()) {
                if (c == 'U') {
                  base++;
                } else {
                  base--;
                }

                if (base == 0 && c == 'U') {
                  numValleys++;
                }
        }

        // for (int i = 0; i < s.length(); i++) {
        //     journey += s.charAt(i);
        //     if (s.substring(i, i+1).equals("U")) {
        //         base++;
        //     } else {
        //         base--;
        //     }
        //
        //     if (base == 0) {
        //         if (journey.startsWith("D")) {
        //             numValleys++;
        //         }
        //         journey = "";
        //     }
        // }

        return numValleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
