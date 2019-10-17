import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class anagram {

    static int makeAnagram(String a, String b) {
        int numRemove = 0;

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            int indexOfChar = b.indexOf(c);
            if (indexOfChar == -1) {
                //b doesn't have character c, so remove c from a
                numRemove++;
            } else {
                //b does have character c, so remove c from b to avoid
                // duplicate checking
                b = b.substring(0, indexOfChar) + b.substring(indexOfChar + 1);
            }
        }

        numRemove += b.length();

        return numRemove;
    }

    public static void main(String[] args) {
        int res = makeAnagram("cde", "abc");
        System.out.println(res);
    }
}
