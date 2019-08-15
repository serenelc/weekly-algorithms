import java.io.*;
import java.util.*;

public class jessAndCookies {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int numOperations = 0;
        
        for(int elem : A) {
            pq.add(elem);
        }

        while(pq.peek() < k) {
            if (pq.size() == 1) {
                numOperations = -1;
                break;
            }
            int newCookie = pq.poll() + pq.poll() * 2;
            pq.add(newCookie);
            numOperations++;
        }
        
        if (pq.size() == 0) {
            numOperations = -1;
        }

        return numOperations;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}