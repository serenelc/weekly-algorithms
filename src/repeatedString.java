import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class repeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
      long numAs = 0;
      if (n < s.length()) {
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
            numAs++;
            }
        }
      } else {
        for (char c : s.toCharArray()) {
            if (c == 'a') {
            numAs++;
            }
        }

        long numRepeats = n / (long) s.length();
        long remainder = n % (long) (s.length() * numRepeats);
        numAs = numAs * numRepeats;

        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
            numAs++;
            }
        }
      }

      return numAs;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
