import java.util.ArrayList;
import java.util.List;

public class ModifiedKaprekarNumbers {

//    https://www.hackerrank.com/challenges/kaprekar-numbers/problem

    static void kaprekarNumbers(int p, int q) {
        List<Integer> kaprekar = new ArrayList<>();
        for (int i = p; i < q + 1; i++) {
            if (isKaprekar(i)) {
                kaprekar.add(i);
            }
        }
        if (kaprekar.isEmpty()) {
            System.out.print("INVALID RANGE");
        }
        else {
            for (int k : kaprekar) {
                System.out.print(k + " ");
            }
        }
    }

    static boolean isKaprekar(int k) {
//        The right hand part must be k.length digits long. The left is the remaining substring

        int length = String.valueOf(k).length();

        String squared = String.valueOf((long) Math.pow(k, 2));
        int squaredLength = squared.length();

        Integer left;
        Integer right;

        int lengthOfLeft = squaredLength - length;
        if (lengthOfLeft <= 0) {
            left = 0;
            right = Integer.parseInt(squared);
        }
        else if (lengthOfLeft == 1) {
            left = Integer.parseInt(squared.substring(0, 1));
            right = Integer.parseInt(squared.substring(1));
        }
        else {
            left = Integer.parseInt(squared.substring(0, lengthOfLeft));
            right = Integer.parseInt(squared.substring(lengthOfLeft));
        }

        Integer sum = (left + right);
        return sum == k;
    }

    public static void main(String[] args) {
        kaprekarNumbers(1, 100);
    }

}


