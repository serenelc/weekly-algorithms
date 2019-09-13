import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

      int numBribes = 0;
      for (int i = 0; i < q.length; i++) {

        // Can only bribe forward
        if (q[i] > i + 3) {
          System.out.println("Too chaotic");
          numBribes = -1;
          break;
        }

        // All you need to do is to count the number of people who overtake a person.
        for (int j = Math.max(q[i] - 2, 0); j < i; j++) {
          if (q[j] > q[i]) {
            numBribes++;
          }
        }

      }

      if (numBribes >= 0) {
        System.out.println(numBribes);
      }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
