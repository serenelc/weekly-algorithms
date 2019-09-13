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
      // 1 2 5 3 7 8 6 4
      // 1 2 3 4 5 6 7 8
      // 1 2 3 4 5 7 6 8: 7 bribes
      // 1 2 3 4 5 7 8 6: 8 bribes
      // 1 2 3 5 4 7 8 6: 5 bribes
      // 1 2 3 5 7 4 8 6: 7 bribes
      // 1 2 3 5 7 8 4 6: 8 bribes
      // 1 2 5 3 7 8 4 6: 5 bribes
      // 1 2 5 3 7 8 6 4: 6 bribes
      
      int numBribes = 0;
      for (int i = 0; i < q.length; i++) {
        int val = q[i];
        if (val == i + 3 || val == i - 3) {
          numBribes = numBribes + 2;
        } else if (val == i + 2 || val == i + 2) {
          numBribes++;
        } else if (val > i + 3 || val < i - 3) {
          System.out.println("Too chaotic");
          numBribes = -1;
          break;
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
