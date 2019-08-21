import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class buildAList {

    public static void main (String[] args) {
        List<int[]> generated = generate(5, 2);
        generated.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public static List<int[]> generate(int n, int r) {

        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];

        // initialize with lowest lexicographic combination
        for (int i = 0; i < r; i++) {
            combination[i] = i;
        }

        while (combination[r - 1] < n) {
            combinations.add(combination.clone());

            // generate next combination in lexicographic order
            int t = r - 1;
            while (t != 0 && combination[t] == n - r + t) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < r; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }

        return combinations;
    }


}

/* Model Java solution

import java.io.*;
        import java.util.*;

public class Solution {

    private static Map<Character,Integer> mapping = new HashMap<Character,Integer>();

    private static void doMapping(String input){

        char[] arr = input.toCharArray();
        for(int i = 0; i < arr.length; i++){
            mapping.put(arr[i],i);
        }
    }

    private static void generate(String input){

        char[] arr = input.toCharArray();
        int cycle = input.length();
        int leng = input.length()-1;
        List<String> one = new ArrayList<String>();
        List<String> two = new ArrayList<String>();
        Set<String> ready = new TreeSet<String>();

        for(int i = 0; i < arr.length; i++){
            one.add(String.valueOf(arr[i]));
            ready.add(String.valueOf(arr[i]));
        }
        cycle--;
        int from = Integer.MAX_VALUE;
        int len = 0;
        String temp;
        char thisch;

        while(cycle > 0){
            for(int i = 0; i < one.size(); i++){
                temp = one.get(i);
                thisch = temp.charAt(len);
                from = Integer.parseInt(String.valueOf(mapping.get(temp.charAt(len))));

                if(from == leng) continue;
                for(int j = from+1; j < input.length(); j++){
                    two.add(temp.concat(String.valueOf(arr[j])));
                }
            }
            for(int j = 0; j < two.size(); j++){
                ready.add(two.get(j));
            }
            one = new ArrayList<String>();

            for(int j = 0; j < two.size(); j++){
                one.add(two.get(j));
            }
            two = new ArrayList<String>();
            cycle--;
            len++;
        }

        Iterator<String> it = ready.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) throws IOException{

        int T;
        int N;
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        T = Integer.parseInt(line);

        for(int i = 0; i < T; i++){
            mapping = new HashMap<Character,Integer>();
            line = br.readLine();
            line = br.readLine();
            doMapping(line);
            generate(line);
        }
    }
} */