import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
      int minSwaps = 0;
      //strategy is to move lowest number not in correct position and swap with
      //the number in its correct position

      Integer[] integerArr = new Integer[arr.length];
      for (int i = 0; i < arr.length; i++) {
        integerArr[i] = (Integer) arr[i];
      }

      for (int i = 0; i < arr.length; i++) {
        int minIndex = Arrays.asList(integerArr).indexOf(i + 1);
        if (minIndex != i) {
          Integer temp = integerArr[i];
          integerArr[i] = i + 1;
          integerArr[minIndex] = temp;
          minSwaps++;
        }
        if (isSorted(integerArr, i)) {
          break;
        }
      }

      System.out.println(Arrays.toString(integerArr) + ", min swaps:" + minSwaps);
      return minSwaps;
    }

    static boolean isSorted(Integer[] arr, int index) {
      for (int i = index; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          return false;
        }
      }
      return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
